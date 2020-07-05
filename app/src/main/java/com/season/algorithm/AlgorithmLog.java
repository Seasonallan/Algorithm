package com.season.algorithm;

import android.util.Log;

import com.season.algorithm.support.ListNode;
import com.season.algorithm.support.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 日志调试
 */
public abstract class AlgorithmLog implements IAlgorithm {

    public static final String TAG = "Algorithm";

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
     * 打印栈
     * @param stack
     * @param <T>
     * @return
     */
    public static <T> String logStack(Stack<T> stack){
        StringBuffer stringBuffer = new StringBuffer();
        for (T item : stack){
            stringBuffer.append(item);
            stringBuffer.append(",");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }


    /**
     * 打印object
     * @param o
     * @return
     */
    public static String log(Object o){
        if (o == null){
            Log.e(TAG, "empty");
            return "empty";
        }else{
            if (o instanceof ListNode){
                Log.e(TAG, ((ListNode) o).val +"");
                return ((ListNode) o).val +"";
            }else{
                Log.e(TAG, o.toString());
                return o.toString();
            }
        }
    }

    /**
     * 打印链表
     * @param listNode
     */
    public static String logListNode(ListNode listNode, boolean circle){
        ListNode first  = listNode;
        StringBuffer stringBuffer = new StringBuffer();
        HashMap<Integer, Integer> cache = new HashMap<>();
        while(first!=null){
            if (circle && cache.containsKey(first.val)){
                stringBuffer.append("-环形-");
                stringBuffer.append(first.val);
                break;
            }
            stringBuffer.append(first.val);
            if (first.random != null){
                stringBuffer.append("("+ first.random.val+")");
            }
            stringBuffer.append(",");
            cache.put(first.val, 1);
            first = first.next;
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }


    /**
     * 打印链表
     * @param listNode
     */
    public static String logListNode(ListNode listNode){
        return logListNode(listNode, true);
    }


    /**
     * 打印数组
     * @param listNode
     */
    public static <T> String logArray(T[] listNode){
        if (listNode == null){
            return "empty";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.length; i++) {
            stringBuffer.append(listNode[i]);
            stringBuffer.append(",");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

    /**
     * 打印数组
     * @param listNode
     */
    public static <T> String logArray(T[][] listNode){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < listNode.length; i++) {
            stringBuffer.append("(");
            for (int j = 0; j < listNode[i].length; j++) {
                stringBuffer.append(listNode[i][j]);
                stringBuffer.append(",");
            }
            stringBuffer.append(")");
        }
        Log.e(TAG, stringBuffer.toString());
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
            stringBuffer.append(",");
        }
        Log.e(TAG, stringBuffer.toString());
        return stringBuffer.toString();
    }

}
