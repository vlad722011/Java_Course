package Seminar_5;

import java.util.HashMap;

public class ConverterArabianAndRoman {

    public static void main(String[] args) {
        String arabianToRoman = ArabianToRoman(2999);
        System.out.println(arabianToRoman);
        int romanToArabian = RomanToArabian("MMCMXCIX");
        System.out.println(romanToArabian);
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
}