package Seminar_2;

import java.io.*;
public class Seminar_2 {
    public static void main(String[] args) {
        ex1();
        ex2();
        String string = "А роза упала на лапу Азора";
        System.out.println(ex3(string));
        ex4();
    }

    // Задача 1
    // Дано число N (>0) и символы 'A' и 'B'. 
    // Написать метод, который вернет строку длины N, которая состоит из чередующихся символов 'A' и 'B', начиная с 'A'.

    private static void ex1() {
        int number = 7;
        int count = 0;
        char one = 'A';
        char two = 'B';
        StringBuilder sb = new StringBuilder();
        while (count < number) {
            if (count % 2 == 0) {
                sb.append(one);
                count++;
            } else {
                sb.append(two);
                count++;
            }
        }
        System.out.println(sb.toString());
    }

    // Задача 2
    // Напишите метод, который сжимает строку.
    // Пример: вход aaaabbbcdd.
    private static void ex2() {
        String str = "aaaabbbcdd";
        int count = 1;
        StringBuilder sb = new StringBuilder();
        char temp = str.charAt(0);
        sb.append(temp);
        for (int i = 1; i < str.length(); i++) {
            temp = str.charAt(i);
            if (temp == str.charAt(i - 1)) {
                count++;
            } else {
                if (count != 1) {
                    sb.append(count);
                    sb.append(temp);
                    count = 1;
                }
            }
        }
        sb.append(count);
        sb.append(temp);
        System.out.println(sb.toString());
    }

    // Задача 3
    // Напишите метод, который принимает на вход строку (String) и определяет является
    // ли строка палиндромом (возвращает boolean значение).
    private static boolean ex3(String str) {
        char[] chars = str.toCharArray();
        char left = ' ';
        char right = ' ';
        String one = "";
        String two = "";
        int i;
        for (i = 0; i < chars.length / 2; i++)
            left = str.charAt(i);
        right = str.charAt(chars.length - 1 - i);
        one += left;
        two += right;
        if (!one.equals(two)){
            return false;
        }
        return true;
    }

    // Задача 4
    // Напишите метод, который составит строку, состоящую из 100 повторений слова TEST
    // и метод, который запишет эту строку в простой текстовый файл, обработайте исключения.
    private static void ex4() {
        String str ="TEST";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++){
            sb.append(str);
        }
        String result = sb.toString();

    }
}
