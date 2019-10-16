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
        Scanner scanner = new Scanner (new FileReader("interesting.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            char[][] grid = new char[N][M];
            for (int j = 0; j < N; ++j){
                String str = scanner.next();
                for (int k = 0; k < M; ++k){
                    char c = str.charAt(k);
                    grid[j][k] = c;
                }
            }
            String result = "";
            int min = Integer.MAX_VALUE;
            
            
            
            // Check horizontally smallest word
            for (int j = 0; j < N; ++j){
                String word = "";
                for (int k = 0; k < M; ++k){
                    char c = grid[j][k];
                    if (c == '*')
                        break;
                    else
                        word += c;
                }
                // Check if word is lexographically sorted, if yes get sum of chars
                int sum = getSumIfLexSorted (word);
                // Check if this is the smallest word I've seen
                if (sum < min){
                    min = sum;
                    result = word;
                }                
            }
            
            // Check vertically smallest word
            for (int j = 0; j < M; ++j){
                String word = "";
                for (int k = 0; k < N; ++k){
                    char c = grid[k][j];
                    if (c == '*')
                        break;
                    else
                        word += c;
                }
                // Check if word is lexographically sorted, if yes get sum of chars
                int sum = getSumIfLexSorted (word);
                // Check if this is the smallest word I've seen
                if (sum < min){
                    min = sum;
                    result = word;
                }                
            }
            
            
            // Print smallest word
            System.out.println(result);
        }
    }
    
    
    // Returns the sum of chars if the string is lexographically sorted
    static int getSumIfLexSorted (String str){
        if (str.length() < 2) return Integer.MAX_VALUE;
        char c = 'Z';
        int sum = 0;
        for (int i = 0; i < str.length(); ++i){
            char c2 = str.charAt(i);
            if (c2 < c)
                return Integer.MAX_VALUE;
            sum += c;
            c =   c2;          
        }
        return sum;
    }
}
