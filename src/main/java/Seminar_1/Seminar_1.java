package Seminar_1;
import java.util.Scanner;

public class Seminar_1 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }
    // Дан массив nums = [3,2,2,3] и число val = 3.
    // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    // Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
    // а остальные - равны ему.
    private static void ex3() {

        int[] arr = {3, 2, 2, 3, 5, 6, 6, 7};
        int val = 3;
        int temp;
        int indexEnd = arr.length - 1;
        int indexStart = 0;
        for (int i = 0; indexStart < indexEnd; i++) {
            if (arr[i] != val) {
                indexStart += 1;
            } else if (arr[i] == val) {
                if (arr[indexEnd] != val) {
                    temp = arr[indexEnd];
                    arr[indexEnd] = arr[indexStart];
                    arr[indexStart] = temp;
                    indexStart += 1;
                    indexEnd -= 1;
                } else {
                    indexEnd -= 1;
                }
            }
        }
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // Дан массив двоичных чисел, например [1,1,0,1,1,1], вывести максимальное количество подряд идущих 1.
    private static void ex2() {

        int[] arr = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        int count = 0;
        int max = 0;
        for (int num : arr) {
            if (num == 1) {
                count += 1;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        System.out.println(max);
    }

    // Написать программу, которая запросит у пользователя имя, и после выведет в консоль сообщение:
    // "Привет, 'Имя'".
    private static void ex1() {
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Привет, " + str);
    }
}
