package ru.lessons8;

public class HashTable {
    private LinkList[] hashList;
    private int sizeArray;

    HashTable(int size){
        hashList = new LinkList[size];
        sizeArray=size;
        for (int i = 0; i < size; i++) {
            hashList[i] = new LinkList();
        }
    }

    public void display(){

        System.out.println("HashTable:");
        for (int i = 0; i < sizeArray; i++) {
            System.out.print(i + " ");
            hashList[i].display();
        }
    }

    private int hashFunc(int key){
        return key%sizeArray;
    }

    public void insert(int value){
        int hashVal = hashFunc(value);
        hashList[hashVal].insert(value);
    }

    public boolean delete (int value){
        int hashVal = hashFunc(value);
        return hashList[hashVal].delete(value);
    }

    public Link find(int value){
        int hashVal = hashFunc(value);
        return hashList[hashVal].find(value);
    }
}
