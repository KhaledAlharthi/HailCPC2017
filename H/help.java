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
        Scanner scanner = new Scanner (new FileReader("help.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int n = scanner.nextInt();
            int sum = 0;
            // A boolean flag donating the player that made the last move.
            // If the first player is the one who made the last move this flag will be True
            boolean flag = false;
            int j;
            for (j = 0; j < n; ++j){
                int z = scanner.nextInt();
                sum += z;
                // If sum is a multiple of 3, stop the game and decalre the winner.
                if (sum % 3 == 0){
                    System.out.println(flag ? "First" : "Second");
                    break;
                }
                // Change player.
                flag = !flag;
            }
            if (j == n)
                System.out.println("Draw");
        }
    }
   
   
}
