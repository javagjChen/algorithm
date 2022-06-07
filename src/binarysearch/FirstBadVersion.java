package binarysearch;

/**
 * @author chengj
 * @Description 278.第一个错误的版本 简单
 * @Date 2022/6/6
 */
//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。
//
//
// 示例 1：
//
//
//输入：n = 5, bad = 4
//输出：4
//解释：
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//所以，4 是第一个错误的版本。
//
//
// 示例 2：
//
//
//输入：n = 1, bad = 1
//输出：1
//
//
//
//
// 提示：
//
//
// 1 <= bad <= n <= 2³¹ - 1
//
// Related Topics 二分查找 交互 👍 717 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
public class FirstBadVersion  {
    public static void main(String[] args) {
       FirstBadVersion fbv = new FirstBadVersion();
        System.out.println(fbv.firstBadVersion(5));
    }

    public int firstBadVersion(int n) {
        long l = 0;
        long r = (long)n + 1;
        while (l + 1 != r){
            long mid = l + (r - l)/2;
            boolean t = isBadVersion((int)mid);
            if (t){
                r = mid;
            }else {
                l = mid;
            }
        }
        return (int)r;
    }

    public boolean isBadVersion(int version){
        if (version <= 3){
            return false;
        }else {
            return true;
        }
    }
}
