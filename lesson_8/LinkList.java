package ru.lessons8;

public class LinkList {

    private Link first;

    LinkList(){
        this.first=null;
    }

    public void insert(int value){
        Link newLink = new Link(value);
        Link previous = null;
        Link current = first;

        while (current!=null&&current.getKey()<value){
            previous=current;
            current=current.next;
        }
        if (previous==null){
            first=newLink;
        } else {
            previous.next=newLink;
        }
        newLink.next=current;
    }

    public boolean delete (int value){
        Link previous = null;
        Link current = first;

        while (current!=null&&current.getKey()<=value){
            if(current.getKey()==value){
                if(previous==null){
                    first=first.next;
                    return true;
                }else {
                    Link temp = current;
                    previous.next=current.next;
                    return true;
                }
            }
            previous=current;
            current=current.next;
        }
        return false;
    }

    public Link find(int value){
        Link current = first;
        while (current!=null&&current.getKey()<=value){
            if(current.getKey()==value){
                return current;
            }
            current=current.next;
        }
        return null;
    }

    public void display(){
        System.out.print("List(first -> last): ");
        Link link = first;
        while (link!=null){
            link.display();
            link=link.next;
        }
        System.out.println();
    }
}
