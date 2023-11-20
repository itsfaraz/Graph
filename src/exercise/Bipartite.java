package exercise;

import kotlin.Pair;
import representation.map.IGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite extends IGraph {
    public boolean isBipartite(){
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int key : getMap().keySet()){
            if (map.containsKey(key))
                continue;
            Queue<Pair<Integer,Boolean>> queue = new LinkedList<>();
            queue.add(new Pair<>(key,true));
            while (!queue.isEmpty()){
                Pair<Integer,Boolean> vertexPair = queue.poll();
                Integer vertex = vertexPair.component1();
                Boolean color = vertexPair.component2();
                if (map.containsKey(vertex) && map.get(vertex) == color)
                    continue;
                if (map.containsKey(vertex) && map.get(vertex) != color){
                    return false;
                }
                map.put(vertex,color);
                for (int children : getMap().get(vertex).keySet()){
                    queue.add(new Pair<>(children,!color));
                }
            }
        }
        return true;
    }
}
