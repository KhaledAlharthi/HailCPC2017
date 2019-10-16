/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication35;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Khaled
 */
public class JavaApplication35 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner scanner = new Scanner (new FileReader("cute.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            char x = scanner.next().toLowerCase().charAt(0);
            switch (x){
                // If x is vowel print 'Vowel', otherwise print 'Consonant'
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("Vowel");
                    break;
                default:
                    System.out.println("Consonant");
            }
        }
    }
   
    
}
