package stringandarr;

/**
 * @Description 移除元素
 * @Author chengj
 * @Date 2022/1/21
 */
public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,2,2,3},3));
    }
    public static int removeElement(int [] nums,int val){
        int ans =0;
        for (int num : nums){
            if (num != val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}
