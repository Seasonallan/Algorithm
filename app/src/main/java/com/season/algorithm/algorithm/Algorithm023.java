package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmTree;
import com.season.algorithm.support.TreeNode;

public class Algorithm023 extends AlgorithmTree {

    /**
     * 二叉查找树（Binary Search Tree），
     * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
     * @return
     */
    @Override
    public String getName() {
        return "023-二叉搜索树的后序遍历序列";
    }

    @Override
    public String getDesc() {
        return "输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。";
    }


    //Integer[] lrm = {7,4,2,5,8,6,3,1};
    Integer[] lrm = {2,9,5,16,17,15,19,18,12};
    @Override
    public String prepare() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("数组:");
        stringBuffer.append(logArray(lrm));
        return stringBuffer.toString();
    }

    @Override
    public void execute() {
        res = isTreeLRM(lrm);
    }

    @Override
    public String verify() {
        return res ?"是":"否";
    }

    boolean res;
    public static boolean isTreeLRM(Integer[] array){
        return isTreeLRM(array, 0, array.length - 1);
    }

    public static boolean isTreeLRM(Integer[] array, int start, int end){
        if (start > end){
            return true;
        }
        int rootNode = array[end];
        int lr = start;
        while (array[lr]  < rootNode){
            lr ++;
        }
        int index = lr;
        while (index < end){
            if (array[index] < rootNode){
                return false;//校验后面的数据是否都是大于root节点
            }
            index ++;
        }
        return isTreeLRM(array, start, lr - 1) && isTreeLRM(array, lr, end -1);
    }

}
