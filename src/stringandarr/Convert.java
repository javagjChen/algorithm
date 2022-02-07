package stringandarr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Z 字形变换
 * @Author chengj
 * @Date 2022/1/17
 */
public class Convert {

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (numRows < 2){
            return s;
        }
        List<StringBuffer> rows = new ArrayList<>();
        for (int i = 0;i< numRows;i++){
            rows.add(new StringBuffer());
        }
        int i =0;
        int flag  = -1;
        for (char c : s.toCharArray()){
            rows.get(i).append(c);
            if (i == 0 || i == numRows -1){
                flag = -flag;
            }
            i += flag;
        }
        StringBuffer res = new StringBuffer();
        for (StringBuffer sb : rows){

            res.append(sb);
        }
        return res.toString();
    }
}
