package modifiedstacks;

import java.util.Scanner;
import java.util.Stack;


/*
Description: This program checks whether a sequence of delimiters is valid using a stack. It checks matching pairs of parentheses, square brackets, and curly braces and displays the stack execution trace.

Programmed by: [Holly Kent Jagunos] [BSIT] [CN: 48079] [DATA STRUCTURES AND ALGORITHM]

Last Modified: October 22, 2026

Version: 1.0

Acknowledgements: Java documentation and ChatGPT were used as references for understanding Java Stack operations and implementing the delimiter checker. Prompt: "Explain how to implement a stack-based delimiter checker in Java and display its stack execution trace."
*/
public class ModifiedStacks{

public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Stack<Character> stack = new Stack<Character>();
        
        
        
    System.out.print("Enter a delimiter sequence: ");
        String sequence = input.nextLine();

        boolean valid = true;
        String reason = "";

        for (int i = 0; i < sequence.length(); i++) {
            char ch = sequence.charAt(i);
            System.out.println("Read: " + ch);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
                System.out.println("Operation: PUSH " + ch);
                System.out.println("Stack: " + stack);
                System.out.println("=================================");
            }
            
           
            else if (ch == ')' || ch == ']' || ch == '}') {

                if (stack.isEmpty()) {
                    valid = false;
                    reason = "Closing delimiter has no matching opening delimiter.";
                    break;
                }

                char top = stack.peek();
                System.out.println("Operation: PEEK -> " + top);
                System.out.println("================================="); 
                
                if ((ch == ')' && top == '(') ||
                    (ch == ']' && top == '[') ||
                    (ch == '}' && top == '{')) {

                    stack.pop();
                    System.out.println("Operation: POP");
                    System.out.println("Stack: " + stack);
                    System.out.println("=================================");
                    
                } else {
                    valid = false;
                    reason = "Mismatched delimiters.";
                    break;
                }
            }
        }

        
        if (valid && !stack.isEmpty()) {
            valid = false;
            reason = "Unmatched opening delimiter remains.";
        }

        if (valid) {
            System.out.println(sequence + " is Valid");
        } else {
            System.out.println("Invalid");
            System.out.println("Reason: " + reason);
        }

        input.close();
    }
}