package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Algorithm059 extends AlgorithmTree {

    /**
     * @return
     */
    @Override
    public String getName() {
        return "059-按之字形顺序打印二叉树";
    }

    @Override
    public String getDesc() {
        return "第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        return logTreeNode(treeRoot);
    }

    ArrayList<Integer> res;
    @Override
    public void execute() {
        res = getTop2BottomZi(treeRoot);
    }

    @Override
    public String verify() {
        return logList(res);
    }


    /**
     * @see Algorithm022 类似算法，添加一层对每一层的排列
     * @param root
     * @return
     */
    public static ArrayList<Integer> getTop2BottomZi(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            int count = queue.size();//1,2,4,8.....
            List<Integer> list = new ArrayList<>();
            while(count > 0){//当前层级队列操作
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);

                if(reverse){
                    list.add(0, temp.val);
                }else{
                    list.add(temp.val);
                }
                count--;
            }
            res.addAll(list);
            reverse = !reverse;
        }
        return res;
    }

}
