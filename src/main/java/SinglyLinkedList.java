public class SinglyLinkedList<T>  {

    private SinglyLink<T> first;

    public SinglyLinkedList()
    {
        first = null;
    }

    public void insert(T link)
    {
        SinglyLink<T> l = new SinglyLink<>(link);
        l.setNext(first);
        this.first = l;
    }

    public SinglyLink<T> delete()
    {
        SinglyLink<T> temp = first;
        first = first.getNext();
        return temp;
    }

    public void display()
    {
        SinglyLink<T> current = first;
        while (current != null)
        {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public T find(T searchNode)
    {
        SinglyLink<T> findNode = new SinglyLink<>(searchNode);
        SinglyLink<T> current = first;
        while (current != null)
        {
            if (current.getValue().equals(findNode.getValue()))
            {
                return findNode.getValue();
            }
            current = current.getNext(); // !!! Данная строка была пропущена мною
        }
        return null;
    }

}
