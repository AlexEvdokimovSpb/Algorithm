public class SimpleTree {

    private Node root; // Это наш корневой узел. Он должен существовать обязательно.

    public void insert(Person person) // Этот метод реализует вставку нового элемента
    {
        Node node = new Node();
        node.person = person;
        if (root == null) // Если дерево нулевое, то мы к корневому элементу присвоим наш node
        {
            root = node;
        } else {
            Node current = root;
            Node parent; // Переменная для определения нашего родителя
            while (true) {
                parent = current;
                if (person.id < current.person.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) // Этот метод будет искать определённый узел в дереве
    {
        Node current = root; // current - это переменная текущего нашего узла, на котором мы в настоящий момент находимся
        while (current.person.id != key) {
            if (key < current.person.id) {
                current = current.leftChild; // Здесь мы переходим на левого потомка
            } else {
                current = current.rightChild; // Здесь мы переходим на правого потомка
            }
            if (current == null) // Если данное условие выполняется, то мы дошли до элемента с пустым листом, а этом значит, что нашего элемента в дереве нет
            {
                return null;
            }
        }
        return current;
    }

    private void inOrder(Node rootNode) // Реализация нашего симметричного обхода дерева
    {
        if (rootNode != null) {
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    private void preOrder(Node rootNode) // Прямой обход дерева
    {
        if (rootNode != null) {
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode) // Обратный обход дерева
    {
        if (rootNode != null) {
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }


    public Node min() {
        Node current, last = null; // current - это тот узел, в котором мы находимся на данный момент; last - это искомый минимум
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last;
    }

    public Node max() // current - это тот узел, в котором мы находимся на данный момент; last - это искомый максимум
    {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id) // Удаление нашего элемента по его уникальному id
    {
        Node current = root; // Узел, на котором мы находимся сейчас
        Node parent = root; // Родительский узел

        boolean isLeftChild = true; // Нужна для определения какой потомок мы удаляем (левый - true или нет - false)

        while ((current.person.id) != id) // Поиск нашего удаляемого узла
        {
            parent = current;
            if (id < current.person.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) // Случай, когда нет потомков
        {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) // Есть только левый потомок
        {
// if (current == null) // Здесь преподаватель ошибся. Попробуйте сделать с данным кодом дерево, введя последовательно узлы с ID: 1, 2, 3. После этого, попробуйте удалить 1 узел и выведите в консоль всё дерево.
            if (current == root)
            {
                root = current.leftChild;
            }
            else if(isLeftChild)
            {
                parent.leftChild = current.leftChild;
            }
            else
            {
                parent.rightChild = current.leftChild;
            }
        }
        else if (current.leftChild == null) // Есть только правый потомок
        {
// if (current == null) // Здесь преподаватель ошибся. Попробуйте сделать с данным кодом дерево, введя последовательно узлы с ID: 1, 2, 3. После этого, попробуйте удалить 1 узел и выведите в консоль всё дерево.
            if (current == root)
            {
                root = current.rightChild;
            }
            else if (isLeftChild)
            {
                parent.leftChild = current.rightChild;
            }
            else
            {
                parent.rightChild = current.rightChild;
            }
        }
        else
        {
            Node successor = getSuccesor(current);
            if (current == root)
            {
                root = successor;
            }
            else if (isLeftChild)
            {
                parent.leftChild = successor;
            }
            else
            {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccesor(Node node) // Возвращает узел, являющийся преемником. Данный метод необходимо, чтобы искать наш узел в правом поддереве. С его помощью мы будем искать необходимый узел для замены и поиска преемника для нашего удаляемого узла.
    {
        Node successorParent = node; // Родитель нашего узла
        Node successor = node;      // Текущий узел
        Node current = node.rightChild; // Правый потомок нашего исходного узла

        // Далее идет поиск в правом поддереве
        while (current != null)
        {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild)
        {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }

        return successor;
    }

    public void displayTree() // Этот метод выводит всё дерево. Здесь будут реализованы 3 метода. Поскольку, чтобы вывести дерево нам нужно его обойти полностью. Все 3 метода будут иметь в консоли разный вывод.
    {
        Node current = root;
        System.out.println("Симметричный");
        inOrder(root);
        System.out.println("Прямой");
        preOrder(root);
        System.out.println("Обратный");
        postOrder(current);
    }

}