/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
       Scanner scan = new Scanner(new FileReader("best.in"));
       int T = scan.nextInt();
       for (int i = 0; i < T; ++i){
           long L = scan.nextLong();
           long R = scan.nextLong();
           long sum = 0;
           for (long j = L; j <= R; ++j){
               sum += score(j);
           }
           System.out.println(sum);
       }
    }
    
    static int score (long x){
        int score = 0;
        for (int i = 2; i < x; ++i){
            // Cheking if x has K such as K^i = x
            if (hasK(x, i)){
                score += i;
            }
        }
        return score;
    }
    
    
    static boolean hasK(long x, double n){
        // K can be explained as the nth-root of x.
        double k = Math.pow(x,  1.0/n);
        // Rounding K
        double rational_k = Math.round(k);
        // Raise K to n
        double new_x = Math.pow(rational_k, n);
        // If x == (K^n) return True, otherwise return False.
        return new_x == x;
    }    
}
