package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;


public class Algorithm038 extends AlgorithmTree {

    @Override
    public String getName() {
        return "038-二叉树的深度";
    }

    @Override
    public String getDesc() {
        return "输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,4,7,11,19,3,5,6,8},
                new Integer[]{4,7,11,19,2,1,5,3,8,6});
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        count = getTreeDepth(treeRoot);
    }

    int count = 0;
    @Override
    public String verify() {
        return "树深度："+count+"";
    }


}
