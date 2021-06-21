import java.util.*;

public class HW3 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Задание 3.1
        // На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию.
        // Оцените время выполнения преобразования.
        // Задание 3.2
        // На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения объекта или элемента из списка.
        // Оценить выполненные методы с помощью базового класса System.nanoTime().
        // Задание 3.3
        // Реализуйте простой односвязный список и его базовые методы.
        // Задание 3.4
        // На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        // Реализуйте список заполненный объектами из вашего класса из задания 1.3
        // Задание 3.5
        // Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции итератора.
        // Оцените время выполнения операций с помощью базового метода System.nanoTime()
        // Решение:

        List<Leader> listLeader = new ArrayList<>();
        Leader putin = new Leader("Putin", 68, 6, true);
        listLeader.add(putin);
        Leader macron = new Leader("Macron", 43, 5, false);
        listLeader.add(macron);
        Leader biden = new Leader("Biden", 78, 4, false);
        listLeader.add(biden);

        Leader napoleon = new Leader("Napoleon", 51, 99, true);
        listLeader.add(0, napoleon);

        Leader palpatine = new Leader("Palpatine", 200, 99, true);
        listLeader.add(0,palpatine);

        listLeader.remove(0);
        listLeader.add(0,biden);
        listLeader.set(0,palpatine);

        List<Leader> linkedLisLeader = new LinkedList<>(listLeader);

        printLeader(listLeader);

        int age = leadersOlderThan(linkedLisLeader);
        deleteYoungerThan(linkedLisLeader, age);

        printLeader(linkedLisLeader);

        // Задание 3.3 просто повторяем урок
        SinglyLinkedList<Leader> list = new SinglyLinkedList<>();
        list.insert(napoleon);
        list.insert(palpatine);
        list.insert(macron);
        list.display();
        System.out.println("\n" + list.find(palpatine).getName());

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

    public static int leadersOlderThan (List<Leader> listLeader) {
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

        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");
        return age;
    }

    public static void deleteYoungerThan (List<Leader> listLeader, int age) {
        long startAlgoritm = System.nanoTime();

        Iterator<Leader> iter = listLeader.listIterator();
        Leader leader;
        while(iter.hasNext())
        {
            leader = iter.next();
            if (leader.getAgeLeader() <= age){
                System.out.println("Лидер слишком молодой: " + leader.getName() + " его исключаем из списка" + "\n");
                iter.remove();
            }
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");
    }
}