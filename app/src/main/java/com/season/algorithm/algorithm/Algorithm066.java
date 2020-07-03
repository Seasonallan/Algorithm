package com.season.algorithm.algorithm;

import com.season.algorithm.AlgorithmLog;

public class Algorithm066 extends AlgorithmLog {


    @Override
    public String getGroup() {
        return "图";
    }

    @Override
    public String getName() {
        return "066-机器人的运动范围(DFS)";
    }


    /**
     * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
     * 请问该机器人能够到达多少个格子？
     * @return
     */
    @Override
    public String getDesc() {
        return "地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。" +
                "一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），" +
                "也不能进入行坐标和列坐标的数位之和大于k的格子。";
    }

    int rows, cols, count;
    @Override
    public String prepare() {
        rows = 8; cols = 8; count = 8;
        return "行：" + rows +"\n列："+ cols +"\nK："+count;
    }

    @Override
    public void execute() {
        res = movingCount(rows, cols, count);
    }

    int res;
    @Override
    public String verify() {
        return "" + res;
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, 0, 0, visited, m, n, k);
    }

    /**
     *
     * @param i 当前位置
     * @param j 当前位置
     * @param si i值的位和，如i=13时，si=1+3=4
     * @param sj 同理si
     * @param visited 数组访问记录
     * @param m 数组行数
     * @param n 数组烈属
     * @param k K
     * @return
     */
    public int dfs(int i, int j, int si, int sj, boolean[][] visited, int m, int n,int k) {
        if(i < 0 || i >= m || j < 0 || j >= n || k < si + sj || visited[i][j])
            return 0;
        visited[i][j] = true;
        return 1 +
                dfs(i + 1, j, getNextNode(i, si), sj, visited, m, n, k) +
                dfs(i, j + 1, si, getNextNode(j, sj), visited, m, n, k);
    }

    //计算下一个节点的位数和
    // 19>>10   20>>10-8=2
    // 29>>11   30>>11-8=3
    public int getNextNode(int i, int si){
        return (i + 1) % 10 != 0 ? si + 1 : si - 8;
    }

}
