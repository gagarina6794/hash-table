package main;

//https://stepik.org/lesson/43221/step/1?adaptive=true&unit=21285
public class Main {
    
    public static void main(String[] args) {
        
        String my1 = "one";
        String my2 = "two";
        String my3 = "three";
        String my4 = "four";
        String my5 = "five";
        String my6 = "six";
        String my7 = "seven";
        String my8 = "eight";
        OwnHashTable myTable = new OwnHashTable();
        
        myTable.add(my1);
        myTable.add(my2);
        myTable.add(my3);
        myTable.remove("one");
        myTable.remove("two");
        myTable.add(my4);
        myTable.add(my5);
        myTable.add(my6);
        myTable.add(my7);
        myTable.add("1");
        myTable.add("one");
        myTable.add("2");
        myTable.remove("2");
        
        myTable.print();
        System.out.println("-----------------");
        System.out.println(myTable.check("one"));
        
    }
}
