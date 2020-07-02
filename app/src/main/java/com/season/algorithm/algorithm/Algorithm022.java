package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;

public class Algorithm022 extends AlgorithmTree {

    @Override
    public String getName() {
        return "022-从上往下打印二叉树";
    }

    @Override
    public String getDesc() {
        return "从上往下打印出二叉树的每个节点，同层节点从左至右打印。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        resList = getTop2Bottom(treeRoot);
    }

    @Override
    public String verify() {
        return logList(resList);
    }

    ArrayList<Integer> resList;
    public static ArrayList<Integer> getTop2Bottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode temp = queue.remove(0); //移除并返回 第一个值
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
    }

}
