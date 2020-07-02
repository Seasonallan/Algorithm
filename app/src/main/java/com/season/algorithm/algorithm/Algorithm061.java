package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;


public class Algorithm061 extends AlgorithmTree {

    /**
     * @return
     */
    @Override
    public String getName() {
        return "061-序列化二叉树";
    }

    @Override
    public String getDesc() {
        return "把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。" +
                "序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，" +
                "序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）";
    }

    TreeNode treeRoot;
    @Override
    public String prepare() {
        treeRoot = getNode();
        return logTreeNode(treeRoot);
    }

    String res;
    @Override
    public void execute() {
        res = serialTree(treeRoot);
    }

    @Override
    public String verify() {
        index = -1;
        log(res);
        treeRoot = fromSerial(res);
        return logTreeNode(treeRoot);
    }


    public static String serialTree(TreeNode root){
        if(root == null){
            return "#!";
        }
        return root.val+"!" + serialTree(root.left) + serialTree(root.right);
    }

    int index;
    public TreeNode fromSerial(String serialString){
        String[] splits = serialString.split("!");
        TreeNode node = null;
        index++;
        if(!splits[index].equals("#")){
            node = new TreeNode(Integer.valueOf(splits[index]));
            node.left = fromSerial(serialString);
            node.right = fromSerial(serialString);
        }

        return node;
    }
}
