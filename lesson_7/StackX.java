package ru.lessons7;

public class StackX {
    private final int MAX_STACK_SIZE = 20;
    private int[] stack;
    private int top;

    StackX(){
        stack = new int[MAX_STACK_SIZE];
        top=-1;
    }

    public int peek(){
        return stack[top];
    }

    public void push(int value){
        stack[++top]=value;
    }

    public int pop(){
        return stack[top--];
    }

    public boolean isEmpty(){
        return top==-1;
    }
}
