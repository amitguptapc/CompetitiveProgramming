package src.Introduction;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(2);
        stk.push(354);
        stk.push(35);
        stk.push(4);
        while (!stk.isEmpty()) {
            System.out.println(stk.pop());
        }
    }
}
