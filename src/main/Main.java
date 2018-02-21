package main;

//https://stepik.org/lesson/43221/step/1?adaptive=true&unit=21285

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner operation = new Scanner(System.in);

        OwnHashTable table = new OwnHashTable();
        
        int i = 0;
        
        while (i < 7) {

            String symbol = operation.next();
            String word = operation.next();
                       
            switch (symbol) {
                case "+":
                     table.add(word);
                     break;
                case "-":
                    table.remove(word);
                    break;
                case "?":
                    System.out.println(table.check(word) ? "OK" : "FAIL");
                    break;
                default: break;
            }
           
            i++;
        }
        
       
    }
}
