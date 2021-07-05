import java.util.LinkedList;

public class HeapSortLeaders {
    private static int heapSize;

    public static void sort(LinkedList<Leader> leaders)
    {
        buildHeap(leaders);
        while (heapSize > 1)
        {
            swap(leaders, 0, heapSize - 1);
            heapSize--;
            heapify(leaders, 0);
        }
    }

    private static void buildHeap(LinkedList<Leader> leaders)
    {
        heapSize = leaders.size();
        for (int i = leaders.size() / 2; i >= 0; i--)
        {
            heapify(leaders, i);
        }
    }

    private static void heapify(LinkedList<Leader> leaders, int i)
    {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heapSize && leaders.get(i).getAgeLeader() < leaders.get(l).getAgeLeader())
        {
            largest = l;
        }
        if (r < heapSize && leaders.get(largest).getAgeLeader() < leaders.get(r).getAgeLeader())
        {
            largest = r;
        }
        if (i != largest)
        {
            swap(leaders, i, largest);
            heapify(leaders, largest);
        }
    }

    private static int right(int i)
    {
        return 2 * i + 2;
    }

    private static int left(int i)
    {
        return 2 * i + 1;
    }

    private static void swap(LinkedList<Leader> leaders, int i, int j)
    {
        Leader temp = leaders.get(i);
        leaders.set(i, leaders.get(j));
        leaders.set(j, temp);
    }
}
