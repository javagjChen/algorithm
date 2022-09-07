package weekgame;

/**
 * @author chengj
 * @Description
 * @Date 2022/9/4
 */
public class CheckDistances {

    public static void main(String[] args) {
        CheckDistances cd = new CheckDistances();
        int[] distance = new int[]{1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(cd.checkDistances("abaccb",distance));
    }


    public boolean checkDistances(String s, int[] distance) {

        for (int i = 0;i < distance.length;i++){
            char t = (char) ('a' + i);
            int start = s.indexOf(t);
            if (start == -1){
                continue;
            }
            int end = s.lastIndexOf(t);
            if(end - start - 1 != distance[i]){
                return false;
            }
        }

        return true;
    }
}
