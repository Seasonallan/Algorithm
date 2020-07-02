package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;


public class Algorithm062 extends AlgorithmTree {


    /**
     * 二叉查找树（Binary Search Tree），
     * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
     * @return
     */
    @Override
    public String getName() {
        return "062-二叉搜索树的第k个结点";
    }

    @Override
    public String getDesc() {
        return "给定一棵二叉搜索树，请找出其中的第k小的结点。";
    }

    TreeNode treeRoot;
    int k = 4;
    @Override
    public String prepare() {
        treeRoot = Algorithm004.buildTreeNode(new Integer[]{20,6,3,1,4,8,30,22},
                new Integer[]{1,3,4,6,8,20,22,30});
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("k = "+ k);
        stringBuffer.append("\n");
        stringBuffer.append("tree:");
        stringBuffer.append(logTreeNode(treeRoot));
        return stringBuffer.toString();
    }

    TreeNode res;
    @Override
    public void execute() {
        x = 0;
        res = getMinAfterK(treeRoot, k);
    }

    @Override
    public String verify() {
        return logTreeNode(res);
    }

    int x = 0;


    /**
     * 中序是排序好的
     * @see #logTreeNodeLMR(TreeNode)
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode getMinAfterK(TreeNode pRoot, int k){
        if(pRoot!=null)
        {
            TreeNode node = getMinAfterK(pRoot.left,k);
            if(node!=null)
                return node;
            x++;
            if(x == k)
                return pRoot;
            node = getMinAfterK(pRoot.right,k);
            if(node!=null)
                return node;
        }

        return null;
    }
}
