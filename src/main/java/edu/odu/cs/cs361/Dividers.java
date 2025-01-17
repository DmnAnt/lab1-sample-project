package edu.odu.cs.cs361;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Steven Zeil, Old Dominion University
 * 4/30/2024
 **/

public class Dividers {

    private static void solve(int N, Scanner in) {
        String[] names = new String[N];
        for (int i = 0; i < N; i++) {
            String name = in.next();
            name = name.toUpperCase();
            names[i] = name;
        }
        Arrays.sort(names);

        int mid = names.length / 2;
        String result = Utilities.findSeparator(names[mid - 1], names[mid]);
        System.out.println(result);
    }

    private static void dividers(BufferedReader in) {
        Scanner input = new Scanner(in);
        int N = input.nextInt();
        while (N > 0) {
            solve(N, input);
            N = input.nextInt();
        }
        input.close();
    }

    // Accept input from standard in or from a file
    // named as a command parameter.
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader in;
        if (args.length > 0)
            in = new BufferedReader(new FileReader(args[0]));

        else {
            in = new BufferedReader(new InputStreamReader(System.in));
        }
        dividers(in);
    }
}