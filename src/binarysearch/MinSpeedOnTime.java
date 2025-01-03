package binarysearch;

/**
 * @author chengj
 * @Description 1870.准时到达的列车最小时速 中等
 * @Date 2022/6/21
 */
//给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，
//其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
//
// 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
//
//
// 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
//
//
// 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
//
// 生成的测试用例保证答案不超过 10⁷ ，且 hour 的 小数点后最多存在两位数字 。
//
//
//
// 示例 1：
//
//
//输入：dist = [1,3,2], hour = 6
//输出：1
//解释：速度为 1 时：
//- 第 1 趟列车运行需要 1/1 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
//- 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
//- 你将会恰好在第 6 小时到达。
//
//
// 示例 2：
//
//
//输入：dist = [1,3,2], hour = 2.7
//输出：3
//解释：速度为 3 时：
//- 第 1 趟列车运行需要 1/3 = 0.33333 小时。
//- 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
//- 你将会在第 2.66667 小时到达。
//
// 示例 3：
//
//
//输入：dist = [1,3,2], hour = 1.9
//输出：-1
//解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
//
//
//
// 提示：
//
//
// n == dist.length
// 1 <= n <= 10⁵
// 1 <= dist[i] <= 10⁵
// 1 <= hour <= 10⁹
// hours 中，小数点后最多存在两位数字
//
// Related Topics 数组 二分查找 👍 27 👎 0
public class MinSpeedOnTime {

    public static void main(String[] args) {
        MinSpeedOnTime minSpeedOnTime = new MinSpeedOnTime();
        int[] dist = new int[]{1,1,100000};
        double hour = 2.01;
        System.out.println(minSpeedOnTime.minSpeedOnTime(dist,hour));
    }
    public int minSpeedOnTime(int[] dist, double hour) {

        int l = 0;
        int r = 1000000000 + 1;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (checkHour(dist,mid) <= hour){
                r = mid;
            }else {
                l = mid;
            }
        }
        if (r == 1000000000 + 1){
            return -1;
        }
        return r;
    }

    private double checkHour(int[] dist, int speed) {
        double ans = 0.0;
        int len = dist.length;
        for (int i = 0;i < len;i++){
            if (i != len - 1){
                int t = dist[i]/speed;
                if (dist[i] % speed != 0){
                    t++;
                }
                ans += t;
            }else {
                double t = (double) dist[i]/speed;
                ans += t;
            }
        }
        return ans;
    }

}
