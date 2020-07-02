package com.season.algorithm.support;

public class TreeLinkNode extends TreeNode{
    public TreeLinkNode next;
    public TreeLinkNode(int val){
        super(val);
    }
    public TreeLinkNode(TreeLinkNode parent, int val){
        super(val);
        next = parent;
    }
}
