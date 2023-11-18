package exercise;

import representation.map.IGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS extends IGraph {

    public boolean bfs(int src,int dest){
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        if (!getMap().containsKey(src))
            return false;
        queue.add(src);
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            if (set.contains(vertex))
                continue;
            set.add(vertex);
            if (vertex == dest)
                return true;
            queue.addAll(getMap().get(vertex).keySet());
        }
        return false;
    }

}
