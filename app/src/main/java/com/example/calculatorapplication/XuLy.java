package com.example.calculatorapplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XuLy {
    public static GenQueue tachChuoi(String input) {
        ArrayList<String> temb = new ArrayList<>();
        Pattern pa = Pattern.compile("-[0-9]{1,12}|[0-9]{1,12}|\\.|[+\\/()x$]");
        Matcher mat = pa.matcher(input);
        int i = 0;
        Stack<String> stack = new Stack<>();
        GenQueue<String> queue = new GenQueue<>();

        while (mat.find()) {
            temb.add(mat.group(0));
        }
        int a = 0;
        String matString = "";
        while (a < temb.size()) {
            matString = temb.get(a);
            try {
                if (matString.equals(".")) {
                    a++;
                    matString = queue.dequeue3() + "." + temb.get(a);
                }
                Double b = Double.parseDouble(matString.trim());
                queue.enqueue(matString);
            } catch (Exception ex) {
                if (stack.isEmpty()) {
                    stack.push(matString);
                } else {
                    if (matString.equals("+") || matString.equals("$")) {
                        if (stack.peek().equals("+") || stack.peek().equals("$")) {
                            while (!stack.empty()) {
                                queue.enqueue(stack.pop());
                            }
                            stack.push(matString);
                        } else if (stack.peek().equals("x") || stack.peek().equals("/")) {
                            while (!stack.empty()) {
                                queue.enqueue(stack.pop());
                            }
                            stack.push(matString);
                        } else if (stack.peek().equals("(")) {
                            stack.push(matString);
                        }
                    } else if (matString.equals("x") || matString.equals("/")) {
                        if (stack.peek().equals("+") || stack.peek().equals("$")) {
                            stack.push(matString);
                        } else if (stack.peek().equals("x") || stack.peek().equals("/")) {
                            while (!stack.empty()) {
                                queue.enqueue(stack.pop());
                            }
                            stack.push(matString);
                        } else if (stack.peek().equals("(")) {
                            stack.push(matString);
                        }
                    } else if (matString.equals("(")) {
                        stack.push(matString);

                    } else if (matString.equals(")")) {
                        while (!stack.peek().equals("(")) {
                            queue.enqueue(stack.pop());
                        }
                        stack.pop();
                    }
                }

            }

            a++;
        }
        while (!stack.empty()) {
            queue.enqueue(stack.pop());
        }
        return queue;
    }
    public static double kq(String input) {
        GenQueue<String> queue = tachChuoi(input);
        Stack<Double> kq = new Stack<>();
        double g = 0;
        while (queue.hasItems()) {
            String item = queue.dequeue();
            System.out.println("===" + item);
            try {
                double temb = Double.parseDouble(item);
                kq.push(temb);
            } catch (Exception ex) {
                if (item.equals("+")) {
                    double num2 = kq.pop();
                    double num1 = kq.pop();
                    double kq1 = num1 + num2;
                    kq.push(kq1);
                } else if (item.equals("$")) {
                    double num2 = kq.pop();
                    double num1 = kq.pop();
                    double kq1 = num1 - num2;
                    kq.push(kq1);
                } else if (item.equals("x")) {
                    double num2 = kq.pop();
                    double num1 = kq.pop();
                    double kq1 = num1 * num2;
                    kq.push(kq1);
                } else if (item.equals("/")) {
                    double num2 = kq.pop();
                    double num1 = kq.pop();
                    double kq1 = num1 / num2;
                    kq.push(kq1);
                }
            }

        }

        return kq.pop();
    }
}
class GenQueue<E> {

    public LinkedList<E> list = new LinkedList<E>();

    public void enqueue(E item) {
        list.addLast(item);
    }

    public E dequeue3(){
        return list.pollLast();
    }
    public E dequeue() {
        return list.poll();
    }

    public E dequeue2() {
        return list.peek();
    }

    public boolean hasItems() {
        return !list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void addItems(GenQueue<? extends E> q) {
        while (q.hasItems()) {
            list.addLast(q.dequeue());
        }
    }
}

