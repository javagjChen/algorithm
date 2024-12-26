package weekgame;

public class MaxHeightOfTriangle {
    public static void main(String[] args) {
        MaxHeightOfTriangle mhot = new MaxHeightOfTriangle();
        System.out.println(mhot.maxHeightOfTriangle(2,4));
        System.out.println(mhot.maxHeightOfTriangle(2,1));
        System.out.println(mhot.maxHeightOfTriangle(1,1));
        System.out.println(mhot.maxHeightOfTriangle(10,1));
    }
    public int maxHeightOfTriangle(int red, int blue) {
        int red1 = red;
        int blue1 = blue;
        int ans1 = 0;
        int base = 1;
        boolean flag = true;
        while(true){
            if(flag){
                if(red1 >= base){
                    red1 -= base;
                }else{
                    break;
                }

            }else{
                if(blue1 >= base){
                    blue1 -= base;
                }else{
                    break;
                }
            }
            ans1++;
            base++;
            flag = !flag;
        }
        int red2 = red;
        int blue2 = blue;
        int ans2 = 0;
        base = 1;
        flag = true;
        while(true){
            if(flag){
                if(blue2 >= base){
                    blue2 -= base;
                }else{
                    break;
                }

            }else{
                if(red2 >= base){
                    red2 -= base;
                }else{
                    break;
                }
            }
            ans2++;
            base++;
            flag = !flag;
        }

        return Math.max(ans1,ans2);
    }
}
