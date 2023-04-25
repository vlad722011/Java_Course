package Seminar_2;

import java.io.*;
public class Seminar_2 {
    public static void main(String[] args) {
        System.out.println("Задача 1. Моё решение.");
        ex1();
        System.out.println("Задача 1. Решение группы.");
        ex1_1();
        System.out.println("Задача 2. Моё решение.");
        ex2();
        System.out.println("Задача 2. Решение группы.");
        String str = "aaaabbbcdd";
        ex2_1(str);
        System.out.println("Задача 2. Решение преподавателя.");
        String longString = "aaaabbbcdd";
        ex2_2(longString);
        System.out.println("Задача 3. Моё решение.");
        String string = "А роза упала на лапу Азора";
        System.out.println(ex3(string));
        System.out.println("Задача 3. Решение группы.");
        String input = "А роза упала на лапу Азора";
        System.out.println(ex3(input));
        System.out.println("Задача 4");
        //ex4();
        System.out.println("Задача 5. Решение преподавателя.");
        String pathDir = "/home/vlad/IdeaProjects/Java_Course_GB/.idea";
        ex5(pathDir);
    }
    // Задача 1. Решение моё.
    // Дано число N (>0) и символы 'A' и 'B'. 
    // Написать метод, который вернет строку длины N, которая состоит из чередующихся
    // символов 'A' и 'B', начиная с 'A'.
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

    // Задача 1. Решение группы.
    // Дано число N (>0) и символы 'A' и 'B'.
    // Написать метод, который вернет строку длины N, которая состоит из чередующихся
    // символов 'A' и 'B', начиная с 'A'.
    private static void ex1_1() {
        char firstSymbol = 'A';
        char secondSymbol = 'B';
        StringBuilder sb = new StringBuilder();
        int n = 7;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append(firstSymbol);
            } else {
                sb.append(secondSymbol);
            }
        }
        System.out.println(sb);
    }

    // Задача 2. Моё решение.
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

    // Задача 2. Решение группы.
    // Напишите метод, который сжимает строку.
    // Пример: вход aaaabbbcdd. Выход: a4b3cd2
    // Если символ во входящей строке повторяется один раз подряд,
    // то количество этого символа в результирующей строке не указывается (только сам символ).
    // В примере выше это символ 'c'.
    public static void ex2_1(String input) {
        input += " ";
        char[] array = input.toCharArray();
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            char check = array[i];

            if (check != array[i + 1]) {
                result.append(check);
                if (count != 1) {
                    result.append(count);
                }
                count = 0;
            }
            count ++;
        }
        System.out.println(result);
    }

    // Решение преподавателя.
    private static void ex2_2(String longString) {
        StringBuilder shortStringSB = new StringBuilder();
        char prev = longString.charAt(0);
        char curr = prev;
        int counter = 1;
        for (int i = 1; i < longString.length(); i++) {
            prev = longString.charAt(i - 1);
            curr = longString.charAt(i);
            if (prev != curr) {
                shortStringSB.append(prev);
                shortStringSB.append((counter > 1) ? counter : "");
                counter = 0;
            }
            counter++;
        }
        shortStringSB.append(curr);
        shortStringSB.append((counter > 1) ? counter : "");

        System.out.printf("%s -> %s%n", longString, shortStringSB);
    }

    // Задача 3. Моё решение.
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

    // Задача 3. Решение группы.
    // Напишите метод, который принимает на вход строку (String) и определяет
    // является ли строка палиндромом (возвращает boolean значение).
    public static boolean ex3_1(String inputStr) {
        inputStr = inputStr.toLowerCase()
                .replace(" ", "")
                .replace("-","");
        for (int i = 0; i < inputStr.length() / 2; i++) {
            if (inputStr.charAt(i) != (inputStr.charAt(inputStr.length() - 1 - i))) {
                return false;
            }
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
        System.out.println(result);

    }

    // Задача 5. Решение преподавателя.
    // Напишите метод, который вернет содержимое текущей папки в виде массива строк.
    // Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
    // Обработайте ошибки с помощью try-catch конструкции.
    private static void ex5(String pathDir) {
        File file = new File(pathDir);
        if (!(file.exists() || file.isDirectory())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String fileName : file.list()) {
            sb.append(fileName).append(System.lineSeparator());
        }
        System.out.println(sb);

        try(PrintWriter pw = new PrintWriter("src/main/java/Files/filesNames.txt")) {
            pw.print(sb);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
