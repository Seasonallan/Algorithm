package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Algorithm060 extends AlgorithmTree {

    /**
     * @return
     */
    @Override
    public String getName() {
        return "060-把二叉树打印成多行";
    }

    @Override
    public String getDesc() {
        return "从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        return logTreeNode(treeRoot);
    }

    ArrayList<ArrayList<Integer>> res;
    @Override
    public void execute() {
        res = getTop2BottomList(treeRoot);
    }

    @Override
    public String verify() {
        return logList(res);
    }


    /**
     * @see Algorithm059 类似算法，没有之字型的反转
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> getTop2BottomList(TreeNode root){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) {
            return new ArrayList<>();
        }

        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while(count > 0){//当前层级队列操作
                TreeNode temp = queue.poll();
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);

                list.add(temp.val);

                count--;
            }
            res.add(list);
        }
        return res;
    }

}
