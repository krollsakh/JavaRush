package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.*;

/*
Рекурсия для мат. выражения
*/
public class Solution_old {
    public Solution_old() {
        //don't delete
    }

    public static void main(String[] args) {
        Solution_old solution = new Solution_old();
        solution.recurse("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6

        // тесты для проверки
        String s;
        s = "sin(2*(-5+1.5*4)+28)";
        System.out.print(s + " expected output 0.5 6 actually ");
        solution.recurse(s, 0);
        s = "tan(45)";
        System.out.print(s + " expected output 1 1 actually ");
        solution.recurse(s, 0);
        s = "tan(-45)";
        System.out.print(s + " expected output -1 2 actually ");
        solution.recurse(s, 0);
//        s = "0.305";
//        System.out.print(s + " expected output 0.3 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.3051";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);
//        s = "(0.3051)";
//        System.out.print(s + " expected output 0.31 0 actually ");
//        solution.recurse(s, 0);
//        s = "1+(1+(1+1)*(1+1))*(1+1)+1";
//        System.out.print(s + " expected output 12 8 actually ");
//        solution.recurse(s, 0);
//        s = "tan(44+sin(89-cos(180)^2))";
//        System.out.print(s + " expected output 1 6 actually ");
//        solution.recurse(s, 0);
//        s = "-2+(-2+(-2)-2*(2+2))";
//        System.out.print(s + " expected output -14 8 actually ");
//        solution.recurse(s, 0);
//        s = "sin(80+(2+(1+1))*(1+1)+2)";
//        System.out.print(s + " expected output 1 7 actually ");
//        solution.recurse(s, 0);
//        s = "1+4/2/2+2^2+2*2-2^(2-1+1)";
//        System.out.print(s + " expected output 6 11 actually ");
//        solution.recurse(s, 0);
//        s = "10-2^(2-1+1)";
//        System.out.print(s + " expected output 6 4 actually ");
//        solution.recurse(s, 0);
//        s = "2^10+2^(5+5)";
//        System.out.print(s + " expected output 2048 4 actually ");
//        solution.recurse(s, 0);
//        s = "1.01+(2.02-1+1/0.5*1.02)/0.1+0.25+41.1";
//        System.out.print(s + " expected output 72.96 8 actually ");
//        solution.recurse(s, 0);
//        s = "0.000025+0.000012";
//        System.out.print(s + " expected output 0 1 actually ");
//        solution.recurse(s, 0);
//        s = "-2-(-2-1-(-2)-(-2)-(-2-2-(-2)-2)-2-2)";
//        System.out.print(s + " expected output -3 16 actually ");
//        solution.recurse(s, 0);
//        s = "cos(3 + 19*3)";
//        System.out.print(s + " expected output 0.5 3 actually ");
//        solution.recurse(s, 0);
//        s = "2*(589+((2454*0.1548/0.01*(-2+9^2))+((25*123.12+45877*25)+25))-547)";
//        System.out.print(s + " expected output 8302231.36 14 actually ");
//        solution.recurse(s, 0);
//        s = "(-1 + (-2))";
//        System.out.print(s + " expected output -3 3 actually ");
//        solution.recurse(s, 0);
//        s = "-sin(2*(-5+1.5*4)+28)";
//        System.out.print(s + " expected output -0.5 7 actually ");
//        solution.recurse(s, 0);
//        s = "sin(100)-sin(100)";
//        System.out.print(s + " expected output 0 3 actually ");
//        solution.recurse(s, 0);
//
//        s = "-(-22+22*2)";
//        System.out.print(s + " expected output -22 4 actually ");
//        solution.recurse(s, 0);
//        s = "-2^(-2)";
//        System.out.print(s + " expected output -0.25 3 actually ");
//        solution.recurse(s, 0);
//        s = "-(-2^(-2))+2+(-(-2^(-2)))";
//        System.out.print(s + " expected output 2.5 10 actually ");
//        solution.recurse(s, 0);
//        s = "(-2)*(-2)";
//        System.out.print(s + " expected output 4 3 actually ");
//        solution.recurse(s, 0);
//        s = "(-2)/(-2)";
//        System.out.print(s + " expected output 1 3 actually ");
//        solution.recurse(s, 0);
//        s = "sin(-30)";
//        System.out.print(s + " expected output -0.5 2 actually ");
//        solution.recurse(s, 0);
//        s = "cos(-30)";
//        System.out.print(s + " expected output 0.87 2 actually ");
//        solution.recurse(s, 0);
//        s = "tan(-30)";
//        System.out.print(s + " expected output -0.58 2 actually ");
//        solution.recurse(s, 0);
//        s = "2+8*(9/4-1.5)^(1+1)";
//        System.out.print(s + " expected output 6.5 6 actually ");
//        solution.recurse(s, 0);
//        s = "0.005 ";
//        System.out.print(s + " expected output 0.01 0 actually ");
//        solution.recurse(s, 0);
//        s = "0.0049 ";
//        System.out.print(s + " expected output 0 0 actually ");
//        solution.recurse(s, 0);
//        s = "0+0.304";
//        System.out.print(s + " expected output 0.3 1 actually ");
//        solution.recurse(s, 0);
//
//        s = "-0";
//        System.out.print(s + " expected output 0 1 actually ");
//        solution.recurse(s, 0);
//
//        s = "-2^(-2)";
//        System.out.print(s + " expected output -0.25 3 actually ");
    }

    private static String operators() {
        return "+-*/^";
    }

    private static String delimiters() {
        return "()" + operators();
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators().length(); i++) {
            if (token.charAt(0) == operators().charAt(i)) return true;
        }
        return false;
    }

