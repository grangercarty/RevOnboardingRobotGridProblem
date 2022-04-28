package com.github.grangercarty.revonboardingrobotgridproblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotGridTest {

    @Test
    public void findPathTest() {
        RobotGrid roboGrid = new RobotGrid(1, 1);
        Assertions.assertTrue(roboGrid.findPath());

        RobotGrid roboGrid2 = new RobotGrid(2,2);
        Assertions.assertTrue(roboGrid2.findPath());
        System.out.println(roboGrid2.printPath());

        RobotGrid roboGrid3 = new RobotGrid(2,2);
        roboGrid3.addOffLimitCell(2,1);
        Assertions.assertTrue(roboGrid3.isOffLimitCell(2,1));
        Assertions.assertTrue(roboGrid3.findPath());
        System.out.println(roboGrid3.printPath());

        RobotGrid roboGrid4 = new RobotGrid(4,4);
        roboGrid4.addOffLimitCell(4,1);
        roboGrid4.addOffLimitCell(3,2);
        roboGrid4.addOffLimitCell(2,3);
        Assertions.assertTrue(roboGrid4.findPath());
        System.out.println(roboGrid4.printPath());
    }
}
