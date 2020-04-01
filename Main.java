import file.ReadFile;
import hash.*;
import java.util.Scanner;

/**
 * Implementasi Hash dan Linkedlist di java
 * 
 * @author Aqil Fiqran Dzi'Ul Haq
 * @since 30-Maret-2020
 */
public class Main {
    public static void main(String q[]) {
        ReadFile file = new ReadFile("data/data.txt");
        HashTable hash = new HashTable(file.getLine().size());
        file.getLine().forEach((line) -> {
            String[] data = line.split("::");
            hash.add(data[0], data[1]);
        });

        Scanner user = new Scanner(System.in);
        while (true) {
            menu();
            System.out.print("\nPilihan : ");
            String option = user.nextLine();
            if (option.equals("1"))
                hash.display();
            else if (option.equals("2")) {
                System.out.print("\nEditor : ");
                hash.searchKey(user.nextLine());
            } else if (option.equals("3"))
                break;
            else
                System.out.println("\nPilihan tidak ada\n");

        }
    }

    /**
     * method untuk menampilkan menu
     */
    private static void menu() {
        System.out.println("[=]-------------------------------[=]");
        System.out.println(" |              Menu               |");
        System.out.println("[=]-------------------------------[=]");
        System.out.println(" | 1. Tampilkan semua editor       |");
        System.out.println(" | 2. Tampilkan editor yang dicari |");
        System.out.println(" | 3. Keluar                       |");
        System.out.println("[=]-------------------------------[=]");
    }
}