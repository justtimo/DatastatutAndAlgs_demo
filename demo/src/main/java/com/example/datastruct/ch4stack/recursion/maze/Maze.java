package com.example.datastruct.ch4stack.recursion.maze;

/**
 * 利用递归解决迷宫问题
 */
public class Maze {
    private int[][] map = new int[8][7];

    /**
     * 1表示墙
     */
    public void setWall() {
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[5][3] = 1;
    }

    public void showMap() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 找出口: 1 墙, 0 没走过, 2 表示可以走通, 3 走过了但是没走通
     *
     * @param i 我
     * @param j j
     * @return boolean
     */
    public boolean findWay(int i, int j) {
        //策略: 下-右-上-左
        if (map[6][1] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(i + 1, j)) {
                    return true;
                } else if (findWay(i, j + 1)) {
                    return true;
                } else if (findWay(i - 1, j)) {
                    return true;
                } else if (findWay(i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }
}
class Test{
    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.setWall();
        maze.showMap();
        System.out.println("------------------");
        System.out.println("------------------");
        maze.findWay(1,1);
        maze.showMap();
    }
}