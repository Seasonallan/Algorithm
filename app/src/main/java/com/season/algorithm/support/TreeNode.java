package com.season.algorithm.support;

/**
 * 树形结构
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode copy(){
        return new TreeNode(val);
    }
}
