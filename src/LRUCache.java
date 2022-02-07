import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/13
 */
public class LRUCache {

    public int size;

    public LinkedList<Integer> linkedList;

    public Map<Integer,Integer> map;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        linkedList = new LinkedList<>();
        size = capacity;
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (result == null){
            return -1;
        }
        linkedList.addFirst(key);
        return result;
    }

    public void put(int key, int value) {
        if (map.size() == size){
            int lastKey = linkedList.getLast();
            linkedList.removeLast();
            map.remove(lastKey);
        }
        if (linkedList.contains(key)){
            map.put(key,value);
            linkedList.remove(key);
            linkedList.addFirst(key);
        }else {
            linkedList.addFirst(key);
            map.put(key,value);
        }


    }
    //["LRUCache","get","put","get","put","put","get","get"]
    //[[2],         [2],[2,6], [1],  [1,5],[1,2],[1],  [2]]
    //[null,        -1, null,   -1,null,null,     2,   -1]
    //[null,        -1,null,    -1,null,null,     2,    6]
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.put(4,4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
