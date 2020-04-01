package hash;

/**
 * Kelas untuk membangun hashtable
 * 
 * @author Aqil Fiqran Dzi'Ul Haq
 * @since 30-Maret-2020
 */
public class HashTable {
    Linkedlist[] hash;

    /**
     * method untuk penginisialisasi hashtable
     * 
     * @param size size dari Linkedlist
     */
    public HashTable(int size) {
        this.hash = new Linkedlist[size];
    }

    /**
     * method untuk add editor dan title
     * 
     * @param editor nama editor
     * @param title  titlenya
     * @see Linkedlist#add(String, String)
     * @see HashTable#key(String)
     */
    public void add(String editor, String title) {
        int index = this.key(editor);
        if (hash[index] == null)
            hash[index] = new Linkedlist();
        hash[index].add(editor, title);
    }

    /**
     * method untuk menampilkan semua editor dan title
     * 
     * @see HashTable#display(int)
     */
    public void display() {
        for (int a = 0; a < hash.length; a++) {
            this.display(a);
        }
    }

    /**
     * method untuk menampilkan editor berdasarkan hashkeynya
     * 
     * @param index hash key
     * @see Linkedlist#display(int)
     */
    public void display(int index) {
        if (this.hash[index] != null)
            this.hash[index].display(0);
    }

    /**
     * method untuk mencari hash key
     * 
     * @param editor hash key editor
     * @return hash key
     */
    private int key(String editor) {
        int uplowchar = (int) Math.pow(2, 8);
        int digit = 1;
        int index = 0;
        for (char i : editor.toCharArray()) {
            index = (index + (i + 1) * digit) % hash.length;
            digit = (digit * uplowchar) % hash.length;
        }
        return index;
    }

    /**
     * method untuk mencari editor
     * 
     * @param editor nama editor
     * @see Node
     * @see Node#getData()
     * @see Linkedlist#search(String)
     * @see HashTable#key(String)
     * @see Data#display()
     * @see Data#getFreq()
     */
    public void searchKey(String editor) {
        int index = this.key(editor);
        if (this.hash[index] != null) {
            Node current = this.hash[index].search(editor);
            if (current != null) {
                System.out.println("Artikel : " + current.getData().getFreq());
                current.getData().display();
            } else
                System.out.println("\nEditor tidak ditemukan\n");
        } else
            System.out.println("\nEditor tidak ditemukan\n");
    }
}
