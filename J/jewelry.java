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
        Scanner scanner = new Scanner (new FileReader("jewelry.in"));
        int T = scanner.nextInt();
        for (int i = 0; i < T; ++i){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] G = new int[n];
            int[] P = new int[m];
            for (int j = 0; j < n; ++j){
                G[j] = scanner.nextInt();
            }
            for (int j = 0; j < m; ++j){
                P[j] = scanner.nextInt();
            }
            Arrays.sort(G);
            Arrays.sort(P);
            int sum = 0;
            int k = m-1;
            for (int j = n-1; j >= (n-m); --j){
                sum += G[j] * P[k--];
            }
            System.out.println(sum);
        }
    }
}
