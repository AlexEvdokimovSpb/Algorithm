public class Graph {

    private final int MAX_VERTS = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        size = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
                }
            }
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
        }

    private int getAdjUnvisitedVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void methodDepth(int f, boolean flagOff){
        vertexList[f].wasVisited = true;
        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if ((!vertexList[i].wasVisited) && (v != -1) && (i == v)) {
                fullDisplayVertex(f, v);
                methodDepth(i, false);
            }
        }

        if (flagOff) {
            for (int i = 0; i < size; i++) {
                vertexList[i].wasVisited = false;
            }
        }
    }

    public void methodWidth(int v) {
        int[] queue = new int[size];
        int qH = 0;
        int qT = 0;
        vertexList[v].wasVisited = true;
        displayVertex(v);
        queue[qT++] = v;
        int v2;
        while (qH < qT) {
            v = queue[qH++];
            for (int i = 0; i < size; i++) {
                v2 = getAdjUnvisitedVertex(v);
                if (v2 != -1 && !vertexList[v2].wasVisited) {
                    vertexList[v2].wasVisited = true;
                    displayVertex(v2);
                    queue[qT++] = v2;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public void fullDisplayVertex(int vertex1, int vertex2) {
        System.out.println("Связь " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }
}

