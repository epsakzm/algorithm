package etc;

import java.util.Scanner;
import java.util.Stack;

public class StackEx {
    /*
     * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
     * 
     * 명령은 총 다섯 가지이다.
     * 
     * push X: 정수 X를 스택에 넣는 연산이다.
     * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     * size: 스택에 들어있는 정수의 개수를 출력한다.
     * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
     * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
     */

    private static void solve() {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        for (int i = 0; i < n; ++i) {
            String command = sc.next();
            // push 연산
            if (command.equals("push")) {
                int number = sc.nextInt();
                stack.push(number);
                // pop 연산
            } else if (command.equals("pop")) {
                if (stack.isEmpty())
                    sb.append("-1");
                else {
                    int pop = stack.pop();
                    System.out.println(pop);
                }
            } else if (command.equals("size")) {
                int size = stack.size();
                System.out.println(size);
            } else if (command.equals("empty"))
                if (stack.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            else if (command.equals("top"))
                if (stack.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(stack.peek());
        }
        sc.close();
    }

    public static void main(String[] args) {
        solve();
    }

}