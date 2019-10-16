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
        Scanner scanner = new Scanner (new FileReader("aperfect.in"));
        int T = scanner.nextInt();
        String header = "Sun Mon Tue Wed Thr Fri Sat";
        for (int i = 0; i < T; ++i){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            System.out.println(header);
            // Calculate the number of rows to print.
            int rows = (int) Math.ceil((N+M-1)/7.0);
            // Calculate the number of days that will be in later month.
            int missing_stars = (rows*7) - (N+M-1);
            // Loop to print days in previous month
            for (int j = 0; j < M-1; ++j){
                System.out.print("*   ");
            }
            // Loop to print days of the month
            int day = 1;
            for (int j = M-1; j < (N+M-1); ++j){
                // Print day number
                System.out.print(day);
                // If this day is less than 10 print 2 spaces
                if (day < 10)
                    System.out.print("  ");
                else
                // If this day is greater than or equals to 10 print 1 space
                    System.out.print(" ");
                // Print a new line each 7 days
                if ((j+1) % 7 == 0){
                    System.out.println();
                }else{
                    // If we haven't completed 7 days yet, print 1 space
                    System.out.print(" ");
                }
                // Increment day number
                day++;
            }
            // Loop to print days in later month
            for (int j = 0; j < missing_stars; ++j){
                System.out.print("*  ");
                // If we haven't reached the last star, print 1 space
                if (j != missing_stars-1)
                    System.out.print(" ");
            }
            // If this is not the last test case, print new line
            if (i+1 != T)
                System.out.println();
        }
    }
    
    
   
}
