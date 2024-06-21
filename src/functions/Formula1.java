package functions;

import components.table.Table;

import java.util.Stack;

public class Formula1 {
    private Table table;

    public Formula1(Table table) {
        this.table = table;
    }

    public Object startCalculations(String expression) {
        String rpn = infixToPostfix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + rpn);
        System.out.println("Evaluation: " + evaluateRPN(rpn));
        return evaluateRPN(rpn);
    }

    // Method to convert infix expression to postfix expression (RPN)
    public String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        String operators = "+-*/^";
        int[] precedence = {1, 1, 2, 2, 3};  // Precedence for +, -, *, /, ^

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    output.append(expression.charAt(i));
                    i++;
                }
                output.append(' ');
                i--;
            } else if (operators.indexOf(ch) != -1) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                        precedence[operators.indexOf(stack.peek())] >= precedence[operators.indexOf(ch)]) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();  // Remove the '(' from the stack
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses in expression");
                }
            }
        }
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(' || top == ')') {
                throw new IllegalArgumentException("Mismatched parentheses in expression");
            }
            output.append(top).append(' ');
        }
        return output.toString().trim();
    }

    // Method to evaluate a postfix expression (RPN)
    public double evaluateRPN(String rpn) {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn.split("\\s")) {
            if (token.contains("R")) {
                String[] rowColumnSplit = token.split("C");
                String row = rowColumnSplit[0].substring(1);
                String column = rowColumnSplit[1];
                Object value = table.getRows().get(Integer.parseInt(row)).getCells().get(Integer.parseInt(column)).getValue(); // namira stoinostta po R i C
                token = (String) value;
            }
            if (token.matches("[-+]?\\d*\\.?\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                    case "^":
                        stack.push(Math.pow(a, b));
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + token);
                }
            }
        }
        return stack.pop();
    }

}