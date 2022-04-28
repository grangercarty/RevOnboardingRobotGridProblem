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

    public boolean isOffLimitCell(int row, int column) {
        boolean isOffLimits = false;
        for (int[] cell : offLimitCells) {
            isOffLimits = (isOffLimits || (cell[0] == row && cell[1] == column));
        }
        return isOffLimits;
    }

    public boolean findPath() {
        int[] location = new int[2];
        location[0] = 1;
        location[1] = 1;
        pathExists = !isOffLimitCell(location[0],location[1]);
        String direction = "Down";
        while (pathExists && (location[0] < numRows || location[1] < numColumns)) {
            if (direction.equals("Down")) {
                if ( location[0] >= numRows || isOffLimitCell(location[0]+1, location[1]) ) {
                    direction = "Right";
                }
                else {
                    robotPath.add(direction);
                    location[0]++;
                }
            }
            else if (direction.equals("Right")) {
                if ( location[1] >= numRows || isOffLimitCell(location[0], location[1]+1) ) {
                    direction = "Back";
                }
                else {
                    robotPath.add(direction);
                    location[1]++;
                    direction = "Down";
                }
            }
            else {
                if (robotPath.size() == 0) {
                    pathExists = false;
                }
                else {
                    direction = robotPath.get(robotPath.size()-1);
                    robotPath.remove(robotPath.size()-1);
                    if (direction.equals("Down")) {
                        direction = "Right";
                        location[0]--;
                    }
                    else {
                        direction = "Back";
                        location[1]--;
                    }
                }
            }
        }
        return pathExists;
    }

    public String printPath() {
        return robotPath.toString();
    }
}
