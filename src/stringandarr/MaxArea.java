package stringandarr;

/**
 * @Description
 * @Author chengj
 * @Date 2022/1/12
 */
public class MaxArea {


    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length -1;
        int result = 0;
        while (l < r){
            int minH = Math.min(height[l],height[r]);
            int area = minH * (r - l);
            result = Math.max(area,result);
            if (height[l] <= height[r]){
                l++;
            }else {
                r--;
            }
        }
        return result;
    }
}
