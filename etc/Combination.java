package etc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Combination {

    static Stack<Integer> answer = new Stack<>();

    private static void printList() {
        answer.forEach(System.out::print);
    }

    private static void dfs(int depth, int before, int length) {
        if (depth == length) {
            printList();
            System.out.println();
            return;
        }

        for (int i = before + 1; i <= 9; ++i) {
            answer.add(i);
            dfs(depth + 1, i, length);
            answer.pop();
        }
    }

    public static void main(String[] args) {
        dfs(0, -1, 5);
    }

}
