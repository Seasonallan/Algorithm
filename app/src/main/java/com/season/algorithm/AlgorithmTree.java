package com.season.algorithm;

import android.util.Log;

import com.season.algorithm.algorithm.Algorithm004;
import com.season.algorithm.support.TreeNode;

import java.util.List;


public abstract class AlgorithmTree implements IAlgorithm {

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


    public static String log(Object o){
        if (o == null){
            Log.e(TAG, "empty");
            return "empty";
        }else{
            if (o instanceof TreeNode){
                Log.e(TAG, ((TreeNode) o).val +"");
                return ((TreeNode) o).val +"";
            }else{
                Log.e(TAG, o.toString());
                return o.toString();
            }
        }
    }

    /**
     * 打印树
     * @param listNode
     */
    public static String logTreeNodeRight(TreeNode listNode){
        if (listNode == null){
            return "";
        }
        String res = listNode.val +"";
        res += "-";
        res += logTreeNodeRight(listNode.right);
        return res;
    }
    /**
     * 打印树
     * @param listNode
     */
    public static String logTreeNode(TreeNode listNode){
        String res = logTreeNodeMLR(listNode);
        Log.e(TAG, "前序（根左右）："+ res);
        Log.e(TAG, "中序（左根右）："+ logTreeNodeLMR(listNode));
        Log.e(TAG, "后续（左右根）："+ logTreeNodeLRM(listNode));
        return res;
    }
    /**
     * 打印树  前序（根左右）
     * @param listNode
     */
    public static String logTreeNodeMLR(TreeNode listNode){
        if (listNode == null){
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(listNode.val);
        stringBuffer.append("-");
        if (listNode.left != null){
            stringBuffer.append(logTreeNodeMLR(listNode.left));
        }else{
            stringBuffer.append("L-");
        }
        if (listNode.right != null){
            stringBuffer.append(logTreeNodeMLR(listNode.right));
        }else{
            stringBuffer.append("R-");
        }
        return stringBuffer.toString();
    }
    /**
     * 打印树  中序（左根右）:
     * @param listNode
     */
    public static String logTreeNodeLMR(TreeNode listNode){
        if (listNode == null){
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer();

        if (listNode.left != null){
            stringBuffer.append(logTreeNodeLMR(listNode.left));
        }else{
            stringBuffer.append("L-");
        }
        stringBuffer.append(listNode.val);
        stringBuffer.append("-");
        if (listNode.right != null){
            stringBuffer.append(logTreeNodeLMR(listNode.right));
        }else{
            stringBuffer.append("R-");
        }
        return stringBuffer.toString();
    }
    /**
     * 打印树  后续（左右根）:
     * @param listNode
     */
    public static String logTreeNodeLRM(TreeNode listNode){
        if (listNode == null){
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer();

        if (listNode.left != null){
            stringBuffer.append(logTreeNodeLRM(listNode.left));
        }else{
            stringBuffer.append("L-");
        }
        if (listNode.right != null){
            stringBuffer.append(logTreeNodeLRM(listNode.right));
        }else{
            stringBuffer.append("R-");
        }
        stringBuffer.append(listNode.val);
        stringBuffer.append("-");
        return stringBuffer.toString();
    }


    /**
     * 打印列表
     * @param listNode
     */
    public static String logList(List listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.size(); i++) {
            if (listNode.get(i) instanceof List){
                stringBuffer.append("(");
                stringBuffer.append(logList((List) listNode.get(i)));
                stringBuffer.append(")");
            }else{
                stringBuffer.append(listNode.get(i));
            }
            stringBuffer.append("-");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 打印数组
     * @param listNode
     */
    public static <T> String logArray(T[] listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.length; i++) {
            stringBuffer.append(listNode[i]);
            stringBuffer.append("-");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

}
