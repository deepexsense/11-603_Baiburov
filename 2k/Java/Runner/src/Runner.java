import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class Runner implements ActionListener, KeyListener {

    public static Runner run;
    private Renderer renderer;
    private final int WIDTH = 800, HEIGHT = 600;
    private ArrayList<Object> obstacle;
    private Random random;
    private int timeout = 0, drop = 0;
    private boolean Over, Play;
    private int score = 0;
    private int highScore = 0;
    private Image background;
    private int action = 0;
    private Object runner;
    private int cd = 0;
    private int nrSpace = 0;
    private String image = "C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\Runner\\src\\sprites\\Hero.png";

    private Runner() {
        JFrame jFrame = new JFrame();
        renderer = new Renderer();
        jFrame.add(renderer);
        random = new Random();
        runner = new Object(100, HEIGHT - 125, 90, 90, image);
        obstacle = new ArrayList<Object>();
        obstacle.add(new Object(-100, HEIGHT - 110, 70, 70,"C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\Runner\\src\\sprites\\Elka.png"));
            background = new ImageIcon("C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\Runner\\src\\sprites\\background.png").getImage();
        jFrame.setTitle("Runner");
        Timer timer = new Timer(20, this);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(WIDTH, HEIGHT);
        jFrame.addKeyListener(this);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        timer.start();

        addObstacle(true);
        addObstacle(true);
    }

    private void addObstacle(boolean start) {
        int widthC = 30 + random.nextInt(60);
        int difObs = 450 + random.nextInt(650);
        if(start)
            obstacle.add(new Object(WIDTH + widthC + obstacle.size() * difObs, HEIGHT - 110, widthC, 70,"C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\Runner\\src\\sprites\\Elka.png"));
        else {
            obstacle.add(new Object(obstacle.get(obstacle.size()-1).x + difObs, HEIGHT - 110, widthC, 70,"C:\\Users\\user\\Desktop\\11-603_Baiburov\\2k\\Java\\Runner\\src\\sprites\\Elka.png"));
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(Play) {
            int spead = 17;
            for (int i = 0; i < obstacle.size(); i++) {
                Object aux = obstacle.get(i);
                aux.x -= spead;
            }
            for (int i = 0; i < obstacle.size() && !Over; i++) {
                Object aux = obstacle.get(i);
                if (aux.x + aux.widt < 0) {
                    obstacle.remove(aux);
                    addObstacle(false);
                }
            }
            runner = new Object(100, HEIGHT - 125, 90, 90, image);
            timeout++;
            if(timeout % 3 == 0)
                score = score + 1;
            if (((timeout % 2) == 0) && (drop < 18)) {
                drop = drop + 30;
            }
            if (drop < 18) {
                if (action == 0) {
                    runner.y += drop;
                } else {
                    runner.y -= drop;
                }
            } else {
                runner.y = HEIGHT - 125;
            }
            if (runner.y == HEIGHT - 125) {
                action = 0;
            }
        }
            for(Object colum: obstacle){
                if(colum.intersects(runner) ){
                    Over = true;
                    Play = false;
                }
            }
        renderer.repaint();
        }

    public void repaint(Graphics g) {
        g.drawImage(background,0,0,null);
        g.setColor(Color.gray);
        g.fillRect(0, HEIGHT - 45, WIDTH, 5);
        if(!Over) {
            g.drawImage(runner.imj, runner.x, runner.y,null);
        }

        for (Object colum : obstacle) {
                g.drawImage(colum.imj,colum.x,colum.y,colum.widt,colum.heigh,null);
        }

        g.setColor(Color.white.darker() );
        g.setFont(new Font("Arial",1,25));
        if(!Play){
            g.drawString("Use Space to jump",280,100);
        }
        g.setColor(Color.gray.brighter());
        g.setFont(new Font("Arial",1,20));
        if(!Over && Play){
            g.drawString("HIGH SCORE:"+String.valueOf(highScore)+ " " + String.valueOf(score),WIDTH - 220,40);

        }
        g.setColor(Color.white.darker().darker());
        g.setFont(new Font("Arial",1,100));
        if(Over) {
            g.drawString("Game Over", 120, HEIGHT / 2 - 50);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && runner.y == HEIGHT - 125 && !Over){
            jump();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE && Over){
            nrSpace++;
            action = 1;
            if(nrSpace == 2) {
                jump();
            }
        }
    }
    private void jump() {
        if(Over) {
            nrSpace = 0;
            Over = false;
            runner = new Object(100, HEIGHT - 125, 90, 90, image);
            obstacle.clear();
            addObstacle(true);
            addObstacle(true);
            if(score > highScore)
            highScore = score;
            score = 0;
            drop = 0;
        }
        if(!Play)
            Play = true;
        else if(!Over){
            if(drop > 0){
                drop = 0;
            }
            drop -= cd;
            if(cd < 100) {
                cd += 20;
                jump();
            }
            else{
               cd = 0;
            }
        }
    }
    public static void main(String[] args) {
        run = new Runner();
    }
}

