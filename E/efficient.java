/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication36;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Khaled
 */
public class JavaApplication36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        Scanner scanner = new Scanner (new FileReader ("efficient.in"));
        int T = scanner.nextInt();
        while (T-->0){
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int F = scanner.nextInt();
            int K = scanner.nextInt();
            int curGas = F;
            Station[] stations = new Station[K];
            // Calculate distance from house to work.
            int dist = dist(1,1,N,M);
            int i;
            // Read stations, and convert 2D map to 1D array.
            for (i = 0; i < K; ++i){
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                double c = scanner.nextDouble();
                int pos = dist(1, 1, x, y);
                stations[i] = new Station(pos, c);
            }
            // Sort stations by distance.
            Arrays.sort(stations);

            // Find cheapest station to each station.
            int[] s = new int[200];
            int[] nextCheaper = new int[200];
            int j = 0;
            for (i = K-1; i >= 0; i--) {
                // Go through all stations, is there a station which is cheaper than the current?
                while (j > 0 && stations[ s[j-1] ].cost >= stations[i].cost) {
                        j--;
                }
                // Save cheaper station, or -1 if none.
                nextCheaper[i] = (j == 0 ? -1 : s[j-1]);
                // Save this station's position
                s[j] = i;
                j++;
            }
            
            
            // Move to the first station
            curGas -= stations[0].pos;
            double cost = 0;
            for (i = 0; i < K; i++) {
                // ** Calculate the amount of gas neede for the next point **
                // Is there's a cheaper station? if yes, than I'll calculate the enough amount to take me there
                // If there's no cheaper station, then I'll fill the tank.
                int required_gas = Math.min(F, (nextCheaper[i] == -1 ? dist : stations[nextCheaper[i]].pos) - stations[i].pos);
                if (required_gas > curGas) {
                        // If I require more than I have then I'll buy fuel at this station.
                        cost += (required_gas - curGas) * stations[i].cost;
                        curGas = required_gas;
                }
                // Move to the next station, or reach work.
                curGas -= (i == K-1 ? dist : stations[i+1].pos) - stations[i].pos;
            }
            System.out.printf("%.3f%n", cost);
        }
    }
    
    
    static int dist (int x1, int y1, int x2, int y2){
        return (x2-x1) + (y2-y1);
    }
    
}
class Station implements Comparable {
        int pos;
        double cost;
        Station (int pos, double cost){
            this.pos = pos;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Object t) {
            int next_pos = ((Station) t).pos;
            if (pos == next_pos) return 0;
            else if (pos < next_pos) return -1;
            else return 1;
        }
}