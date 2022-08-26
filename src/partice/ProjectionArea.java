package partice;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/25
 */
public class ProjectionArea {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2},{3,4}};
        ProjectionArea  pa = new ProjectionArea();
        System.out.println(pa.projectionArea(grid));
        String a = "abcabcabaabcbcc";
        a = a.replaceAll("abc","");
        System.out.println(a);
    }

    /**
     * 模拟
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] col = new int[n];

        int count = 0;
        for (int i = 0;i < n;i++){
            int max = Integer.MIN_VALUE;
            int max2 = Integer.MIN_VALUE;
            for(int j = 0;j < n;j++){
                if(grid[j][i] > max){
                    max = grid[j][i];
                }
                if(grid[i][j] > max2){
                    max2 = grid[i][j];
                }
                if (grid[i][j] == 0){
                    count++;
                }
            }
            col[i] = max;
            row[i] = max2;
        }
        int sum = 0;
        for (int i = 0;i < n;i++){
            sum += row[i];
            sum += col[i];
        }
        return sum + (n*n) - count;
    }
}
