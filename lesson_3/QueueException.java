package ru.mylife.algorithmHomeWork2;

public class QueueException extends Exception {
}

class QueueFullException extends QueueException{
    String str;
    QueueFullException(){
        str="Queue full";
    }

    @Override
    public String toString() {
        return str;
    }
}

class QueueEmptyException extends QueueException{
    String str;
    QueueEmptyException(){
        str="Queue empty";
    }

    @Override
    public String toString() {
        return str;
    }
}