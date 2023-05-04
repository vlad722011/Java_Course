package Seminar_5;

import java.util.HashMap;
import java.util.Scanner;
public class CALC {

/*
Описание
        Создай консольное приложение "Калькулятор". Приложение должно читать из консоли введенные пользователем
        строки, числа, арифметические операции проводимые между ними и выводить в консоль результат их выполнения.
        Реализуй класс Main с методом public static String calc(String input). Метод должен принимать строку с
        арифметическим выражением между двумя числами и возвращать строку с результатом их выполнения. Ты можешь
        добавлять свои импорты, классы и методы. Добавленные классы не должны иметь модификаторы доступа
        (public или другие).

        Требования:
        1.	Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами:
        a + b, a - b, a * b, a / b. Данные передаются в одну строку (смотри пример)!
        Решения, в которых каждое число и арифмитеческая операция передаются с новой строки считаются неверными.
        2.	Калькулятор умеет работать как с арабскими (1,2,3,4,5...), так и с римскими (I,II,III,IV,V...) числами.
        3.	Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более. На выходе числа не
        ограничиваются по величине и могут быть любыми.
        4.	Калькулятор умеет работать только с целыми числами.
        5.	Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем
        строки вроде 3 + II калькулятор должен выбросить исключение и прекратить свою работу.
        6.	При вводе римских чисел, ответ должен быть выведен римскими цифрами, соответственно, при вводе
        арабских - ответ ожидается арабскими.
        7.	При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
        8.	При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций,
        приложение выбрасывает исключение и завершает свою работу.
        9.	Результатом операции деления является целое число, остаток отбрасывается.
        10.	Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль.
        Результатом работы калькулятора с римскими числами могут быть только положительные числа,
        если результат работы меньше единицы, выбрасывается исключение

        Пример работы программы:
        Input: 1 + 2   Output:  3
        Input: VI / III  Output: II
        Input: I - II  Output: throws Exception //т.к. в римской системе нет отрицательных чисел
        Input: I + 1 Output: throws Exception //т.к. используются одновременно разные системы счисления
        Input: 1 Output: throws Exception //т.к. строка не является математической операцией
        Input: 1 + 2 + 3 Output: throws Exception //т.к. формат математической операции не удовлетворяет
        заданию - два операнда и одно математическое действие.
        */

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String inputExpression = console.nextLine();
        String str = inputExpression.replaceAll("\\s+", "");

        String operation = FindOperation(str);
        System.out.println("Математическая операция во входящей строке: " + operation);

        // результат работы данного метода массив,состоящий из трех элементов. Первые два
        // элемента это числа участвующие в выражении. Третий элемент Показывает в какой системе
        // исчисления была входящая строка. При значении равном "0" - выражение во вхоящей строке
        // в десятичной системе исчисления. При значении равном  "-1" - выражение во входящей
        // строке с римскими цифрами.

        int[] arr = FindValues1AndValues2InInputString(str, operation);

        // результат работы данного метода  - массив состоящий из двух элементов. Первый элемент -
        // равен найденному результату выражения. Второй элемент - показывает какая была система
        // исчисления во входящей строке.
        int[] output = ExpressionEvaluation(arr, operation);

