package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.Arrays;

public class Algorithm004 extends AlgorithmTree {

    @Override
    public String getName() {
        return "004-重建二叉树";
    }

    @Override
    public String getDesc() {
        return "输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。";
    }

    Integer[] mlrTree, lmrTree;
    @Override
    public String prepare() {
        mlrTree = new Integer[]{1,2,4,7,3,5,6,8};
        lmrTree =  new Integer[]{4,7,2,1,5,3,8,6};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("前序（根左右）:");
        stringBuffer.append(logArray(mlrTree));
        stringBuffer.append("\n");
        stringBuffer.append("中序（左根右）:");
        stringBuffer.append(logArray(lmrTree));
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
        treeNode = buildTreeNode(mlrTree, lmrTree);
        //treeNode = buildTreeNode(mlrTree, 0, mlrTree.length - 1,lmrTree, 0, lmrTree.length - 1);
    }

    @Override
    public String verify() {
        return logTreeNode(treeNode);
    }


    public static TreeNode buildTreeNode(Integer[] mlrTree, int start, int end,
                                   Integer[] lmrTree, int rStart, int rEnd) {
        if(mlrTree.length == 0 || lmrTree.length == 0){
            return null;
        }
        if (start > end || rStart > rEnd){
            return null;
        }
        TreeNode root = new TreeNode(mlrTree[start]);
        for(int i = rStart; i <= rEnd; i++){
            if(mlrTree[start] == lmrTree[i]){//根节点
                root.left = buildTreeNode(mlrTree, start + 1, start + i - rStart,
                        lmrTree, rStart, i - 1); //左树
                root.right = buildTreeNode(mlrTree, i - rStart + start +1, end,
                        lmrTree, i+1, rEnd); //右树
                break;
            }
        }
        return root;
    }

    TreeNode treeNode;
    public static TreeNode buildTreeNode(Integer[] mlrTree, Integer[] lmrTree) {
        if(mlrTree.length == 0||lmrTree.length == 0)
            return null;
        TreeNode root = new TreeNode(mlrTree[0]);
        for(int i = 0; i < lmrTree.length; i++){
            if(mlrTree[0] == lmrTree[i]){//根节点
                root.left = buildTreeNode(Arrays.copyOfRange(mlrTree, 1, i+1),
                        Arrays.copyOfRange(lmrTree, 0, i)); //左树
                root.right = buildTreeNode(Arrays.copyOfRange(mlrTree, i+1, mlrTree.length),
                        Arrays.copyOfRange(lmrTree, i+1,lmrTree.length)); //右树
                break;
            }
        }
        return root;
    }


}
