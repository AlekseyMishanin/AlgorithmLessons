package ru.mylife.algorithmHomeWork2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {

    private int maxSize;
    private int[] stak;
    private int top;

    public Stack(int size){
        this.maxSize=size;
        this.top=-1;
        this.stak = new int[size];
    }

    public void push (int value){
        this.stak[++top]=value;
    }

    public int pop(){
        return this.stak[top--];
    }

    public int peek(){
        return this.stak[top];
    }

    public boolean isEmpty(){
        return this.top==-1;
    }

    public boolean isFull(){
        return this.top==maxSize-1;
    }
}

class Bracket{

    private String input;
    public Bracket(String in){
        input=in;
    }

    public void chack(){
        int size = input.length();
        Stack st = new Stack(size);
        for (int i=0; i<size;i++){
            char ch = input.charAt(i);
            switch (ch){
                case '{':
                case '[':
                case '(':
                    st.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!st.isEmpty()){
                        char chr = (char)st.pop();
                        if((ch=='}'&&chr!='{')||
                                (ch==']'&&chr!='[')||
                                (ch==')'&&chr!='(')){
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                    default:
                        break;
            }
        }
        if (!st.isEmpty()){
            System.out.println("Error: missing right delimeter");
        }
    }
    public static String getString(){
        try{
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            return buf.readLine();
        }catch (IOException exc){
            System.out.println("Error input");
            return null;
        }
    }
}