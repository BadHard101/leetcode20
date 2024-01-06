package org.example;

import java.util.Stack;

public class Main1 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;

                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || !isValidPair(stack.pop(), ch)) {
                        return false;
                    }
                    break;

                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean isValidPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("]"));
    }
}