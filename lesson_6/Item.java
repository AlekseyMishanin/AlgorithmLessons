package ru.lessons6;

public class Item {

    private int data;

    Item(int data){
        this.data=data;
    }

    public void display(){
        System.out.print(data + " ");
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
