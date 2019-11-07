package com.sherstnyov;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prufer = sc.nextLine();
        PruferCode pruferCode = new PruferCode();
        System.out.println(pruferCode.getAdjacencyLists(prufer));
    }
}
