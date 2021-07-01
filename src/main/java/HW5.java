import java.util.*;

public class HW5 {

    static private final int KEY = 68; // искомое значение

    public static void main(String[] args) {

        //Задание 5.1
        //Приведите пример использования рекурсии.
        //Задание 5.2
        //Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        //Задание 5.3
        //Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        //Задание 5.4
        //Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию.
        //Оцените два алгоритма с помощью базового метода System.nanoTime().
        //Задание 5.5
        //Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1.
        //Оцените алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным двоичным поиском.
        //Задание 5.6
        //На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием.
        //Оцените алгоритм сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
        //Решение:

        Leader putin = new Leader("Putin", 68, 6, true);
        Leader macron = new Leader("Macron", 43, 5, false);
        Leader biden = new Leader("Biden", 78, 4, false);
        Leader napoleon = new Leader("Napoleon", 51, 99, true);
        Leader palpatine = new Leader("Palpatine", 200, 99, true);

        List<Leader> listLeaders = new LinkedList<>();
        listLeaders.add(palpatine);
        listLeaders.add(putin);
        listLeaders.add(macron);
        listLeaders.add(biden);
        listLeaders.add(napoleon);

        LinkedList<Leader> copyListLeaders = new LinkedList<>(listLeaders);

        listLeaders.sort(leaderComparator); // сортировка по возрасту
        printLeaders(listLeaders);
        printLeaders(copyListLeaders);

        //Задание 5.5
        System.out.println("Двоичный рекусивный поиск item " );
        long startAlgoritm = System.nanoTime();
        int index = recBinaryFind(KEY, 0, listLeaders.size() - 1, listLeaders);
        System.out.println("Нужный элемент: " + index);
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");

        binarySearch (listLeaders, KEY);

        //Задание 5.6
        System.out.println("Рекусивная сортировка слиянием " );
        long startAlgoritm2 = System.nanoTime();
        mergeSort(copyListLeaders);
        long endAlgoritm2 = System.nanoTime();
        long timeAlgoritm2 = endAlgoritm2-startAlgoritm2;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm2 + "\n");
        printLeaders(copyListLeaders);

    }

    public static int recBinaryFind(int searchKey, int low, int high, List<Leader> leaders) {
        if (low > high) {
            return leaders.size();
        }
        int mid = (low + high) / 2;
        if (leaders.get(mid).getAgeLeader() == searchKey) {
            return mid;
        } else if (leaders.get(mid).getAgeLeader() < searchKey) {
            return recBinaryFind(searchKey, mid + 1, high, leaders);
        } else {
            return recBinaryFind(searchKey, low, mid - 1, leaders);
        }
    }

    public static void binarySearch (List<Leader> leaders, int item) {
        System.out.println("Двоичный поиск item " );
        long startAlgoritm = System.nanoTime();
        int firstIndex = 0;
        int lastIndex = leaders.size() - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (leaders.get(middleIndex).getAgeLeader() == item) {
                System.out.println("Нужный элемент: " + middleIndex);
                break;
            }

            else if (leaders.get(middleIndex).getAgeLeader()<item) {
                firstIndex = middleIndex + 1;
            }

            else if (leaders.get(middleIndex).getAgeLeader()>item) {
                lastIndex = middleIndex - 1;
            }
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");
    }

        private static LinkedList<Leader> mergeSort(LinkedList<Leader> leaders)
        {
            int left = 0;
            int right = leaders.size();

            if (right < 2)
            {
                return leaders;
            }
            int middle = right / 2;
            return merge( mergeSort ( copyOfRange(leaders, left, middle)), mergeSort ( copyOfRange (leaders, middle, right)) );
        }

        public static LinkedList<Leader> merge(LinkedList<Leader>  a, LinkedList<Leader> b)
        {
            LinkedList<Leader> result = new LinkedList<>();
            int aIndex = 0;
            int bIndex = 0;
            int size = a.size()+b.size();

            for (int i = 0; i < size; i++)
            {
                result.add(a.get(aIndex).getAgeLeader() < b.get(bIndex).getAgeLeader() ? a.get(aIndex++) : b.get(bIndex++));
                if (aIndex == a.size())
                {
                    result.addAll(bIndex, b);
                    break;
                }
                if (bIndex == b.size())
                {
                    result.addAll(aIndex, a);;
                    break;
                }
            }
            return result;
        }

    public static LinkedList<Leader> copyOfRange(LinkedList<Leader>  linkedList, int left, int right) {
        LinkedList<Leader> result = new LinkedList<>();
        for (int i = left; i < right; i++)
            result.add(linkedList.get(i));
        return result;
    }

    // Компоратор сравнения лидеров по возрасту
    public static Comparator<Leader> leaderComparator = new Comparator<Leader>(){

        @Override
        public int compare(Leader l1, Leader l2) {
            return (l1.getAgeLeader() - l2.getAgeLeader());
        }
    };

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
