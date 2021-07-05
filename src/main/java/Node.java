class Node
{
    public Person person;
    public Node leftChild; // Это наш левый потомок
    public Node rightChild; // Это наш правый потомок
    public void display()
    {
        System.out.println("Имя: " + person.name + " Возраст: " + person.age);
    }
}
