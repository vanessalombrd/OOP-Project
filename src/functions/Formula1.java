package functions;

import checker.TypeChecker;
import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.util.Stack;

public class Formula1 {
    private Table table;
    private TypeChecker typeChecker;

    public Formula1(Table table) {
        this.typeChecker = new TypeChecker();
        this.table = table;
    }

    public Object startCalculations(String expression) {
        String rpn = infixToPostfix(expression);
        System.out.println("Infix: " + expression);
        System.out.println("Postfix: " + rpn);
        double result = evaluateRPN(rpn);
        System.out.println("Evaluation: " + result);
        if (Double.isInfinite(result)) return "ERROR";
        return result;
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
            if (token.matches("[-+]?\\d*\\.?\\d+")) {
                stack.push(Double.parseDouble(token));
            } else if (!token.matches("[-+]?\\d*\\.?\\d+|[-+*/^()]|\\d+\\.?\\d*")) {
                stack.push(0.0); // neshto oshte tr se pravi
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

    public void calculator() {
        for (Row tableRow : table.getRows()) {
            for (Cell<Object> tableRowCell : tableRow.getCells()) {
                String value = String.valueOf(tableRowCell.getValue());
                if (value.startsWith("=")) {
                    String[] split = value.split("\\s+");
                    StringBuilder sb = new StringBuilder();
                    for (String s : split) {
                        s = getConvertedAddress(s);
                        sb.append(s).append(" ");
                    }
                    tableRowCell.setValue(startCalculations(sb.toString()));
                }
            }
        }
    }

    private String getConvertedAddress(String s) {
        if (s.contains("R")) {
            String[] rowColumnSplit = s.split("C");
            String row2 = rowColumnSplit[0].substring(1); // posle da prenapisha
            if (Integer.parseInt(row2) >= table.getRows().size()) {
                return "0"; // po uslovie
            }
            String column = rowColumnSplit[1];
            if (Integer.parseInt(column) >= table.getRows().get(Integer.parseInt(row2)).getCells().size()) {
                return "0"; // po uslovie
            }
            Object value2 = table.getRows().get(Integer.parseInt(row2)).getCells().get(Integer.parseInt(column)).getValue(); // namira stoinostta po R i C

            s = String.valueOf(value2);
//            if (!typeChecker.checkInteger(s) || !typeChecker.checkDouble(s)) {
//                return "0"; // po uslovie
//
//            }
        }
        return s;
    }

}