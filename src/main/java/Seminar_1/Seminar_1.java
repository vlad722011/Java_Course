package Seminar_1;
import java.util.Arrays;
import java.util.Scanner;

public class Seminar1 {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        ex1();
        System.out.println("Задача 2");
        ex2();
        System.out.println("Задача 3");
        ex3();
        System.out.println("Задача 5");
        ex5();
        System.out.println("Задача 6");
        int a = 5;
        int b = 3;
        ex6(a, b);
        System.out.println("Задача 8");
        int [] nums = {1,7,3,6,5,6,3,29};
        ex8(nums);
    }




    // Задача 1
    // Написать программу, которая запросит у пользователя имя, и после выведет в консоль сообщение:
    // "Привет, 'Имя'".
    private static void ex1() {
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("Привет, " + str);
    }

    // Задача 2
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

    // Задача 3
    // Дан массив nums = [3,2,2,3] и число val = 3.
    // Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
    // Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного,
    // а остальные - равны ему.
    private static void ex3() {

        int[] arr = {3, 2, 2, 3};
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
        System.out.println(Arrays.toString(arr));
    }

    // Задача 5.
    // Во фразе "Добро пожаловать на курс по Java" переставить слова в обратном порядке.

    private static void ex5() {
        String str = "Добро пожаловать на курс по Java";
        String [] words = str.split(" ");
        System.out.println(Arrays.toString(words));
        String temp ="";
        for(int i = 0; i < words.length/2; i++ ){
            temp = words[i];
            words[i] = words[words.length-1 -i];
            words[words.length - 1 -i] = temp;
        }
        System.out.println(Arrays.toString(words));
    }

    // Задача 6
    // Реализовать функцию возведения числа а в степень b. a, b из Z.
    // Сводя количество выполняемых действий к минимуму.
    //Пример 1: а = 3, b = 2, ответ: 9
    //Пример 2: а = 2, b = -2, ответ: 0.25
    //Пример 3: а = 3, b = 0, ответ: 1

    private static void ex6(int x, int y) {
        int res = 1;
        while(y > 0){
            res *= x;
            y --;
        }
        System.out.println(res);
    }

    // Задан массив, например, nums = [1,7,3,6,5,6].
    //Написать программу, которая найдет индекс i для этого массива такой,
    // что сумма элементов с индексами < i равна сумме элементов с индексами > i.

    private static void ex8(int [] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        double hulfSum = (sum / 2);
        int sum1 = 0;
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum1 <= hulfSum){
                sum1 += arr[i];
                index = i;
            }
            else{
                break;
            }
        }
        int left = sum1 - arr[index];
        int right = sum - left - arr[index];
        if(right == left){
            System.out.printf("Искомый индекс в массиве равен %d.%n", index);
        }
        else {
            System.out.printf("Такого индекса в массиве нет");
        }
    }

}
