import java.util.LinkedList;

public class SimpleQueue<T> {
    private final int maxSize;
    private final LinkedList<T> stack;
    private int top;

    public SimpleQueue(int size)
    {
        this.maxSize = size;
        this.stack = new LinkedList<>();
        this.top = -1;
    }

    public void push(T e)
    {
        this.top++;
        this.stack.add(e);
    }

    public T pool()
    {
        this.top--;
        return this.stack.pollFirst();
    }

    public T peek()
    {
        return this.stack.peekFirst();
    }

    public boolean isEmpty()
    {
        return(this.top == -1);
    }

    public boolean isFull()
    {
        return (this.top == this.maxSize - 1);
    }
}
