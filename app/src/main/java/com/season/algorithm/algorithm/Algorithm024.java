package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;

public class Algorithm024 extends AlgorithmTree {

    @Override
    public String getName() {
        return "024-二叉树中和为某一值的路径";
    }

    @Override
    public String getDesc() {
        return "输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。";
    }


    TreeNode treeRoot;
    int count = 18;
    @Override
    public String prepare() {
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,4,11, 7,3,5,6,8},
                new Integer[]{11,4,7,2,1,5,3,8,6});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("和:");
        stringBuffer.append(count);
        stringBuffer.append("\n");
        stringBuffer.append("tree:");
        stringBuffer.append(logTreeNode(treeRoot));
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
        res = getTreeCountEquals(treeRoot, count);
    }

    @Override
    public String verify() {
        return logList(res);
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> getTreeCountEquals(TreeNode root, int target){

        if(root == null) return res;

        list.add(root.val);
        target -= root.val; //下一个节点到底的和

        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));   //找到路径，复制路径
        }

        getTreeCountEquals(root.left, target);
        getTreeCountEquals(root.right, target);

        list.remove(list.size()-1); //每次递归到这里都是当前节点下到路径已经算完，切换节点

        return res;

    }

}
