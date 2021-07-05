import java.util.LinkedList;
import java.util.List;

//Задания 6.1
//Приведите пример использования древовидной структуры.
//Задание 6.2
//Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
//Задание 6.3
//Реализуйте методы поиска и вставки узла в дерево.
//Задание 6.4
//Реализуйте базовые методы обхода дерева и метода дисплей.
//Реализуйте поиск максимума и минимума.
//Задание 6.5
//Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
//Задание 6.6
//Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
//Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.
//Задание 6.7
//Приведите пример сбалансированного дерева и его применения.
//Решение:

public class HW6 {


    public static void main(String[] args) {


        SimpleTree theTree = new SimpleTree();
        theTree.insert(new Person(23, "Vasja", 10));
        theTree.insert(new Person(1, "Kolja", 15));
        theTree.insert(new Person(20, "Ivan", 13));
        theTree.insert(new Person(3, "Sasha", 11));
        theTree.insert(new Person(22, "Masha", 8));
        theTree.insert(new Person(5, "Natasha", 14));
        theTree.insert(new Person(4, "Olja", 7));

        theTree.max().display();
        theTree.min().display();
        theTree.find(4).display();

        theTree.delete(3);

        System.out.println();

        theTree.displayTree();

        Leader putin = new Leader("Putin", 68, 6, true);
        Leader macron = new Leader("Macron", 43, 5, false);
        Leader biden = new Leader("Biden", 78, 4, false);
        Leader napoleon = new Leader("Napoleon", 51, 99, true);
        Leader palpatine = new Leader("Palpatine", 200, 99, true);

        LinkedList<Leader> listLeaders = new LinkedList<>();
        listLeaders.add(palpatine);
        listLeaders.add(putin);
        listLeaders.add(macron);
        listLeaders.add(biden);
        listLeaders.add(napoleon);

        LinkedList<Leader> copyListLeaders = new LinkedList<>(listLeaders);

        HeapSortLeaders heapSortLeaders = new HeapSortLeaders();

        long startAlgoritm = System.nanoTime();
        heapSortLeaders.sort(listLeaders);
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("\n" +"Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");

        System.out.println("Сортированный " + "\n");
        printLeaders(listLeaders);
        System.out.println("Не сортированный " + "\n");
        printLeaders(copyListLeaders);

    }

    // Печать
    public static void printLeaders (List<Leader> listLeaders) {
        for (Leader leader : listLeaders) {
            System.out.println("Имя: " + leader.getName());
            System.out.println("Возраст: " + leader.getAgeLeader());
            System.out.println("Срок полномочий: " + leader.getTermOfAppointment());
            System.out.println("Обнуляемые? " + leader.isZeroAble());
            System.out.println();
        }
    }

}