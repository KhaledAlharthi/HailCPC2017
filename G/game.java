/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Khaled
 */
public class JavaApplication34 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here        
        Scanner scanner = new Scanner (new FileReader("game.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int n = scanner.nextInt();
            int[] ID = new int[n];
            for (int j = 0; j < n; ++j){
                ID[j] = scanner.nextInt();
            }
            int minimum = getMinimum(ID, n);
            System.out.println(minimum);
        }
    }
   
    
    static int getMinimum (int[] ID, int n){
        Arrays.sort(ID);
        int min = 0;
        int i = 0;
        for (int j = n-1; j > i; --j){
            min += Math.pow ((ID[i++]+ID[j]), 2); 
        }
        return min;
    }
    
}