    private static boolean isDelimiter(String token) {
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters().length(); i++) {
            if (token.charAt(0) == delimiters().charAt(i)) return true;
        }
        return false;
    }

    private static boolean isFunction(String token) {
        return token.equals("sin") || token.equals("cos") || token.equals("tan");
    }

    private static int priority(String token) {
        switch (token) {
            case "(":
                return 0;
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "^":
                return 3;
        }
        return 4;
    }

    public void recurse(final String expression, int countOperation) {
        //implement

        Locale.setDefault(Locale.ENGLISH);

        if (countOperation > 0) {
            System.out.println(expression + " " + countOperation);
        } else {
            List<String> out = new ArrayList<>();
            Deque<String> stackPostfix = new ArrayDeque<>();
            Deque<Double> stack = new ArrayDeque<>();

            StringTokenizer tokenizer = new StringTokenizer(expression.replace(" ", "").toLowerCase(), delimiters(), true);
            String prev = "";
            String curr = "";

            while (tokenizer.hasMoreTokens()) {
                curr = tokenizer.nextToken();

                if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                    System.out.println("Некорректное выражение.");
                    break;
                }

                if (isFunction(curr)) {
                    stackPostfix.push(curr);
                } else if (isDelimiter(curr)) {
                    if (curr.equals("(")) stackPostfix.push(curr);
                    else if (curr.equals(")")) {
                        while (!stackPostfix.peek().equals("(")) {
                            out.add(stackPostfix.pop());
                            if (stackPostfix.isEmpty()) {
                                System.out.println("Скобки не согласованы.");
                            }
                        }
                        stackPostfix.pop();
                        if (!stackPostfix.isEmpty() && isFunction(stackPostfix.peek())) {
                            out.add(stackPostfix.pop());
                        }
                    } else {
                        if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev) && !prev.equals(")")))) {
                            curr = "u-";
                        } else {
                            while (!stackPostfix.isEmpty() && (priority(curr) <= priority(stackPostfix.peek()))) {
                                out.add(stackPostfix.pop());
                            }
                        }
                        stackPostfix.push(curr);
                    }
                } else {
                    out.add(curr);
                }
                prev = curr;
            }

            while (!stackPostfix.isEmpty()) {
                if (isOperator(stackPostfix.peek())) {
                    out.add(stackPostfix.pop());
                } else {
                    System.out.println("Скобки не согласованы.");
                    break;
                }
            }
            for (String x : out) {
                switch (x) {
                    case "sin":
                        stack.push(Math.sin(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "cos":
                        stack.push(Math.cos(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "tan":
                        stack.push(Math.tan(Math.toRadians(stack.pop())));
                        countOperation++;
                        break;
                    case "^": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(Math.pow(a, b));
                        countOperation++;
                        break;
                    }
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        countOperation++;
                        break;
                    case "-": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a - b);
                        countOperation++;
                        break;
                    }
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        countOperation++;
                        break;
                    case "/": {
                        Double b = stack.pop(), a = stack.pop();
                        stack.push(a / b);
                        countOperation++;
                        break;
                    }
                    case "u-":
                        stack.push(-stack.pop());
                        countOperation++;
                        break;
                    default:
                        stack.push(Double.valueOf(x));
                        break;
                }
            }

            recurse(new DecimalFormat("#.##").format(stack.pop()), countOperation);
        }
    }
}