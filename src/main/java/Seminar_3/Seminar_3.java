package Seminar_3;

import java.util.*;

public class Seminar_3 {
    public static void main(String[] args) {
        ex0();
        ex2();
    }

    private static void ex0() {
    }


    private static void ex1() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

        }
    }

    // Задача 2. Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
    // Вывести название каждой планеты и количество его повторений в списке.
    // Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.

    private static void ex2() {
        String[] planetsNamesStringArray = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Neptune", "Uranus", "Pluto"};
        // Массив со списком планет преобразую в список для удобства последующей работы
        List<String> listPlanet = new ArrayList<>();
        for (int i = 0; i < planetsNamesStringArray.length; i++) {
            listPlanet.add(planetsNamesStringArray[i]);
        }

        // Отсортируем планеты по алфавиту
        listPlanet.sort(Comparator.naturalOrder());

        // Собственно создаю список на 100 элементов с повторяющимися названиями планет солнечной системы
        List<String> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(planetsNamesStringArray[random.nextInt(planetsNamesStringArray.length)]);
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);

        // создал еще один список в который поместил значения индексов первых вхождений каждой планеты в созданном
        // большом списке с повторениями названий планет.
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < listPlanet.size(); i++) {
            int indexPlanet = list.indexOf(listPlanet.get(i));
            counts.add(indexPlanet);
        }
        counts.add(list.size());
        System.out.println(counts.toString());
        for (int i = counts.size()-1; i >= 0; i--) {
            if(counts.get(i) < 0){
                int num = counts.get(i );
                counts.set(i+1,num);
            }
        }

        // Ну и собственно выводим в консоль то, что требуется по условию задачи. Количество повторений для каждой планеты.
        for (int i = 0; i < listPlanet.size(); i++){
           if(counts.get(i)< 0){
               int num = counts.get(i+1);
               counts.set(i,num);
           }
            System.out.printf("%s встречается в списке %d раз.%n", listPlanet.get(i), (counts.get(i+1) - counts.get(i)));
        }

        // Удаляем из списка все повторения.
        for (int i = 0; i < list.size() -1; i++) {
            String first = list.get(i);
            String second= list.get(i+1);
            if (second.equals(first)) {
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}

