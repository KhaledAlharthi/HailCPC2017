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
        Scanner scanner = new Scanner (new FileReader("kotsh.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int N = scanner.nextInt();
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            boolean[][] grid = new boolean [N][N];
            
            // Paint all R rows 
            for (int j = 0; j < R; ++j){
                int x = scanner.nextInt();
                for (int k = 0; k < N; k++){
                    grid[x][k] = true;
                }
            }
            
            // Paint all C columns 
            for (int j = 0; j < C; ++j){
                int y = scanner.nextInt();
                for (int k = 0; k < N; ++k){
                    grid[k][y] = true;
                }
            }
                        
            // Calculate number of white cells (not painted = false)
            int counter = 0;
            for (int j = 0; j < N; ++j){
                for (int k = 0; k < N; ++k){
                    if (grid[j][k] == false){
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
    }
}
