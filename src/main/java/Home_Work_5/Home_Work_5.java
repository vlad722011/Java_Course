package Home_Work_5;

import java.util.*;

public class Home_Work_5 {
    public static void main(String[] args) {
        System.out.println("Решение задачи 1.");
        ex1();
        System.out.println();
        System.out.println("Решение задачи 2.");
        ex2();
    }


    // Задача 1. Реализуйте структуру телефонной книги с помощью HashMap,
    // учитывая, что 1 человек может иметь несколько телефонов.
    private static void ex1() {
        // Допустим у нас имеются сотрудники компании, для которых мы реализуем телефонный справочник
        String[] emp = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};
        List<String> nameEmployee = new ArrayList<>();
        nameEmployee.addAll(Arrays.asList(emp));
        System.out.println("Список сотрудников компании: ");
        System.out.println(nameEmployee.toString());
        System.out.println();

        // создаем телефонный справочник.
        TelBook phoneBook = new TelBook();

        // добавляем номера телефонов сотрудников компании в справочник
        phoneBook.addNumber("Иван Иванов", "+79141234567");
        phoneBook.addNumber("Иван Иванов", "+79241834592");
        phoneBook.addNumber("Иван Иванов", "+79528127345");
        phoneBook.addNumber("Светлана Петрова", "+79147654321");
        phoneBook.addNumber("Кристина Белова", "+79141234568");
        phoneBook.addNumber("Кристина Белова", "+79899182342");
        phoneBook.addNumber("Анна Мусина", "+7929345897653");
        phoneBook.addNumber("Анна Мусина", "+78939182345");
        phoneBook.addNumber("Анна Крутова", "+78998972323");
        phoneBook.addNumber("Иван Юрин", "+71927823678");
        phoneBook.addNumber("Петр Лыков", "+71982567823");
        phoneBook.addNumber("Павел Чернов", "+79547893434");
        phoneBook.addNumber("Петр Чернышов", "+78192785432");
        phoneBook.addNumber("Мария Федорова", "+77996997777");
        phoneBook.addNumber("Марина Светлова", "+78889994444");
        phoneBook.addNumber("Мария Савина", "+73332228899");
        phoneBook.addNumber("Мария Рыкова", "+79552356767");
        phoneBook.addNumber("Марина Лугова", "+72223336677");
        phoneBook.addNumber("Марина Лугова", "+72233224545");
        phoneBook.addNumber("Анна Владимирова", "+78687686868");
        phoneBook.addNumber("Иван Мечников", "+79994448776");
        phoneBook.addNumber("Петр Петин", "+76667875656");
        phoneBook.addNumber("Иван Ежов", "+77454561212");
        phoneBook.addNumber("Иван Ежов", "+79987654322");

        // Получаем номера телефонов всех сотрудников компании.
        for (int i = 0; i < nameEmployee.size(); i++) {
            String userName = nameEmployee.get(i);
            ArrayList<String> userNumbers = phoneBook.getNumbers(userName);
            System.out.printf("Номера телефонов сотрудника  %s: ", userName);
            System.out.println(userNumbers);
        }
        System.out.println();

        // Получение списка телефонных номеров определенного сотрудника, при необходимости.
        System.out.printf("Номера телефонов сотрудника  %s: ", "Кристина Белова");
        ArrayList<String> KristinaBelovaNumbers = phoneBook.getNumbers("Кристина Белова");
        System.out.printf(KristinaBelovaNumbers.toString());
        System.out.println();

        // Удаление номера телефона определенного сотрудника.
        // Например, удалим из телефонного справочника один из номеров сотрудника  - Кристина Белова.
        phoneBook.removeNumber("Кристина Белова", "+79899182342");
        System.out.println();
        System.out.println("Получение оставшихся телефонных номеров сотрудника, после удаления некоторых номеров:");
        KristinaBelovaNumbers = phoneBook.getNumbers("Кристина Белова");
        System.out.printf("Номера телефонов сотрудника  %s: ", "Кристина Белова");
        System.out.printf(KristinaBelovaNumbers.toString());
        System.out.println();

    }

    // Это класс - телефонный справочник, который содержит все необходимые методы, для удобства использования:
    // 1. метод для добавления в справочник телефонных номеров.
    // 2. метод для получения из справочника телефонных номеров.
    // 3. метод для удаления телефонных номеров, при необходимости.
    // В принципе это все, что необходимо для удобного использования справочника.
    public static class TelBook {
        private Map<String, ArrayList<String>> book = new HashMap<>();

        public void addNumber(String name, String number) {
            if (book.containsKey(name)) {
                book.get(name).add(number);
            } else {
                ArrayList<String> numbers = new ArrayList<>();
                numbers.add(number);
                book.put(name, numbers);
            }
        }

        public ArrayList<String> getNumbers(String name) {
            if (book.containsKey(name))
                return book.get(name);
            else
                return null;
        }

        public void removeNumber(String name, String number) {
            if (book.containsKey(name)) {
                ArrayList<String> numbers = book.get(name);
                numbers.remove(number);
                if (numbers.isEmpty())
                    book.remove(name);
            }
        }
    }

    private static void ex2() {
        // Итак, дан список сотрудников.
        String[] emp = {"Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова",
                "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"};

        // Преобразую массив сотрудников в список, и для удобства контроля решения выведу его на печать.
        List<String> nameEmp = new ArrayList<>();
        nameEmp.addAll(Arrays.asList(emp));
        System.out.println("Список сотрудников:");
        System.out.println(nameEmp.toString());
        System.out.println();

        // Создаю HashMap в которую в качестве ключа заношу фамилию сотрудника, в качестве значения имя сотрудника.
        Map<String, String> employee = new HashMap<>();
        for (int i = 0; i < nameEmp.size(); i++) {
            String temp = nameEmp.get(i);
            String[] name = temp.split(" ");
            employee.put(name[1], name[0]);
        }

        // Получаю список только имен сотрудников, без их фамилий
        List<String> firstNameEmployee = new ArrayList<>();
        for (int i = 0; i < employee.size(); i++) {
            String temp = nameEmp.get(i);
            String[] names = temp.split(" ");
            String key = names[1];
            String name = employee.get(key);
            firstNameEmployee.add(name);
        }
        System.out.println("Список имен сотрудников без фамилий:");
        System.out.println(firstNameEmployee.toString());
        System.out.println();

        // Сортирую полученный список.
        firstNameEmployee.sort(Comparator.naturalOrder());

        // Получаю список уникальных имен у сотрудников компании.
        Set<String> names = new HashSet<>(firstNameEmployee);
        List<String> firstNames = new ArrayList<>(names);
        firstNames.sort(Comparator.naturalOrder());

        // Нахожу индекс первого вхождения каждого уникального имени в общем списке имен,
        // и записываю его в список индексов.
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < firstNames.size(); i++) {
            int indexName = firstNameEmployee.indexOf(firstNames.get(i));
            counts.add(indexName);
        }
        counts.add(firstNameEmployee.size());

        // Создаю HashMap в которую в качестве ключа записываю уникальные имена сотрудников,
        // а в качестве значений - количество повторений данного имени.
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < firstNames.size(); i++) {
            String name = firstNames.get(i);
            int num = counts.get(i + 1) - counts.get(i);
            map.put(name, num);
        }

        // Вывожу HashMap с количеством повторений уникальных имен на печать, согласно условию задачи.
        System.out.println("Количество повторений имен сотрудников, отсортированное по убыванию популярности:");
        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }

}
