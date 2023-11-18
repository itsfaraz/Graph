package exercise;

import representation.map.IGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFT extends IGraph {

    public void bft(){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int src : getMap().keySet()){
            if (visited.contains(src))
                continue;
            
            queue.add(src);
            while (!queue.isEmpty()){
                int vertex = queue.poll();
                if (visited.contains(vertex))
                    continue;
                System.out.print(vertex+" --> ");
                visited.add(vertex);
                queue.addAll(getMap().get(vertex).keySet());
            }
        }
    }

}
