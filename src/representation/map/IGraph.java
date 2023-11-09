package representation.map;

import representation.Graph;

import java.util.HashMap;
import java.util.HashSet;

public class IGraph implements Graph {
    private HashMap<Integer,HashMap<Integer,Integer>> map;
    public IGraph(){
        this.map = new HashMap<>();
    }
    @Override
    public void add(int from, int to,int data){
        try {
            if (this.map.containsKey(from)){
                if (this.map.get(from).containsKey(to)){
                    this.set(from, to, data);
                }else{
                    this.map.get(from).put(to,data);
                }
            }else{
                HashMap<Integer,Integer> children = new HashMap<>();
                children.put(to,data);
                this.map.put(from,children);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void delete(int from, int to){
        try {
            if (this.map.containsKey(from) && this.map.containsKey(to)){
                this.map.get(from).remove(to);
                this.map.get(to).remove(from);
            }else throw new Exception("Unable to proceed delete ops :: Vertices not found");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void get(int from, int to){
        try {
            if (map.containsKey(from) && map.containsKey(to)){
                if (map.get(from).get(to) == map.get(to).get(from) && map.get(to).get(from) != null)
                    System.out.println(map.get(from).get(to));
                else throw new Exception("Unable to proceed get ops :: Wrong edges address");
            }else throw new Exception("Unable to proceed get ops :: Wrong edges address");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void set(int from, int to,int data){
        try {
            if (map.containsKey(from) && map.containsKey(to)){
                if (map.get(from).containsKey(to) && map.get(to).containsKey(from)){
                    map.get(from).put(to,data);
                    map.get(to).put(from,data);
                }else throw new Exception("Unable to proceed set ops :: Edges linking not found");
            }else throw new Exception("Unable to proceed set ops :: Edges linking not found");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void display() {
        for(Integer key : map.keySet()){
            System.out.println(key+" --> "+map.get(key));
        }
    }

    @Override
    public int noOfEdges() {
        int result = 0;
        for (int key : map.keySet()){
            result += map.get(key).size();
        }
        if (result > 0)
            return result/2;
        return 0;
    }

    @Override
    public boolean hasPath(int source,int dest) {
        HashSet<Integer> pathMap = new HashSet<>();
        return hasPath(source,dest,pathMap);
    }

    private boolean hasPath(int source, int dest,HashSet<Integer> pathMap) {
        if (source == dest)
            return true;
        if (map.containsKey(source)){
            pathMap.add(source);
            for (int key : map.get(source).keySet()){
                if (pathMap.contains(key))
                    continue;
                boolean result = hasPath(key, dest, pathMap);
                if (result)
                    return true;
            }
        }
        return false;
    }

    @Override
    public void printAllPaths(int source, int dest) {
        printAllPaths(source, dest, new HashSet<Integer>(),"");
    }

    private void printAllPaths(int source,int dest,HashSet<Integer> pathMap,String result){
        if (source == dest) {
            System.out.println(result.substring(0,result.length())+dest+" .");
            return;
        }
        if (map.containsKey(source)){
            result += source+" --> ";
            pathMap.add(source);
            for (int key : map.get(source).keySet()){
                if (pathMap.contains(key))
                    continue;
                printAllPaths(key, dest, pathMap, result);
            }
            pathMap.remove(source);
        }
    }
}
