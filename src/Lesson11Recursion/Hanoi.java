package Lesson11Recursion;

import java.util.Scanner;

public class Hanoi {

    static int nummoves=0;
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of rings (3-10): ");
        int numrings = s.nextInt();
        if(numrings < 3 || numrings > 10){
            System.out.println("Invalid input - program will now end.");
            return;
        }
        
        //call moves - requires number of rings, going from where to where
        //and which ring is the in-between step
        move(numrings, 1, 3, 2);
        System.out.println("Total moves = " + nummoves);
    }
    
    public static void move(int n, int i, int j, int k){
        //stop doing it when we are down to 0 rings
        if ( n> 0){
            nummoves++;
            move(n-1, i, k, j);//move calls itself note j & k reversed            
            System.out.println("Move ring " + n + " from peg " + i + " to peg " + j);
            //move calls itself again - back from k to j
            move(n-1, k, j, i);
        }
    }
    
}
