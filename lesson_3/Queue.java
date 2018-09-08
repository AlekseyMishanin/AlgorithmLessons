package ru.mylife.algorithmHomeWork2;

public class Queue {

    private int maxSize;
    private int[] queue;
    private int front;
    private int rear;
    private int items;

    public Queue(int size){
        this.maxSize=size;
        this.queue = new int[size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    public void insert(int value){
        if (rear==maxSize-1){
            rear=-1;
        }
        queue[++rear]=value;
        items++;
    }

    public int remove(){
        int temp = queue[front++];
        if(front==maxSize){front=0;}
        items--;
        return temp;
    }
    public int peek(){
        return queue[front];
    }
    public boolean isEmpty(){
        return items==0;
    }

    public boolean isFull(){
        return items==maxSize;
    }

    public int size(){
        return items;
    }
}
