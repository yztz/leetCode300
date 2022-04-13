package s78;
/* https://leetcode-cn.com/problems/insert-delete-getrandom-o1/ */
import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map = new HashMap<>(); // O(1) 插入删除 为什么不用set？因为要O(1)判断元素存在
    List<Integer> list = new ArrayList<>(); // 随机存取
    Random random = new Random();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        int n = list.size();
        map.put(val, n - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int idx = map.get(val);
        int n = list.size();
        int tmp = list.get(n - 1);
        list.set(n - 1, val);
        list.set(idx, tmp);
        map.put(tmp, idx);
        map.remove(val);
        list.remove(n - 1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
