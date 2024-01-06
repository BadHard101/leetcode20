package org.example;

import java.util.Stack;

public class Main {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{': {
                    stack.push(ch);
                    break;
                }

                case ')': {
                    if (!stack.isEmpty() && stack.peek().equals('(')) stack.pop();
                    else return false;
                    break;
                }
                case ']': {
                    if (!stack.isEmpty() && stack.peek().equals('[')) stack.pop();
                    else return false;
                    break;
                }
                case '}': {
                    if (!stack.isEmpty() && stack.peek().equals('{')) stack.pop();
                    else return false;
                    break;
                }
                default: return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("]"));
    }
}