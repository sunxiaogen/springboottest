package com.sxg.test.scanner;

import java.util.Scanner;

public class demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        String str = scanner.nextLine();
        System.out.println(str);
        scanner.close();
    }
}
