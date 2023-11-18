package exercise;

import representation.map.IGraph;

import java.util.HashSet;
import java.util.Stack;

public class DFT extends IGraph {
    public void dft(){
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();
        for (Integer key : getMap().keySet()){
            if (set.contains(key))
                continue;
            stack.push(key);
            while (!stack.isEmpty()){
                int child = stack.pop();
                if (set.contains(child)) {
                    continue;
                }
                set.add(child);
                System.out.print(child+" --> ");
                stack.addAll(getMap().get(child).keySet());
            }
        }
        System.out.println(".");
    }
}
