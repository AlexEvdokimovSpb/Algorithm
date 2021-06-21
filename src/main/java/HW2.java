import java.util.Arrays;
import java.util.Random;

public class HW2 {
    // static Scanner sc = new Scanner(System.in);
    private static final int SIZE_ARRAY = 400;
    private static final int BOUND_RANDOM = 50;
    private static final int SEARCH_ITEM = 33;

    public static void main(String[] args) {

        // Задание 2.1
        // На основе программного кода из домашнего задания №1 реализуйте массив на основе существующих примитивных или ссылочных типов данных.
        // Выполните обращение к массиву и базовые операции класса Arrays.
        // Оценить выполненные методы с помощью базового класса System.nanoTime().
        // Задание 2.2
        // На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск.
        // Оценить алгоритмы линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже существующий массив данных.
        // Задание 2.3
        // Создайте массив размером 400 элементов.
        // Выполните сортировку с помощью метода sort().
        // Оцените сортировку с помощью базового класса System.nanoTime().
        // Задание 2.4
        // На основе существующего массива  данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        // Оцените сортировку с помощью базового класса System.nanoTime().
        // Сравните время выполнения алгоритмы сортировки методом sort() из задания 2.1 и сортировку пузырьком.
        // Задание 2.5
        // На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора.
        // Оцените сортировку с помощью базового класса System.nanoTime().
        // Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3 и 2.4.
        // Задание 2.6
        // На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки.
        // Оцените сортировку с помощью базового класса System.nanoTime().
        // Сравните с временем выполнения алгоритмов сортировки из прошлых заданий 2.3, 2.4 и 2.5.
        // Решение:

//        Прошлое задание
//        List<Leader> listLeader = new ArrayList<>();
//        Leader putin = new Leader("Putin", 68, 6, true);
//        listLeader.add(putin);
//        Leader macron = new Leader("Macron", 43, 5, false);
//        listLeader.add(macron);
//        Leader biden = new Leader("Biden", 78, 4, false);
//        listLeader.add(biden);
//        printLeader(listLeader);
//        leadersOlderThan(listLeader);


        int[] intArray = new int[SIZE_ARRAY];
        int[] copyIntArray;

        Random rand = new Random();
        for (int i=0; i<SIZE_ARRAY; i++){
            intArray[i]=rand.nextInt(BOUND_RANDOM);
        }
        intArray[rand.nextInt(BOUND_RANDOM)]= SEARCH_ITEM;
        copyIntArray = Arrays.copyOf(intArray, intArray.length);

        System.out.println("intArray: " + Arrays.toString(intArray));
        System.out.println("copyIntArray: " + Arrays.toString(copyIntArray) + "\n");

        Arrays.sort(intArray); // бинарный поиск не работает на не сортированном массиве, поэтому для корректного сравнения сортируем
        linearSearch (intArray, SEARCH_ITEM);
        binarySearch (intArray, SEARCH_ITEM);
        // поскольку значений равных SEARCH_ITEM может быть несколько, а мы ищем только первый (используем break;), индексы могут отличаться
        intArray = Arrays.copyOf(copyIntArray, copyIntArray.length); // возвращаем в исходный вид
        System.out.println("intArray: " + Arrays.toString(intArray) + "\n");

        sort(intArray);
        intArray = Arrays.copyOf(copyIntArray, copyIntArray.length);
        System.out.println("intArray: " + Arrays.toString(intArray) + "\n");

        bubbleSort(intArray);
        intArray = Arrays.copyOf(copyIntArray, copyIntArray.length);
        System.out.println("intArray: " + Arrays.toString(intArray) + "\n");

        choiceSort(intArray);
        intArray = Arrays.copyOf(copyIntArray, copyIntArray.length);
        System.out.println("intArray: " + Arrays.toString(intArray) + "\n");

        insertsSort(intArray);
        intArray = Arrays.copyOf(copyIntArray, copyIntArray.length);
        System.out.println("intArray: " + Arrays.toString(intArray) + "\n");

    }

//    Прошлое задание
//    public static void printLeader (List<Leader> listLeader) {
//        for (Leader leader : listLeader) {
//            System.out.println("Имя: " + leader.getName());
//            System.out.println("Возраст: " + leader.getAgeLeader());
//            System.out.println("Срок полномочий: " + leader.getTermOfAppointment());
//            System.out.println("Обнуляемые? " + leader.isZeroAble());
//            System.out.println();
//        }
//    }
//
//    public static void leadersOlderThan (List<Leader> listLeader) {
//        System.out.println("Введите возраст, старше которого показать имена лидеров: " );
//        int age  = sc.nextInt();
//        System.out.println("Старше " + age);
//        long startAlgoritm = System.nanoTime();
//        for (Leader leader : listLeader) {
//            if (leader.getAgeLeader() > age){
//                System.out.println(" " + leader.getName());
//            }
//        }
//        long endAlgoritm = System.nanoTime();
//        long timeAlgoritm = endAlgoritm-startAlgoritm;
//        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
//    }

    public static void linearSearch (int[] arr, int item) {
        System.out.println("Линейный поиск item " );
        long startAlgoritm = System.nanoTime();
        for (int i=0; i<SIZE_ARRAY; i++){
            if (arr[i]==item) {
                System.out.println("Нужный элемент: " + i);
                break;
            }
        }
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");
    }

    public static void binarySearch (int[] arr, int item) {
        System.out.println("Двоичный поиск item " );
        long startAlgoritm = System.nanoTime();
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex){
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == item) {
                System.out.println("Нужный элемент: " + middleIndex);
                break;
            }

            else if (arr[middleIndex]<item) {
                firstIndex = middleIndex + 1;
            }

            else if (arr[middleIndex]>item) {
                lastIndex = middleIndex - 1;
            }
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");
    }

    public static void sort (int[] arr) {
        System.out.println("Сортировка методом sort() ");
        long startAlgoritm = System.nanoTime();
        Arrays.sort(arr);
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm - startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        System.out.println("intArray: " + Arrays.toString(arr) + "\n");
    }

    public static void bubbleSort (int[] arr) {
        System.out.println("Сортировка пузырьковым методом ");
        long startAlgoritm = System.nanoTime();

        for (int out = arr.length - 1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(arr[in] > arr[in + 1]) {
                    int buff = arr[in];
                    arr[in] = arr[in + 1];
                    arr[in + 1] = buff;
                }
            }
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm - startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        System.out.println("intArray: " + Arrays.toString(arr) + "\n");
    }


    public static void choiceSort (int[] arr) {
        System.out.println("Сортировка методом выбора");
        long startAlgoritm = System.nanoTime();

        for (int left = 0; left < arr.length; left++) {
            int minInd = left;
            for (int i = left; i < arr.length; i++) {
                if (arr[i] < arr[minInd]) {
                    minInd = i;
                }
            }
            int buff = arr[left];
            arr[left] = arr[minInd];
            arr[minInd] = buff;
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm - startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        System.out.println("intArray: " + Arrays.toString(arr) + "\n");
    }

    public static void insertsSort (int[] arr) {
        System.out.println("Сортировка методом вставки");
        long startAlgoritm = System.nanoTime();

        for (int left = 0; left < arr.length; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }

        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm - startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        System.out.println("intArray: " + Arrays.toString(arr) + "\n");
    }
}