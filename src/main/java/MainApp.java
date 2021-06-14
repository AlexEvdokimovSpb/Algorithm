import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Задание 1.1
        // Приведите пример алгоритмов и структур данных из жизни.
        //
        // Решение:
        // Пример структуры данных: номер авиарейса, ряда и места в ряде.
        // Алгоритм: пассажир находит посадочный гейт по рейсу, далее находит ряд и свое место.

        // Задание 1.2
        // Приведите пример алгоритмов и структур данных в программировании.
        //
        // Решение:
        // Примером структур данных является любая SQL база данных.
        // Примером алгоритма в такой базе является запрос по значению,
        // при котором выводятся строки таблицы с заданным значением.

        // Задание 1.3
        // Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
        // Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
        // Выведите написанные данные.
        //
        // Решение:

        List<Leader> listLeader = new ArrayList<>();

        Leader putin = new Leader("Putin", 68, 6, true);
        listLeader.add(putin);
        Leader macron = new Leader("Macron", 43, 5, false);
        listLeader.add(macron);
        Leader biden = new Leader("Biden", 78, 4, false);
        listLeader.add(biden);
        printLeader(listLeader);

        // Задание 1.4
        // Дополните предыдущий код сравнением ваших данных с другой переменной,
        // данный код должен имитировать простейший поиск перебором.
        // Оцените время выполнения алгоритма с помощью базового метода System.nanoTime().
        //
        // Решение:

        leadersOlderThan(listLeader);

    }

    public static void printLeader (List<Leader> listLeader) {
        for (Leader leader : listLeader) {
            System.out.println("Имя: " + leader.getName());
            System.out.println("Возраст: " + leader.getAgeLeader());
            System.out.println("Срок полномочий: " + leader.getTermOfAppointment());
            System.out.println("Обнуляемые? " + leader.isZeroAble());
            System.out.println();
        }
    }

        public static void leadersOlderThan (List<Leader> listLeader) {
            System.out.println("Введите возраст, старше которого показать имена лидеров: " );
            int age  = sc.nextInt();
            System.out.println("Старше " + age);
            long startAlgoritm = System.nanoTime();
            for (Leader leader : listLeader) {
                if (leader.getAgeLeader() > age){
                    System.out.println(" " + leader.getName());
                }
            }
            long endAlgoritm = System.nanoTime();
            long timeAlgoritm = endAlgoritm-startAlgoritm;
            System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        }
}