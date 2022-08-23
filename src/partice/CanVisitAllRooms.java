package partice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/19
 */
public class CanVisitAllRooms {

    /**
     * 广度优先搜索
     * @param rooms
     * @return
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        int num = 0;
        visited[0] = true;
        num++;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int size = queue.poll();
            for (int i : rooms.get(size)){
                if(!visited[i]){
                    visited[i] = true;
                    num++;
                    queue.add(i);
                }
            }
        }
        return num == n;
    }
}
