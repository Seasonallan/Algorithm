package com.season.algorithm.ui;

import java.util.ArrayList;
import java.util.List;

public class Bean {

    public String name;
    public String groupName;

    public Bean(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
    }

    public static List<Bean> buildTestBean(){

        List<Bean> beanList = new ArrayList<>();
        String[] items = new String[]{"003-从尾到头打印链表","014-链表中倒数第k个结点",
                "015-反转链表","016-合并两个或k个有序链表"
                ,"025-复杂链表的复制","036-两个链表的第一个公共结点","055-链表中环的入口结点"
                ,"056-删除链表中重复的结点"};
        for (String item: items) {
            beanList.add(new Bean(item, "LinkedList链表"));
        }
        items = new String[]{"004-重建二叉树","017-树的子结构"
                ,"018-二叉树的镜像","022-从上往下打印二叉树"
                ,"023-二叉搜索树的后序遍历序列","024-二叉树中和为某一值的路径"
                ,"026-二叉搜索树与双向链表","038-二叉树的深度"
                ,"039-平衡二叉树","057-二叉树的下一个结点"
                ,"058-对称的二叉树","059-按之字形顺序打印二叉树"
                ,"060-把二叉树打印成多行","061-序列化二叉树"
                ,"062-二叉搜索树的第k个结点"};
        for (String item: items) {
            beanList.add(new Bean(item, "Tree"));
        }

        items = new String[]{"005-用两个栈实现队列","020-包含min函数的栈"
                ,"021-栈的压入、弹出序列","044-翻转单词顺序列(栈)"
                ,"064-滑动窗口的最大值(双端队列)"};
        for (String item: items) {
            beanList.add(new Bean(item, "Stack & Queue"));
        }

        items = new String[]{"029-最小的K个数"};
        for (String item: items) {
            beanList.add(new Bean(item, "Heap"));
        }

        items = new String[]{"034-第一个只出现一次的字符"};
        for (String item: items) {
            beanList.add(new Bean(item, "Hash Table"));
        }

        items = new String[]{"065-矩阵中的路径(BFS)","066-机器人的运动范围(DFS)"};
        for (String item: items) {
            beanList.add(new Bean(item, "图"));
        }

        items = new String[]{"007-斐波拉契数列","008-跳台阶"
                ,"009-变态跳台阶","010-矩形覆盖"};
        for (String item: items) {
            beanList.add(new Bean(item, "斐波那契数列"));
        }

        items = new String[]{"001-二维数组查找","006-旋转数组的最小数字（二分查找"
                ,"037-数字在排序数组中出现的次数（二分查找）"};
        for (String item: items) {
            beanList.add(new Bean(item, "搜索算法"));
        }

        items = new String[]{"027-字符串的排列"};
        for (String item: items) {
            beanList.add(new Bean(item, "全排列"));
        }

        items = new String[]{"030-连续子数组的最大和","052-正则表达式匹配"};
        for (String item: items) {
            beanList.add(new Bean(item, "动态规划"));
        }
        items = new String[]{"065-矩阵中的路径(BFS)","066-机器人的运动范围(DFS)" };
        for (String item: items) {
            beanList.add(new Bean(item, "回溯"));
        }
        items = new String[]{"035-数组中的逆序对(归并排序)","029-最小的K个数"
                ,"029-最小的K个数" };
        for (String item: items) {
            beanList.add(new Bean(item, "排序"));
        }
        items = new String[]{"011-二进制中1的个数","012-数值的整数次方"
                ,"040-数组中只出现一次的数字" };
        for (String item: items) {
            beanList.add(new Bean(item, "位运算"));
        }
        items = new String[]{"002-替换空格","013-调整数组顺序使奇数位于偶数前面"
                ,"028-数组中出现次数超过一半的数字" ,"031-整数中1出现的次数（从1到n整数中1出现的次数）"
                ,"032-把数组排成最小的数" ,"033-丑数"
                ,"041-和为S的连续正数序列(滑动窗口思想)" ,"042-和为S的两个数字(双指针思想)"
                ,"043-左旋转字符串(矩阵翻转)" ,"046-孩子们的游戏-圆圈中最后剩下的数(约瑟夫环)"
                ,"051-构建乘积数组" };
        for (String item: items) {
            beanList.add(new Bean(item, "其他算法"));
        }

        return beanList;
    }


}
