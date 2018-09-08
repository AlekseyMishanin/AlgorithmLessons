package ru.mylife.LinkList.LinkList;

public class LinkList {
    private Link first;

    public LinkList(){
        this.first=null;
    }

    public boolean isEmpty(){
        return first==null;
    }

    public void insertFirst(String name, int age){
        Link aLink = new Link(name,age);
        aLink.next=first;
        first=aLink;
    }

    public Link deleteFirst(){
        Link temp = first;
        first= first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first --> last): ");
        Link current = first;
        while (current!=null){
            current.displayLink();
            current=current.next;
        }
        System.out.println();
    }

    public Link find (int key){
        Link link = first;
        while (!link.getName().equals(key)){
            if(link.next==null){
                return null;
            } else {
                link=link.next;
            }
        }
        return link;
    }

    public Link delete(int key){
        Link current = first;
        Link previous = first;
        while (!current.getName().equals(key)){
            if (current.next==null){
                return null;
            } else{
                previous = current;
                current=current.next;
            }
        }
        if (current==first){
            first=first.next;
        } else{
            previous.next=current.next;
        }
        return current;
    }
}
