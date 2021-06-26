import java.util.*;

public class HW4 {

    public static void main(String[] args) {

        //Задание 4.1
        //На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Задание 4.2
        //На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые методы.
        //Реализуйте вспомогательные методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Задание 4.3
        //На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Задание 4.4
        //Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Задание 4.5
        //На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        //Оцените время выполнения операций с помощью базового метода System.nanoTime().
        //Решение:

        Leader putin = new Leader("Putin", 68, 6, true);
        Leader macron = new Leader("Macron", 43, 5, false);
        Leader biden = new Leader("Biden", 78, 4, false);
        Leader napoleon = new Leader("Napoleon", 51, 99, true);
        Leader palpatine = new Leader("Palpatine", 200, 99, true);

        //4.1
        Stack<Leader> stackLeader = new Stack<>();

        stackLeader.push(palpatine);
        stackLeader.push(putin);
        stackLeader.push(macron);
        stackLeader.push(biden);
        stackLeader.push(napoleon);

        if (!stackLeader.empty()) {
            System.out.println("Верхний элемент: " + stackLeader.peek().getName());
        }

        System.out.println("Стек пустой? " + stackLeader.empty());
        long startAlgoritm = System.nanoTime();
        while(!stackLeader.empty())
        {
            System.out.println(stackLeader.pop().getName());
        }
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm - startAlgoritm;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm);
        System.out.println("Стек пустой? " + stackLeader.empty() + "\n");

        //4.2
        Queue<Leader> queueLeader = new LinkedList<>();

        queueLeader.add(palpatine);
        queueLeader.add(putin);
        queueLeader.add(macron);
        queueLeader.add(biden);
        queueLeader.add(napoleon);

        if (!queueLeader.isEmpty()) {
            System.out.println("Верхний элемент: " + queueLeader.peek().getName());
        }
        System.out.println("Очередь пуста? " + queueLeader.isEmpty());
        long startAlgoritm2 = System.nanoTime();
        while(!queueLeader.isEmpty())
        {
            System.out.println(queueLeader.poll().getName());
        }
        long endAlgoritm2 = System.nanoTime();
        long timeAlgoritm2 = endAlgoritm2 - startAlgoritm2;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm2);
        System.out.println("Очередь пуста? " + queueLeader.isEmpty() + "\n");

        //4.3
        Deque<Leader> dequeLeader = new LinkedList<>();

        dequeLeader.add(palpatine);
        dequeLeader.add(putin);
        dequeLeader.addFirst(macron);
        dequeLeader.addLast(biden);
        dequeLeader.add(napoleon);

        if (!dequeLeader.isEmpty()) {
            System.out.println("Верхний элемент: " + dequeLeader.peek().getName());
        }
        System.out.println("Очередь пуста? " + dequeLeader.isEmpty());
        long startAlgoritm3 = System.nanoTime();
        while(!dequeLeader.isEmpty())
        {
            System.out.println(dequeLeader.pollLast().getName());
        }
        long endAlgoritm3 = System.nanoTime();
        long timeAlgoritm3 = endAlgoritm3 - startAlgoritm3;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm3);
        System.out.println("Очередь пуста? " + dequeLeader.isEmpty() + "\n");

        //4.4 приоритетную очередь по возрасту лидеров
        PriorityQueue<Leader> priorLeader = new PriorityQueue<>(leaderComparator);

        priorLeader.add(putin);
        priorLeader.add(palpatine);
        priorLeader.add(macron);
        priorLeader.add(biden);
        priorLeader.add(napoleon);

        if (!priorLeader.isEmpty()) {
            System.out.println("Верхний элемент: " + priorLeader.peek().getName());
        }
        System.out.println("Очередь пуста? " + priorLeader.isEmpty());
        long startAlgoritm4 = System.nanoTime();
        while(!priorLeader.isEmpty())
        {
            System.out.println(priorLeader.poll().getName());
        }
        long endAlgoritm4 = System.nanoTime();
        long timeAlgoritm4 = endAlgoritm4 - startAlgoritm4;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm4);
        System.out.println("Очередь пуста? " + priorLeader.isEmpty() + "\n");

        //4.5
        StackSimple<Leader> simpleStackSimple = new StackSimple<>(5);
        SimpleQueue<Leader> simpleQueueLeader = new SimpleQueue<>(5);

        simpleStackSimple.push(palpatine);
        simpleStackSimple.push(putin);
        simpleStackSimple.push(macron);
        simpleStackSimple.push(biden);
        simpleStackSimple.push(napoleon);

        simpleQueueLeader.push(palpatine);
        simpleQueueLeader.push(putin);
        simpleQueueLeader.push(macron);
        simpleQueueLeader.push(biden);
        simpleQueueLeader.push(napoleon);


        if (!simpleStackSimple.isEmpty()) {
            System.out.println("Верхний элемент: " + simpleStackSimple.peek().getName());
        }
        System.out.println("Стек пустой? " + simpleStackSimple.isEmpty());
        long startAlgoritm5 = System.nanoTime();
        while(!simpleStackSimple.isEmpty())
        {
            System.out.println(simpleStackSimple.pool().getName());
        }
        long endAlgoritm5 = System.nanoTime();
        long timeAlgoritm5 = endAlgoritm5 - startAlgoritm5;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm5);
        System.out.println("Стек пустой? " + simpleStackSimple.isEmpty() + "\n");

        if (!simpleQueueLeader.isEmpty()) {
            System.out.println("Верхний элемент: " + simpleQueueLeader.peek().getName());
        }
        System.out.println("Очередь пустая? " + simpleQueueLeader.isEmpty());
        long startAlgoritm6 = System.nanoTime();
        while(!simpleQueueLeader.isEmpty())
        {
            System.out.println(simpleQueueLeader.pool().getName());
        }
        long endAlgoritm6 = System.nanoTime();
        long timeAlgoritm6 = endAlgoritm6 - startAlgoritm6;
        System.out.println("Врема работы алгоритма в наносекундах: " + timeAlgoritm6);
        System.out.println("Очередь пустая? " + simpleQueueLeader.isEmpty() + "\n");

    }

    public static Comparator<Leader> leaderComparator = new Comparator<Leader>(){

        @Override
        public int compare(Leader l1, Leader l2) {
            return (l1.getAgeLeader() - l2.getAgeLeader());
        }
    };
}
