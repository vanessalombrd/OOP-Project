package functions;

import checker.TypeChecker;
import components.cell.Cell;
import components.row.Row;
import components.table.Table;

import java.util.Stack;

/**
 * The {@code Formula1} class provides functionality to evaluate mathematical expressions in a {@link Table}.
 * It supports conversion of infix expressions to postfix (RPN) and evaluates the postfix expressions.
 * <p>
 * This class also updates cell values in the table based on formulas that start with '='.
 * </p>
 *
 * <pre>
 * {@code
 * Table table = new Table(new TypeChecker());
 * // Populate table with rows and cells
 * Formula1 formula1 = new Formula1(table);
 * formula1.calculator();
 * }
 * </pre>
 *
 * @version 1.0
 * @since 2024-06-24
 */
public class Formula1 {
    private final Table table;
    private final TypeChecker typeChecker0;

    /**
     * Constructs a {@code Formula1} with the specified {@link Table}.
     *
     * @param table the table to be used for formula evaluations
     */
    public Formula1(Table table) {
        this.typeChecker0 = new TypeChecker();
        this.table = table;
    }

    /**
     * Starts the calculations for the given expression.
     * Converts the infix expression to postfix (RPN) and evaluates it.
     *
     * @param expression the infix expression to be evaluated
     * @return the result of the evaluation, or "ERROR" if the result is infinite
     */
    public Object startCalculations(String expression) {
        String rpn = infixToPostfix(expression);
        double result = evaluateRPN(rpn);
        if (Double.isInfinite(result)) return "ERROR";
        return result;
    }

    /**
     * Converts an infix expression to postfix (RPN) using the shunting-yard algorithm.
     *
     * @param expression the infix expression to be converted
     * @return the postfix expression
     */
    public String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        String operators = "+-*/^";
        int[] precedence = {1, 1, 2, 2, 3};  // operator precedence

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
                    stack.pop();
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            }
        }
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(' || top == ')') {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.append(top).append(' ');
        }
        return output.toString().trim();
    }

    /**
     * Evaluates a postfix (RPN) expression.
     *
     * @param rpn the postfix expression to be evaluated
     * @return the result of the evaluation
     */
    public double evaluateRPN(String rpn) {
        Stack<Double> stack = new Stack<>();
        for (String token : rpn.split("\\s")) {
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

    /**
     * Evaluates all formulas in the table and updates the corresponding cell values.
     * Formulas are identified by the '=' prefix.
     */
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

    /**
     * Converts cell references in the formula to their actual values.
     *
     * @param s the cell reference to be converted
     * @return the actual value of the cell reference
     */
    private String getConvertedAddress(String s) {
        if (s.contains("R")) {
            String[] rowColumnSplit = s.split("C");
            String row = rowColumnSplit[0].substring(1);
            if (Integer.parseInt(row) >= table.getRows().size()) {
                return "0"; // po uslovie
            }
            String column = rowColumnSplit[1];
            if (Integer.parseInt(column) >= table.getRows().get(Integer.parseInt(row)).getCells().size()) {
                return "0"; // po uslovie
            }
            Object value2 = table.getRows().get(Integer.parseInt(row)).getCells().get(Integer.parseInt(column)).getValue();

            s = String.valueOf(value2);
        }
        return s;
    }
}
