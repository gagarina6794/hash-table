package main;

public class OwnHashTable implements HandMadeCollection {

    private int size = 10;
    private String[] table = new String[size];
    private String[] newTable = new String[size];
    private int rehashSize = 0;

    public OwnHashTable() {
        for (int i = 0; i < size; i++) {
            this.table[i] = null;
        }
    }

    private int hash(String word, int entry) {
        int hashWord = word.hashCode();
        return (hashWord + (entry * entry)) % size;
    }

    private void rehash() {
        rehashSize = 0;

        for (int i = 0; i < size; i++) {
            newTable[i] = null;
        }

        newTable = table.clone();
        size = size * 2;
        table = new String[size];

        for (int i = 0; i < size; i++) {
            table[i] = null;
        }

        for (String word : newTable) {
            if (word != null && !word.equals("DELETED")) {
                add(word);
            }
        }
    }

    @Override
    public void add(String word) {
        int entry = 0;
        do {
            int hash = hash(word, entry);
            if (table[hash] == null) {
                table[hash] = word;
                rehashSize++;
                if (rehashSize > size * 0.75f) {
                    rehash();
                }
                return;
            }
            if (table[hash].equals(word)) {
                return;
            }
            entry++;

        } while (entry < size);

        // hash table is full
        throw new RuntimeException("Hash table need resize");

    }

    @Override
    public void remove(String word) {
        int entry = 0;
        do {
            int hash = hash(word, entry);
            if (table[hash] == null) {
                return;
            } else {
                if (table[hash].equals(word)) {
                    table[hash] = "DELETED";
                }
                entry++;
            }
        } while (entry < size);
    }

    @Override
    public boolean check(String word) {
        int entry = 0;

        do {
            int hash = hash(word, entry);
            if (table[hash] == null) {
                return false;
            } else {
                if (table[hash].equals(word)) {

                    return true;
                }
                entry++;
            }
        } while (entry < size);

        return false;
    }

    @Override
    public void print() {

        for (String n : table) {
            System.out.println(n);

        }
        System.out.println("-----------");
        for (String n : newTable) {
            System.out.println(n);

        }
    }

}