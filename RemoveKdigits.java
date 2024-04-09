/**
 * Time Complexity: O(n)
Space Complexity: O(n)
https://leetcode.com/problems/remove-k-digits/
 */
import java.util.Stack;

public class RemoveKdigits {
	public String removeKdigits(String num, int k) {
		if (k == num.length())
			return "0"; 			// edge case for num=9 and k=1
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (char ch : num.toCharArray()) { //O(n)
			while (!stack.isEmpty() && k > 0 && stack.peek() > ch - '0') { // compare stack.peek with an integer
				stack.pop();
				k--;
			}
			stack.push(ch - '0');
		}
		while (k > 0) { 			// at last when k!=0 remove last k elements eg:112 k=1, remove 2 here. Stack will have 1 1 2 inside
			stack.pop();
			k--;
		}
		while (!stack.isEmpty()) { 
			sb = sb.insert(0, stack.pop()); //O(n)// insert method is used to insert at specific index
		}
		String output = sb.toString().replaceFirst("^0+", "");
		return output.length() == 0 ? "0" : output; // edge case for num=10 and k=2
	}

	public static void main(String[] args) {
		RemoveKdigits r = new RemoveKdigits();
		System.out.println(r.removeKdigits("1432219", 3));

	}

}
