package day;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author chengj
 * @Description 593.有效的正方形 中等
 * @Date 2022/7/29
 */
//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。
//
//
//
// 示例 1:
//
//
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
//
//
// 示例 2:
//
//
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
//
//
// 示例 3:
//
//
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
//
//
//
//
// 提示:
//
//
// p1.length == p2.length == p3.length == p4.length == 2
// -10⁴ <= xi, yi <= 10⁴
//
// Related Topics 几何 数学 👍 125 👎 0
public class ValidSquare {

    public static void main(String[] args) {

        int[] p1 = new int[]{1,0};
        int[] p2 = new int[]{-1,0};
        int[] p3 = new int[]{0,1};
        int[] p4 = new int[]{0,-1};

        ValidSquare vs = new ValidSquare();
        System.out.println(vs.validSquare(p1,p2,p3,p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Double p1p3 = Math.sqrt(Math.pow(Math.abs(p3[0] - p1[0]),2) + Math.pow(Math.abs(p3[1]-p1[1]),2));
        if (p1p3.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Double p3p2 = Math.sqrt(Math.pow(Math.abs(p2[0] - p3[0]),2) + Math.pow(Math.abs(p2[1]-p3[1]),2));
        if (p3p2.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Double p2p4 = Math.sqrt(Math.pow(Math.abs(p4[0] - p2[0]),2) + Math.pow(Math.abs(p4[1]-p2[1]),2));
        if (p2p4.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Double p4p1 = Math.sqrt(Math.pow(Math.abs(p1[0] - p4[0]),2) + Math.pow(Math.abs(p1[1]-p4[1]),2));
        if (p4p1.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Double p1p2 = Math.sqrt(Math.pow(Math.abs(p2[0] - p1[0]),2) + Math.pow(Math.abs(p2[1]-p1[1]),2));
        if (p1p2.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Double p3p4 = Math.sqrt(Math.pow(Math.abs(p4[0] - p3[0]),2) + Math.pow(Math.abs(p4[1]-p3[1]),2));
        if (p3p4.compareTo(Double.valueOf("0")) == 0){
            return false;
        }
        Set<Double> set = new HashSet<>();
        set.add(p1p2);
        set.add(p1p3);
        set.add(p3p2);
        set.add(p3p4);
        set.add(p2p4);
        set.add(p4p1);
        return set.size() == 2;
    }
}
