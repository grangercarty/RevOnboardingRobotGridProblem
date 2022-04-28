package com.github.grangercarty.revonboardingrobotgridproblem;

import java.util.ArrayList;

public class RobotGrid {
    int numRows;
    int numColumns;
    boolean pathExists;
    private ArrayList<int[]> offLimitCells;
    private ArrayList<String> robotPath;

    public RobotGrid(int rows, int columns) {
        this.numRows = rows;
        this.numColumns = columns;
        this.pathExists = false;
        this.offLimitCells = new ArrayList<>();
        this.robotPath = new ArrayList<>();
    }

    public void addOffLimitCell(int row, int column) {
        int[] offLimitCell = new int[2];
        offLimitCell[0] = row;
        offLimitCell[1] = column;
        offLimitCells.add(offLimitCell);
    }

    public boolean findPath() {
        int[] location = new int[2];
        location[0] = 1;
        location[1] = 1;
        pathExists = !offLimitCells.contains(location);
        String direction = "Down";
        while (pathExists && (location[0] < numRows || location[1] < numColumns)) {
            if (direction.equals("Down")) {
                if (location[0] < numRows) {
                    robotPath.add(direction);
                    location[0]++;
                }
                else {
                    direction = "Right";
                }
            }
            else if (direction.equals("Right")) {
                robotPath.add(direction);
                location[1]++;
            }
            else {
                if (robotPath.size() == 0) {
                    pathExists = false;
                }
            }
        }
        return pathExists;
    }

    public String printPath() {
        return robotPath.toString();
    }
}
