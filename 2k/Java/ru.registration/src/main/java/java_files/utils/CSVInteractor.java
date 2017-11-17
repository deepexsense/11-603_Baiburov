package java_files.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVInteractor {
    public static void add(String[] data, FileWriter fw) throws IOException {
        for(int i = 0; i < data.length - 1; i++) {
            fw.write(data[i] + ",");
        }
        fw.write(data[data.length-1] + "\r\n");
        fw.close();
    }

    public static List<String[]> getAll(FileReader fr) throws IOException {
        BufferedReader reader = new BufferedReader(fr);
        List<String[]> strings = new ArrayList<>();
        String line = reader.readLine();
        while (line !=null) {
            strings.add(parse(line));
            line = reader.readLine();
        }
        reader.close();
        return strings;
    }

    private static String[] parse(String s) {
        return s.split(",");
    }
}
