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
        Scanner scanner = new Scanner (new FileReader("distinguished.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int sum = 0;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for (int j = n; j <= m; ++j){
                if (isTheSame (j)){
                    sum++;
                }
            }
            System.out.println(sum);
        }
       
    }
    
    static boolean isTheSame (int n){
        int nr = -1;
        int original = n;
        while (n > 0){
            // Get last digit.
            int last_digit = (n%10);
            // If I encountered a number that's not 6, 8 or 9 then I know number will not be the same.
            if (last_digit != 8 
                    && last_digit != 9 
                    && last_digit != 6){
                return false;
            }
            // Rotate 9 and 6
            if (last_digit == 9)
                last_digit = 6;
            else if (last_digit == 6)
                last_digit = 9;
            // Add the last digit to the rotated number.
            if (nr == -1){
                nr = last_digit;
            }else{
                nr = (nr*10) + last_digit;
            }
            // Prepare for next digit.
            n = n/10;
        }     
        // Return True the rotated number (nr) equals the original.
        return nr == original;
    }
    
}
