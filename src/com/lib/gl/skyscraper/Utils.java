package com.lib.gl.skyscraper;

import java.util.Stack;

public class Utils {

	public Stack<Integer> sortstack(Stack<Integer> input){
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
