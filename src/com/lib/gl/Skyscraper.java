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
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input total number of floors in the building.");
		int floorCnt = sc.nextInt();
		
		List<Integer> floorSizes = new ArrayList<Integer>();
		System.out.println("Input sizes of floors in the order of days of construction.");
		for(int i =1; i<= floorCnt; i++) {
			System.out.println(String.format("Floor size ready on day %d: ", i));
			floorSizes.add(sc.nextInt());
		}
		for(int j =0; j< floorCnt; j++) {
			System.out.println(floorSizes.get(j));
		}
		return floorSizes;
	}
	
	public void assembleBuilding(List<Integer> floorSizes) {
		int totalFloors = floorSizes.size();
		int maxSize = totalFloors;
		int sizeToAssemble = maxSize;
		Stack<Integer> readyFloors = new Stack<Integer>();
		for(int day = 1; day <= totalFloors; day++) {
			int readySize = floorSizes.remove(0);
			readyFloors.push(readySize);
//			System.out.println(readyFloors);
			readyFloors = sortstack(readyFloors);
//			System.out.println(readyFloors);
			String floorsAssembled = "";
			//get floors that can be assembled
			System.out.println(readyFloors);
			System.out.println(readyFloors.peek());
			while(!readyFloors.isEmpty() && sizeToAssemble == readyFloors.peek().intValue()) {
				floorsAssembled = floorsAssembled + readyFloors.pop();
				sizeToAssemble--;
			}
			System.out.println(String.format("Day %d: \n %s", day, floorsAssembled));
		}
		
		
	}
	
	public static Stack<Integer> sortstack(Stack<Integer> input){
		Stack<Integer> tmpStack = new Stack<Integer>();
		while(!input.isEmpty()){
			int tmp = input.pop();
			while(!tmpStack.isEmpty() && tmpStack.peek() < tmp){
				input.push(tmpStack.pop());
			}
			tmpStack.push(tmp);
		}
		return tmpStack;
	}
	
}
