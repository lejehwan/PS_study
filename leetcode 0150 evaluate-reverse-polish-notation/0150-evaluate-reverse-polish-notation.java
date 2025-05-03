class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(operate(b, a, token));
            }
        }
        return stack.pop();
    }

    private int operate(int a, int b, String operate) {
        if (operate.equals("+")) return a + b;
        if (operate.equals("-")) return a - b;
        if (operate.equals("*")) return a * b;
        if (operate.equals("/")) return a / b;
        return 0;
    }
}