package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmOther;

import java.util.LinkedList;
import java.util.List;

public class Algorithm046 extends AlgorithmOther {

    @Override
    public String getName() {
        return "046-孩子们的游戏-圆圈中最后剩下的数(约瑟夫环)";
    }

    @Override
    public String getDesc() {
        return "随机指定一个数m,让编号为0的开始报数。每次喊到m-1的那个移除," +
                " 下一个继续0…m-1报数…这样下去…最后剩下的数字";
    }

    int count = 31;
    int key = 6;
    @Override
    public String prepare() {
        return "key="+key +"\ncount="+count;
    }

    @Override
    public void execute() {
        res = lastRemaining(count, key);
    }

    int res;
    @Override
    public String verify() {
        return "" + res;
    }

    /**
     * 使用环链表，每次删除第m个元素
     */
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1 ) {
            return -1;
        }
        List<Integer> tmp = new LinkedList<>();
        for (int i=0; i<n; i++) {
            tmp.add(i);
        }

        int idx = -1;
        while (tmp.size() > 1) {
            idx = (idx + m) % tmp.size();
            tmp.remove(idx);
            idx--;
        }

        return tmp.get(0);
    }

    /**
     * 约瑟夫环
     */
    public static int lastRemainingII (int n, int m) {
        if (n <= 0) {
            return -1;
        } else if (n == 1) {
            return 0;
        } else {
            return (lastRemainingII(n-1, m) + m) % n;
        }
    }

    /**
     * 使用公式
     */
    public static int lastRemainingIII (int n, int m) {
        if (n < 1 || m < 1 ) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }



}
