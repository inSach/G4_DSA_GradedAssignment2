package com.lib.gl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * a) Every day a floor is constructed in a separate factory of distinct size.
b) The floor with the larger size must be placed at the bottom of the building.
c) The floor with the smaller size must be placed at the top of the building.
 */
public class Skyscraper {

	public static void main(String[] args) {
		Skyscraper obj = new Skyscraper();
		List floorSizes = obj.getDesignDetails();
		obj.assembleBuilding(floorSizes);
	}
	
	public List<Integer> getDesignDetails() {
		// Initialize scanner object to read user input.
		Scanner sc = new Scanner(System.in);
		// Accept total number of floors.
		System.out.println("Input total number of floors in the building.");
		int floorCnt = sc.nextInt();
		//Accept sizes of floors produced in factory in the same order of production days.
		List<Integer> floorSizes = new ArrayList<Integer>();
		System.out.println("Input sizes of floors in the order of days of construction.");
		for(int i =1; i<= floorCnt; i++) {
			System.out.println(String.format("Floor size ready on day %d: ", i));
			floorSizes.add(sc.nextInt());
		}
		return floorSizes;
	}
	
	public void assembleBuilding(List<Integer> floorSizes) {
		int totalFloors = floorSizes.size();
		int maxSize = totalFloors;
		int sizeToAssemble = maxSize;
		//Create stack to hold the slabs which are ready to assemble
		Stack<Integer> readyFloors = new Stack<Integer>();
		System.out.println("The order of construction is as follows");
		//Iterate for day by day construction progress. Order ready slabs in stack.
		for(int day = 1; day <= totalFloors; day++) {
			int readySize = floorSizes.remove(0).intValue();
			readyFloors.push(readySize);
			readyFloors = sortstack(readyFloors);
			//get floors that can be assembled
			String floorsAssembled = "";
			while(!readyFloors.isEmpty() && sizeToAssemble == readyFloors.peek().intValue()) {
				floorsAssembled = floorsAssembled + " " + readyFloors.pop();
				sizeToAssemble--;
			}
			System.out.println(String.format("Day %d: \n %s", day, floorsAssembled));
		}
	}
	
	public static Stack<Integer> sortstack(Stack<Integer> input){
		//Create a new empty stack
		Stack<Integer> tmpStack = new Stack<Integer>();
		while(!input.isEmpty()){
			// get top value from the stack to be sorted
			int tmp = input.pop();
			//pop values from temporary stack till the temp value is less.
			while(!tmpStack.isEmpty() && tmpStack.peek() > tmp){
				input.push(tmpStack.pop());
			}
			//push value from temp to new stack.
			tmpStack.push(tmp);
		}
		return tmpStack;
	}
}
