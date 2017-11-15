import java.net.*;
import java.io.*;

public class Server extends Thread {
    private static final int port = 8080;
    private String message = "The client '%d' sent me message: \n\t";
    private String connection = "The client '%d' closed connection";

    private Socket socket;
    private int num;

    public Server(){

    }
    public void setSocket(int num, Socket socket){

        this.num = num;
        this.socket = socket;

        setDaemon(true);

        setPriority(NORM_PRIORITY);
        start();
    }

    public void run() {
        try{
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream dis = new DataInputStream(sin);
            DataOutputStream dos = new DataOutputStream(sout);

            String line = null;
            while(true){
                line = dis.readUTF();
                System.out.println(String.format(message, num ) + line);
                System.out.println("I'm sending it back...");
                dos.writeUTF("Server receive text : " + line);
                dos.flush();
                System.out.println();
                if (line.equalsIgnoreCase("quit")){
                    socket.close();
                    System.out.println(String.format(connection, num));
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Exception: " + e);
        }
    }

    public static void main(String[] args) {
        ServerSocket srvSock = null;
        try{
            try{
                int i = 0;
                InetAddress adr = InetAddress.getByName("localhost");
                srvSock = new ServerSocket(port, 0, adr);

                System.out.println("Server started\n\n");

                while(true){
                    Socket socket = srvSock.accept();
                    System.err.println("Client accepted");
                    new Server().setSocket(++i, socket);
                }
            } catch (Exception e){
                System.out.println("Exception: " + e);
            }
        }finally {
            try {
                if (srvSock != null){
                    srvSock.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.exit(0);
    }
}
