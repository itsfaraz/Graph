package representation.map;

import representation.Graph;

import java.util.HashMap;

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
}
