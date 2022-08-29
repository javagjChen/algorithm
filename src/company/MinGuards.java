package company;

import java.util.Locale;

/**
 * @author chengj
 * @Description
 * @Date 2022/8/26
 */
public class MinGuards {

    public static void main(String[] args) {
        MinGuards mg = new MinGuards();
        System.out.println(mg.minGuards("TT"));
        System.out.println(mg.minGuards("BTTBTTBTTBTTBBTBTTBTTB"));
        System.out.println(mg.minGuards("BBBTBBTBTBTBTBTBTBTTBBTBTBTBTBTTBB"));
        //System.out.println(mg.minGuards2("BTTBTTBTTBTTBBTBTTBTTBBTBBTBTBTBTBTBTBTTBBBTTBBBTBTBTBTBTBBTBTBTBTBTBBTTBTTBTTBBTTBTTBTTBBTTBTTBTTB"));
    }

    public int minGuards(String treasureStr) {
        //统计需要被保护的数量
        int total= 0 ;
        for(int i=0;i<treasureStr.length();i++){
            char c=treasureStr.charAt(i);
            if(c=='T'){
                total++;
            }
        }
        int[] used = new int[treasureStr.length()];
        // 保安人数
        int res=0;
        // 被保护的宝藏数目
        int count=0;
        int len=treasureStr.length();
        for(int i=0;i<treasureStr.length();i++){
            char c = treasureStr.charAt(i);
            if(c =='T'){
                if(i>0&&i<len-1&&treasureStr.charAt(i-1)=='B'&&treasureStr.charAt(i+1)=='B'){
                    if(used[i-1]==0){
                        used[i+1]=1;
                        res++;
                    }
                    //被保护的宝藏数目 + 1
                    count++;
                } else if(i>0&&i<len-1&&treasureStr.charAt(i-1)=='B'&&treasureStr.charAt(i+1)=='T'){
                    if(used[i-1] != 1){
                        used[i-1]=1;
                        res++;
                    }
                    //被保护的宝藏数目 + 1
                    count++;
                } else if(i<len-1&&treasureStr.charAt(i+1)=='B'){
                    used[i+1]=1;
                    res++;
                    count++;
                } else if(i>0&&treasureStr.charAt(i-1)=='B'){
                    if(used[i-1]==0){
                        used[i-1]=1;
                        res++;
                    }
                    //被保护的宝藏数目 + 1
                    count++;
                }
            }
        }
        if(count == total){
            return res;
        }else{
            return -1;
        }
    }

    public int minGuards2(String treasureStr) {
        int n = treasureStr.length();
        if (n == 1 && treasureStr.charAt(0) == 'T'){
            return -1;
        }
        if (n == 1 && treasureStr.charAt(0) == 'B'){
            return 0;
        }

        int num =0;
        // T未被保护的 B空仓 P 有保安保护的 S 被保护的
        char[] original = treasureStr.toCharArray();
        // 构建辅助数组
        char[] help = new char[n + 2];
        // 前后都是有保护的
        help[0] = 'S';
        help[n + 1] = 'S';
        for (int i = 1;i < help.length-1;i++){
            help[i] = original[i-1];
        }

        for (int i = 1;i < n + 1;i++){
            if (help[i-1] == 'T' && help[i] == 'B'){
                num++;
                help[i] = 'P';
                help[i-1] = 'S';
                help[i+1] = 'S';
            }else if (help[i-1] =='T'){
                if (i > 1 && help[i-2] == 'B'){
                    num++;
                    help[i-2] = 'P';
                    help[i-1] = 'S';
                }else {
                    return -1;
                }
            }
        }
        return num;
    }

}
