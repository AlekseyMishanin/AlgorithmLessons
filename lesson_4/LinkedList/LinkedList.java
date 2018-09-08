package ru.mylife.LinkList.LinkedList;

import ru.mylife.LinkList.LinkedList.Link;

public class LinkedList {

    private Link first;
    private Link last;

    public LinkedList(){
        first=last=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst (String name, int age){
        Link newLink = new Link(name, age);
        if(isEmpty()){last=newLink;}
        else{first.previous=newLink;}
        newLink.next=first;
        first=newLink;
    }

    public void insertLast (String name, int age){
        Link newLink = new Link(name, age);
        if(isEmpty()){first=newLink;}
        else{last.next=newLink; newLink.previous=last;}
        last=newLink;
    }


    public Link deleteFirst(){
        Link temp = first;
        if(first.next==null){last=null;}
        else {first.next.previous=null;}
        first=first.next;
        return temp;
    }

    public Link deleteLast(){
        Link temp = last;
        if(first.next==null){first=null;}
        else {last.previous.next=null;}
        last=last.previous;
        return temp;
    }

    public Link deleteKey(String name){
        Link current = first;
        Link previous = null;
        while (current.getName()!=name){
            if(current.next==null){
                return null;
            } else{
                previous=current;
                current=current.next;
            }
        }
        if (current==first){
            first=current.next;
        } else{
            previous.next=current.next;
        }
        if(current.next==null){
            last=current.previous;
        } else{
            current.next.previous=current.previous;
        }
        return current;
    }

    public void display(){
        Link current = first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
    }

    public void setFirst(Link value){
        this.first=value;
    }
    public void setLast(Link value){
        this.last=value;
    }
    public Link find (String name){
        Link current = first;
        while (current.getName()!=name){
            if (current.next==null){return null;}
            else {current=current.next;}
        }
        return current;
    }

    public Link getFirst(){
        return this.first;
    }

    public Link getLast(){
        return this.last;
    }
}
