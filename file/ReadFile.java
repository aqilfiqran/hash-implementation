package file;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * kelas untuk readfile
 * 
 * @author Aqil Fiqran Dzi'Ul Haq
 * @since 30-Maret-2020
 */
public class ReadFile {
    ArrayList<String> line = new ArrayList<>();

    public ReadFile(String path) {
        try {
            File file = new File(path);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                line.add(sc.nextLine());
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("file not found..");
        }
    }

    public ArrayList<String> getLine() {
        return this.line;
    }
}