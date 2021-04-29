package test;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RobotSimulation {
	private static String [] dir={"NORTH", "EAST", "SOUTH", "WEST"};
	private static int xCoordinate = 0;
	private static int yCoordinate = 0;
	private static String direction = "NORTH";
//	public static boolean executePlaceCommand(String command){
//		if(command.matches("(PLACE [0-4],[0-4],(NORTH|SOUTH|WEST|EAST))")){
//		StringTokenizer tok = new StringTokenizer(command, " ");
//		tok.nextToken();
//		StringTokenizer tok2 = new StringTokenizer(tok.nextToken(),",");
//		xCoordinate = Integer.parseInt(tok2.nextToken());
//		yCoordinate = Integer.parseInt(tok2.nextToken());
//		direction = tok2.nextToken();
//		List<String> dirList = new ArrayList<>(Arrays.asList(dir));
//		if(!(dirList.contains(direction))){
//			System.out.println("Invalid direction!\n");
//			System.exit(0);
//			return false;
//		}
//		return true;
//		}else{
//			System.out.println("Invalid command!\n");
//			System.exit(0);
//			return false;
//		}
//	}
	public static String executeCommand(String command){
		switch (command) {
		case "MOVE":
			if(direction.contentEquals("NORTH")){
				yCoordinate = yCoordinate + 1;
			}else if(direction.contentEquals("SOUTH")){
				yCoordinate = yCoordinate - 1;
			}else if(direction.contentEquals("WEST")){
				xCoordinate = xCoordinate - 1;
			}else if(direction.contentEquals("EAST")){
				xCoordinate = xCoordinate + 1;
			}
			break;
		case "LEFT":
				for (int i = 0; i < dir.length; i++) {
					if(dir[i].contentEquals(direction)){
						if(i==0){
							direction=dir[dir.length-1];
							break;
						}else {
							direction=dir[i-1];
							break;
						}
					}
				}
			break;
		case "RIGHT":
			for (int i = 0; i < dir.length; i++) {
				if(dir[i].contentEquals(direction)){
					if(i==dir.length-1){
						direction=dir[0];
						break;
					}else{
						direction=dir[i+1];
						break;
					}
				}
			}	
			break;
		default:
			if(command.matches("(PLACE [0-4],[0-4],(NORTH|SOUTH|WEST|EAST))")){
				StringTokenizer tok = new StringTokenizer(command, " ");
				tok.nextToken();
				StringTokenizer tok2 = new StringTokenizer(tok.nextToken(),",");
				xCoordinate = Integer.parseInt(tok2.nextToken());
				yCoordinate = Integer.parseInt(tok2.nextToken());
				direction = tok2.nextToken();
				List<String> dirList = new ArrayList<>(Arrays.asList(dir));
				if(!(dirList.contains(direction))){
					System.out.println("Invalid direction!\n");
				}
				}else if(command.contentEquals("REPORT")){
					
				}else{
					System.out.println("Invalid command!\n");
				}
			break;
		}
		return xCoordinate+","+yCoordinate+","+direction;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String command = "";
		String output = "";
		do{
		command = input.nextLine();
		output = executeCommand(command);
		}while(!command.contentEquals("REPORT"));
		if(xCoordinate<0 || yCoordinate<0 || xCoordinate>4 || yCoordinate>4){
			System.out.println("Robot fell off the table");
		}else
		System.out.println(output);
	}
}
