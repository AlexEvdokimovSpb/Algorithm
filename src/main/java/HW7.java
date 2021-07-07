
//Задание 7.1
//Приведите пример графа. - схема метро
//Задание 7.2
//Реализуйте базовые методы графа.
//Задание 7.3
//В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
//Выполните оценку времени с помощью System.nanoTime().
//Задание 7.4
//В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
//Выполните оценку времени с помощью System.nanoTime().
//Решение:

public class HW7 {

    public static void main(String[] args) {

        boolean flagOff = true;

        Graph graph = new Graph();
        graph.addVertex('M');
        graph.addVertex('Y');
        graph.addVertex('G');
        graph.addVertex('R');
        graph.addVertex('A');
        graph.addVertex('P');
        graph.addVertex('H');
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 0);
        graph.addEdge(2, 6);

        long startAlgoritm = System.nanoTime();
        graph.methodDepth(0, flagOff);
        long endAlgoritm = System.nanoTime();
        long timeAlgoritm = endAlgoritm-startAlgoritm;
        System.out.println("\n" +"Врема работы алгоритма в наносекундах: " + timeAlgoritm + "\n");

        long startAlgoritm2 = System.nanoTime();
        graph.methodWidth(0);
        long endAlgoritm2 = System.nanoTime();
        long timeAlgoritm2 = endAlgoritm2-startAlgoritm2;
        System.out.println("\n" +"Врема работы алгоритма в наносекундах: " + timeAlgoritm2 + "\n");

    }
}