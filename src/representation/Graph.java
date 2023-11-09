package representation;

public interface Graph {
    public void add(int from,int to,int data);
    public void delete(int from,int to);
    public void get(int from,int to);
    public void set(int from,int to,int data);
    public void display();
    public int noOfEdges();

    public boolean hasPath(int source,int dest);
    public void printAllPaths(int source,int dest);
}
