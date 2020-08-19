package datastructure.array;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("show：显示");
            System.out.println("exit：退出");
            System.out.println("push：入栈");
            System.out.println("pop：出栈");
            key = scanner.next();
            if ("show".equals(key)) {
                stack.list();
            } else if ("push".equals(key)) {
                System.out.println("输入一个数");
                int value = scanner.nextInt();
                stack.push(value);
            } else if ("pop".equals(key)) {
                try {
                    int res = stack.pop();
                    System.out.printf("取出数据%d\n", res);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if ("exit".equals(key)) {
                scanner.close();
                loop = false;
            }
        }
        System.out.println("已退出");
    }
}


class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("full");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("empty");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("empty");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
