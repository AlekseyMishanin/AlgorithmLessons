package ru.lessons6;

public class Node {

    private Item item;
    public Node leftChild;
    public Node rightChild;

    Node(int data){
        item = new Item(data);
    }

    Node(Item data){
        item = data;
    }

    public void display(){
        System.out.print(item.getData());
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
