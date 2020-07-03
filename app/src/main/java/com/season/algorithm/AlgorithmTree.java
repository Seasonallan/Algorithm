package com.season.algorithm;

import com.season.algorithm.algorithm.Algorithm004;
import com.season.algorithm.support.TreeNode;


public abstract class AlgorithmTree extends AlgorithmLog {

    @Override
    public String getGroup() {
        return "Tree";
    }


    public static TreeNode getNode(){
        return Algorithm004.buildTreeNode(new Integer[]{1,2,4,7,3,5,6,8},
                new Integer[]{4,7,2,1,5,3,8,6});
    }

    public static int getNodeCount(TreeNode listNode){
        int count = 1;
        if (listNode.left != null){
            count += getNodeCount(listNode.left);
        }
        if (listNode.right != null){
            count += getNodeCount(listNode.right);
        }
        return count;
    }

    /**
     * 获取树的深度
     * @param listNode
     * @return
     */
    public static int getTreeDepth(TreeNode listNode){
        if (listNode == null){
            return 0;
        }
        int leftDepth = getTreeDepth(listNode.left);
        int rightDepth = getTreeDepth(listNode.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


}
