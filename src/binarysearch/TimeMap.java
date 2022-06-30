package binarysearch;

import java.util.*;

/**
 * @author chengj
 * @Description 981.基于时间的键值存储 中等
 * @Date 2022/6/29
 */
//设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
//
// 实现 TimeMap 类：
//
//
// TimeMap() 初始化数据结构对象
// void set(String key, String value, int timestamp) 存储键 key、值 value，以及给定的时间戳
//timestamp。
// String get(String key, int timestamp)
//
// 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp 。
//
// 如果有多个这样的值，则返回对应最大的 timestamp_prev 的那个值。
// 如果没有值，则返回空字符串（""）。
//
//
//
//
//
// 示例：
//
//
//输入：
//["TimeMap", "set", "get", "get", "set", "get", "get"]
//[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4]
//, ["foo", 5]]
//输出：
//[null, null, "bar", "bar", null, "bar2", "bar2"]
//
//解释：
//TimeMap timeMap = new TimeMap();
//timeMap.set("foo", "bar", 1);  // 存储键 "foo" 和值 "bar" ，时间戳 timestamp = 1
//timeMap.get("foo", 1);         // 返回 "bar"
//timeMap.get("foo", 3);         // 返回 "bar", 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯
//一的值位于时间戳 1 处（即 "bar"） 。
//timeMap.set("foo", "bar2", 4); // 存储键 "foo" 和值 "bar2" ，时间戳 timestamp = 4
//timeMap.get("foo", 4);         // 返回 "bar2"
//timeMap.get("foo", 5);         // 返回 "bar2"
//
//
//
//
// 提示：
//
//
// 1 <= key.length, value.length <= 100
// key 和 value 由小写英文字母和数字组成
// 1 <= timestamp <= 10⁷
// set 操作中的时间戳 timestamp 都是严格递增的
// 最多调用 set 和 get 操作 2 * 10⁵ 次
//
// Related Topics 设计 哈希表 字符串 二分查找 👍 169 👎 0
public class TimeMap {

    public static Map<String, TreeMap<Integer,String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // 检查一下有没有哈希表，如果有的话就直接添加，没有的话就需要 new 出来一个再添加 key-value
        TreeMap<Integer, String> mapper = data.getOrDefault(key, new TreeMap<>((o1, o2) -> o2 - o1));
        mapper.put(timestamp, value);
        data.put(key, mapper);

    }

    // 非二分解法
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> mapper = data.get(key);
        if (mapper == null || mapper.isEmpty()){
            return "";
        }
        for (int time : mapper.keySet()) if (time <= timestamp) return mapper.get(time);
        return "";

    }

    /**
     * 二分解法
     */
    class TimeMap2{
        private Map<String, List<Object[]>> map;

        public TimeMap2() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Object[]> list = map.getOrDefault(key, new ArrayList<>());
            list.add(new Object[]{value, timestamp});
            if(!map.containsKey(key)){
                map.put(key, list);
            }

        }

        public String get(String key, int timestamp) {
            if(map.containsKey(key)){
                List<Object[]> list = map.get(key);
                int l = -1,  r = list.size();
                while(l + 1 != r){
                    int mid = l+(r-l)/2;
                    int timestamp_prev  = (int)list.get(mid)[1];
                    if(timestamp_prev<=timestamp){
                        l = mid;
                    } else{
                        r = mid;
                    }
                }
                if(l == -1){
                    return "";
                } else{
                    return (String)list.get(l)[0];
                }
            }
            return "";
        }



    }




}
