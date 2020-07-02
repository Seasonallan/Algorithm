package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.Arrays;

public class Algorithm017 extends AlgorithmTree {

    @Override
    public String getName() {
        return "017-树的子结构";
    }

    @Override
    public String getDesc() {
        return "输入两棵二叉树A和B，判断B是不是A的子结构。";
    }

    TreeNode treeRoot, treeChild;
    @Override
    public String prepare() {
        treeRoot = getNode();
        treeChild = Algorithm004.buildTreeNode(new Integer[]{2,4,7},
                new Integer[]{4,2,7});
        //treeChild = Algorithm004.buildTreeNode(new Integer[]{2,4,7}, new Integer[]{4,7,2});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("treeRoot:");
        stringBuffer.append(logTreeNode(treeRoot));
        stringBuffer.append("\n");
        stringBuffer.append("treeChild:");
        stringBuffer.append(logTreeNode(treeChild));
        return stringBuffer.toString();
    }

    boolean res = false;
    @Override
    public void execute() {
        res = isTreeContainNode(treeRoot, treeChild);
    }

    @Override
    public String verify() {
        return res?"是":"否";
    }

    public static boolean isTreeContainNode(TreeNode root, TreeNode child){
        if (root == null || child == null){
            return false;
        }
        if (root.val == child.val){
            if (isTreeSub(root, child)){
                return true;
            }
        }
        if (isTreeContainNode(root.left, child)){
            return true;
        }
        if (isTreeContainNode(root.right, child)){
            return true;
        }

        return false;
    }


    public static boolean isTreeSub(TreeNode root, TreeNode child){
        if (child == null){//需要在root节点判断之前
            return true;
        }
        if (root == null){
            return false;
        }
        if (root.val == child.val){
            return isTreeSub(root.left, child.left) && isTreeSub(root.right, child.right);
        }
        return false;
    }

}
