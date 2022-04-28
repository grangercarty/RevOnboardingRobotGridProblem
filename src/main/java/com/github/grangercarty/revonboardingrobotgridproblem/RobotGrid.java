package com.github.grangercarty.revonboardingrobotgridproblem;

import java.util.ArrayList;

public class RobotGrid {
    int numRows;
    int numColumns;
    boolean pathExists;
    private ArrayList<int[]> offLimitCells;
    private ArrayList<Character> robotPath;

    public RobotGrid(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.pathExists = false;
    }

    public void addOffLimitCell(int row, int column) {
        int[] offLimitCell = new int[2];
        offLimitCell[0] = row;
        offLimitCell[1] = column;
        offLimitCells.add(offLimitCell);
    }

    public boolean findPath() {
        int[] location = new int[2];
        pathExists = true;
        return pathExists;
    }
}
