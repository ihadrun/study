import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int a=0;
        String inputString = in.nextLine();
        Stack stack = new Stack();
        for (int i = 0; i < inputString.length(); i++) {
            stack.push(inputString.charAt(i));
        }
        if(stack.search("{")>0) {if(stack.search("}")<0) {System.out.println("false");a=-1000;}else{a=stack.search("}");}}
        if(stack.search("[")>0) {if(stack.search("]")<0) {System.out.println("false");a=-1000;}else{a=stack.search("]");}}
        if(stack.search("(")>0) {if(stack.search(")")<0) {System.out.println("false");a=-1000;}else{a=stack.search(")");}}
        
	if(a>0) {System.out.println(true);}
	}
	}

	

