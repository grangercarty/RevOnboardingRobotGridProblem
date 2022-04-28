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
    }
}
