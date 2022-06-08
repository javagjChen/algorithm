package binarysearch;

/**
 * @author chengj
 * @Description 875.爱吃香蕉的珂珂 中等
 * @Date 2022/6/8
 */
//珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
//
// 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
//
// 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：piles = [3,6,7,11], h = 8
//输出：4
//
//
// 示例 2：
//
//
//输入：piles = [30,11,23,4,20], h = 5
//输出：30
//
//
// 示例 3：
//
//
//输入：piles = [30,11,23,4,20], h = 6
//输出：23
//
//
//
//
// 提示：
//
//
// 1 <= piles.length <= 10⁴
// piles.length <= h <= 10⁹
// 1 <= piles[i] <= 10⁹
//
// Related Topics 数组 二分查找 👍 390 👎 0
public class MinEatingSpeed {

    public static void main(String[] args) {
        MinEatingSpeed mes = new MinEatingSpeed();
        int[] piles = new int[]{30,11,23,4,20};
        int h = 6;
        System.out.println(mes.minEatingSpeed(piles,h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        //找到最大值
        int max = piles[0];
        for (int i = 1;i < piles.length;i++){
            if (piles[i] > max){
                max = piles[i];
            }
        }
        int r = max + 1;
        while (l + 1 != r){
            int mid = l + (r - l)/2;
            if (checkHours(piles,mid) <= h){
                r = mid;
            }else {
                l = mid;
            }
        }
        return r;
    }
    // 3,6,7,11
    private int checkHours(int[] piles,int mid) {
        int count = 0;
        for (int val : piles){
            count += val%mid == 0? val/mid : (val/mid + 1);
        }
        return count;
    }
}
