package ru.lessons7;

public class QueueX {
    private final int MAX_QUEUE_SIZE = 20;
    private int[] queue;
    private int front, rear;

    public QueueX(){
        queue = new int[MAX_QUEUE_SIZE];
        front=0;
        rear=-1;
    }

    public void insert(int value){
        if (rear==MAX_QUEUE_SIZE-1){
            rear=0;
        }
        queue[++rear]=value;
    }

    public int remove(){
        int temp = queue[front++];
        if (front==MAX_QUEUE_SIZE){
            front=0;
        }
        return temp;
    }

    public boolean isEmpty(){
        return ((rear+1)==front)||((front+MAX_QUEUE_SIZE-1)==rear);
    }
}
