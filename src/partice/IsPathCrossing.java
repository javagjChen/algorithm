package partice;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description 1496. 判断路径是否相交 简单
 * @Date 2022/9/16
 */
//给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
//
// 你从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
//
// 如果路径在任何位置上与自身相交，也就是走到之前已经走过的位置，请返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//
//
//输入：path = "NES"
//输出：false
//解释：该路径没有在任何位置相交。
//
// 示例 2：
//
//
//
//
//输入：path = "NESWW"
//输出：true
//解释：该路径经过原点两次。
//
//
//
// 提示：
//
//
// 1 <= path.length <= 10⁴
// path[i] 为 'N'、'S'、'E' 或 'W'
//
// Related Topics 哈希表 字符串 👍 40 👎 0
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        Set<Point> set = new HashSet<>();
        set.add(new Point(0,0));
        Point pre = new Point(0,0);
        for(char ch : path.toCharArray()){
            if(ch == 'N'){
                int x = pre.x;
                int y = pre.y + 1;
                Point n = new Point(x,y);
                if(!set.add(n)){
                    return true;
                }
                pre = n;
            }else if (ch == 'S'){
                int x = pre.x;
                int y = pre.y - 1;
                Point n = new Point(x,y);
                if(!set.add(n)){
                    return true;
                }
                pre = n;
            }else if (ch == 'E'){
                int x = pre.x + 1;
                int y = pre.y;
                Point n = new Point(x,y);
                if(!set.add(n)){
                    return true;
                }
                pre = n;
            }else {
                int x = pre.x - 1;
                int y = pre.y;
                Point n = new Point(x,y);
                if(!set.add(n)){
                    return true;
                }
                pre = n;
            }
        }
        return false;
    }
}
