package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLog;
import java.util.Stack;

public class Algorithm065 extends AlgorithmLog {


    @Override
    public String getGroup() {
        return "图-回溯";
    }

    @Override
    public String getName() {
        return "065-矩阵中的路径(BFS)";
    }


    @Override
    public String getDesc() {
        return "判断在一个矩阵中是否存在一条路径，该路径顺序包含某字符串所有字符。" +
                "路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。" +
                "如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。";
    }

    Character[][] input;
    String find = "bfce";
    @Override
    public String prepare() {
        input = new Character[][]{{'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}};
        return "字符串：" + find +"\n数组"+ logArray(input);
    }

    @Override
    public void execute() {
        res = hasPath(input, find);
    }

    boolean res;
    @Override
    public String verify() {
        return res?"是, 路径：" + logStack(path):"否";
    }

    boolean hasPath(Character[][] matrix,String string){
        int rows=matrix.length;
        int cols=matrix[0].length;
        if (matrix==null||rows<1||cols<1||string==""){
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];
        path = new Stack<>();
        int pathLength=0;

        for (int row=0;row<rows;row++){
            for (int col=0;col<cols;col++){
                if (hasPathCore(matrix,rows,cols,row,col,string,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    Stack<String> path = new Stack<>();
    boolean hasPathCore(Character[][] matrix,
                                       int rows,int cols,
                                       int row,int col,
                                       String string,int pathLength,
                                       boolean[][] visited){
        if (pathLength==string.length()){
            return true;
        }
        boolean hasPath=false;
        if (    row>=0&&row<rows
                &&col>=0&&col<cols
                &&matrix[row][col]==string.charAt(pathLength)
                &&(!visited[row][col])){
            pathLength++;
            visited[row][col]=true;
            path.push("("+row +","+ col+")");
            hasPath = hasPathCore(matrix,rows,cols,row,col-1,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row-1,col,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row,col+1,string,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row+1,col,string,pathLength,visited);
            if (!hasPath){
                pathLength--;
                visited[row][col]=false;
                path.pop();
            }
        }

        return hasPath;
    }

}
