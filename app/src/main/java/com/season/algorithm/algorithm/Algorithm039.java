package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;


public class Algorithm039 extends AlgorithmTree {

    /**
     * 平衡二叉树具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
     * @return
     */
    @Override
    public String getName() {
        return "039-平衡二叉树";
    }

    @Override
    public String getDesc() {
        return "输入一棵二叉树，判断该二叉树是否是平衡二叉树。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,4,7,11,3,5,6,8},
                new Integer[]{4,7,11,2,1,5,3,8,6});
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,4,3,5,6,8},
                new Integer[]{4,2,1,5,3,8,6});
        return logTreeNode(treeRoot);
    }

    @Override
    public void execute() {
        count = getMaxDepth(treeRoot);
    }

    public static int getMaxDepth(TreeNode treeNode){
        if (treeNode == null){
            return 0;
        }
        int currentCount = getTreeDepth(treeNode.left) - getTreeDepth((treeNode.right));
        int leftCount = getMaxDepth(treeNode.left);
        int rightCount = getMaxDepth(treeNode.right);
        return Math.max(Math.max(currentCount, leftCount), rightCount);
    }

    int count = 0;
    @Override
    public String verify() {
        return "左右两个子树的最大高度差："+count+"，" + (count <= 1?"是平衡二叉树":"不是平衡二叉树");
    }


}
