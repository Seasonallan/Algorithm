package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;


public class Algorithm058 extends AlgorithmTree {

    /**
     * @return
     */
    @Override
    public String getName() {
        return "058-对称的二叉树";
    }

    @Override
    public String getDesc() {
        return "如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{1,2,3,4,2,4,3},
                new Integer[]{3,2,4,1,4,2,3});
        return logTreeNode(treeRoot);
    }

    boolean res;
    @Override
    public void execute() {
        res = isSymmetrical(treeRoot.left, treeRoot.right);
    }

    @Override
    public String verify() {
        return res?"是":"否";
    }


    public static  boolean isSymmetrical(TreeNode left, TreeNode right) {
        if(left == null) return right==null;
        if(right == null) return false;
        if(left.val != right.val) return false;
        return isSymmetrical(left.right, right.left) && isSymmetrical(left.left, right.right);
    }

}
