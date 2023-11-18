package exercise;

import representation.map.IGraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS extends IGraph {

    public boolean dfs(int src,int dest){
        HashSet<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        if (!getMap().containsKey(src))
            return false;
        stack.push(src);
        while (!stack.isEmpty()){
            int vertex = stack.pop();
            if (set.contains(vertex))
                continue;
            set.add(vertex);
            if (vertex == dest)
                return true;
            stack.addAll(getMap().get(vertex).keySet());
        }
        return false;
    }

}