        // метод отвечающий за вывод результатов работы программы.
        PrintResult(output, arr);

    }

    // конвертер из арабских чисел в римские.
    public static String ArabianToRoman(int num) {
        String temp = "";
        int copyNum = num;
        while (copyNum > 1000) {
            if (copyNum > 1000 && copyNum < 4000) {
                temp += "M";
                copyNum -= 1000;
            }
        }
        num = copyNum;
        String value = "";
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        int key1 = 0;
        int key2 = 0;
        int[] arr = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        while (num > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                key1 = arr[i];
                key2 = arr[i + 1];
                if (key1 <= num && num < key2) {
                    value += map.get(key1);
                    num = num - key1;
                    key1 = 0;
                    key2 = 0;
                    i = arr.length - 2;
                }
            }
        }
        String result = temp + value;
        return result;
    }

    // конвертер из римских чисел в арабские (десятичная система исчисления).
    public static int RomanToArabian(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('O', 0);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int endIndex = str.length() - 1;
        char[] chars = str.toCharArray();
        int arabian;
        int result = map.get(chars[endIndex]);
        for (int i = endIndex - 1; i >= 0; i--) {
            arabian = map.get(chars[i]);
            if (arabian < map.get(chars[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    // определяем тип операции во входящей строке (сложение, вычитание, умножение, или все же деление).
    public static String FindOperation(String strInput) {
        String result = "";
        char[] chars = strInput.toCharArray();
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            temp += chars[i];
            if (temp.equals("+")) {
                result += "+";
                temp = "";
            } else if (temp.equals("-")) {
                result += "-";
                temp = "";
            } else if (temp.equals("*")) {
                result += "*";
                temp = "";
            } else if (temp.equals("/")) {
                result += "/";
                temp = "";
            }
            temp = "";
        }
        return result;
    }

    // находим числа участвующие в вычислении. Первое и второе. Плюс оставляем метку о
    // системе исчисления во входящей строке (третий элемент выходящего массива)
    public static int[] FindValues1AndValues2InInputString(String strInput, String operation) {
        int count = 0;
        String value = "";
        String temp = "";
        int[] array = new int[3];
        char[] chars = strInput.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length) {
                temp += chars[i];
                if (!(temp.equals(operation))) {
                    value += chars[i];
                    temp = "";
                } else if ((temp.equals(operation))) {
                    try {
                        int number = Integer.parseInt(value);
                        array[count] = number;
                        count += 1;
                        value = "";
                        temp = "";
                    } catch (RuntimeException exception) {
                        int number1 = RomanToArabian(value);
                        array[count] = number1;
                        count += 1;
                        value = "";
                        temp = "";
                    }

                }
            }
        }
        try {
            int number = Integer.parseInt(value);
            array[count] = number;
        } catch (RuntimeException exception) {
            int number2 = RomanToArabian(value);
            array[count] = number2;
            count += 1;
            value = "";
            temp = "";
            array[count] = -1;
        }
        return array;
    }
    // вычисляем результат,плюс в последнем элементе массива оставляем метку - какая была система
    //  исчисления во входящей строке (второй элемент выходящего массива).
    public static int[] ExpressionEvaluation(int[] array, String operation) {
        int[] res = new int[2];
        int result = 0;
        int number1 = array[0];
        int number2 = array[1];
        if (operation.equals("+")) result = number1 + number2;
        else if (operation.equals("-")) result = number1 - number2;
        else if (operation.equals("*")) result = number1 * number2;
        else if (operation.equals("/")) result = number1 / number2;
        res[0] = result;
        res[1] = array[2];
        return res;
    }
    public static void PrintResult(int[] array, int[] array2) {
        // если десятичная система
        if (array[1] == 0)
        {
            System.out.println("Первое число участвующее в выражении: " + array2[0]);
            System.out.println("Второе число участвующее в выражении: " + array2[1]);
            System.out.println("Результат вычисления выражения во входящей строке равен: -> " + array[0]);
        }
        // если во входящей строке римские цифры
        else if (array[1] == -1)
        {
            int result = array[0];
            if(result <= 0) {
                System.out.println("Римские числа не могут быть меньше единицы.");
                System.out.println("Вычислить данное выражение невозможно в данной системе исчисления.");
            }
            else if (result > 0) {
                String res = ArabianToRoman(array[0]);
                String number1 = ArabianToRoman(array2[0]);
                String number2 = ArabianToRoman(array2[1]);
                System.out.println("Первое число участвующее в выражении: " + number1);
                System.out.println("Второе число участвующее в выражении: " + number2);
                System.out.println("Результат вычисления выражения во входящей строке равен: -> " + res);
            }
        }
    }
}
