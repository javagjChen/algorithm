package company;

/**
 * @author chengj
 * @Description
 * @Date 2022/5/24
 */
public class MinSpeed {

    public static void main(String[] args) {
        MinSpeed ms = new MinSpeed();
        int[] userStoryList = new int[]{805306368,805306368,805306368};
        System.out.println(ms.minSpeed(userStoryList, 1000000000));
    }

    public int minSpeed(int[] userStoryList, int H) {

        int left = 1;
        int right = 0;
        for (int val : userStoryList) {
            if (val > right) {
                right = val;
            }
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int val : userStoryList) {
                int tmp = val / mid;
                if (val % mid != 0) {
                    tmp++;
                }
                sum += tmp;
            }
            if (sum > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;

    }
}
