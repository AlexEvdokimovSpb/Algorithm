public class SinglyLink<T> {

    private T singlyLink;
    private SinglyLink<T> next;

    public SinglyLink(T singlyLink)
    {
        this.singlyLink = singlyLink;
    }

    public SinglyLink<T> getNext()
    {
        return next;
    }

    public void setNext(SinglyLink<T> next)
    {
        this.next = next;
    }

    public T getValue()
    {
        return singlyLink;
    }

}
