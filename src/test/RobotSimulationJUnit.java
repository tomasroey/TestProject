package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class RobotSimulationJUnit {

	@Test
	public void test() {
		RobotSimulation junit = new RobotSimulation();
		String output = "";
		
		//SET 1 TEST CASE
		junit.executeCommand("MOVE");
		output = junit.executeCommand("REPORT");
		assertEquals("0,1,NORTH", output);
		
		//SET 2 TEST CASE
		junit.executeCommand("PLACE 0,0,NORTH");
		junit.executeCommand("LEFT");		
		output = junit.executeCommand("REPORT");
		assertEquals("0,0,WEST", output);
		
		//SET 3 TEST CASE
		junit.executeCommand("PLACE 1,2,EAST");
		junit.executeCommand("MOVE");
		junit.executeCommand("MOVE");
		junit.executeCommand("LEFT");
		junit.executeCommand("MOVE");
		output = junit.executeCommand("REPORT");
		assertEquals("3,3,NORTH", output);		
	}

}
