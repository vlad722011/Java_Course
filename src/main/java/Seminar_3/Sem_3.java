package Seminar_3;

import java.util.*;

public class Sem_3 {
    public static void main(String[] args) {
        ex0();
        ex1();
    }
    private static void ex1() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

    private static void ex0() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[] { 'h', 'e', 'l', 'l', 'o' });

        System.out.println(s1 == s2); //t
        System.out.println(s1 == s3); //t
        System.out.println(s1 == s4); //t
        System.out.println(s1 == s5); //f
        System.out.println(s1 == s6); //f


        System.out.println(s1.equals(s5));
        System.out.println(Objects.equals(s6, s1));

        String space = "  f  \s   \n  \t";
        System.out.println(space.isEmpty());
        System.out.println(space.isBlank());
        System.out.println(space.trim().length() == 0);
    }


}
