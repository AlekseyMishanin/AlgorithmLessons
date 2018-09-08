package ru.mylife.algorithmHomeWork2;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int items;

    public PriorityQueue(int size){
        this.maxSize=size;
        this.queue = new int[size];
        this.items = 0;
    }

    public void insert(int value){
        int i;
        if (items==0){
            queue[items++]=value;
        } else{
            for (i=items-1;i>=0;i--){
                if(value>queue[i]){
                    queue[i+1]=queue[i];
                } else {break;}
            }
            queue[i+1]=value;
            items++;
        }
    }

    public int remove(){
        return queue[--items];
    }
    public int peek(){
        return queue[items-1];
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
