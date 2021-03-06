package com.example.calculatorapplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XuLy {

    /**
     *
     * @param input
     * @return trả ra một danh sách số hạng và toán hạng
     */
    public static ArrayList getItemList(String input) {
        ArrayList<String> temb = new ArrayList<>();
        /*
        Chuỗi regex để lấy số và toán hạng
         */
        //"-[0-9]{1,12}|[0-9]{1,12}|\\.|[+\\/()x$]"
        String regexFormat = "\\-?[0-9]{1,12}\\.?[0-9]{0,12}|[+\\/()x$]";
        Pattern pa = Pattern.compile(regexFormat);
        Matcher mat = pa.matcher(input);
        while (mat.find()) {
            temb.add(mat.group(0));
        }
        return temb;
    }
    public static GenQueue splitString(String input) throws Exception{
        if(!isDone(input))
            return null;
        ArrayList<String> temb = getItemList(input);
        int i = 0;
        Stack<String> stack = new Stack<>();
        GenQueue<String> queue = new GenQueue<>();
        int a = 0;
        String matString = "";
        try{
            while (a < temb.size()) {
                matString = temb.get(a);
                try {
                    Double b = Double.parseDouble(matString.trim());
                    queue.enqueue(matString);
                } catch (Exception ex) {
                    if (stack.isEmpty()) {
                        stack.push(matString);
                    } else {
                        if (matString.equals("+") || matString.equals("$")) {
                            if (stack.peek().equals("+") || stack.peek().equals("$")) {
                                    queue.enqueue(stack.pop());
                                stack.push(matString);
                            } else if (stack.peek().equals("x") || stack.peek().equals("/")) {
                                while (!stack.empty() && !stack.peek().equals("(") ) {
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
                                queue.enqueue(stack.pop());
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
        }catch (Exception ex){
            throw new Exception("Lỗi nhập liệu");
        }
        return queue;
    }
    public static double calculator(String input) throws Exception{
        GenQueue<String> queue = splitString(input);
        if(queue == null)
            throw new Exception("Lỗi nhập liệu vui lòng kiểm tra đóng mở ngoặc hoặc dấu phẩy");
        Stack<Double> kq = new Stack<>();
        double g = 0;
        while (queue.hasItems()) {
            String item = queue.dequeue();
            System.out.println("===" + item);
            try {
                double temb = Double.parseDouble(item);
                kq.push(temb);
            } catch (Exception ex) {
                try{
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
                }catch (Exception e){
                    throw new Exception("Lỗi tính toán");
                }
            }

        }

        return kq.pop();
    }

    /**
     *
     * @param input
     * @return true nếu đã đủ đồng thời đóng ngoặc và mở ngoặc false với trường hợp ngược lại
     */
    public static boolean isDone(String input) {
        // lấy danh sách toán hạng và toán tử
        ArrayList<String> temb = getItemList(input);
        int demMoNgoac = 0;
        int demDongNgoac = 0;

        for (int i = 0; i < temb.size(); i++) {
            if (temb.get(i).equals("("))
                demMoNgoac++;
            else if (temb.get(i).equals(")"))
                demDongNgoac++;
        }
        if(demDongNgoac != demMoNgoac)
            return false;
        // kiểm tra có thừa dấu phải số thực k
        for (int i = 0; i < temb.size(); i++) {
            if (temb.get(i).equals("-"))
                try{
                    Double.parseDouble(temb.get(i+1));
                }catch (Exception ex){
                    return false;
                }

        }
        return true;
    }
}

/**
 * Lớp Hàng đợi Queue
 * @param <E>
 */
class GenQueue<E> {

    public LinkedList<E> list = new LinkedList<E>();

    public void enqueue(E item) {
        list.addLast(item);
    }

    public E dequeue3() {
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

