
/**
 * 	Time Complexity: O(n)
	Space Complexity: O(n)
https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
import java.util.Stack;

public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int x = 0;
		int y = 0;
		for (String s : tokens) {
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				if (!stack.isEmpty()) {
					x = stack.pop();
					if (!stack.isEmpty())
						y = stack.pop();
					if (s.equals("+"))
						stack.push(x + y);
					else if (s.equals("-"))
						stack.push(y - x);
					else if (s.equals("*"))
						stack.push(x * y);
					else if (s.equals("/"))
						stack.push(y / x);
				}
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {

	}

}
