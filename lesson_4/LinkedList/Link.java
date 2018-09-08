package ru.mylife.LinkList.LinkedList;

public class Link {
    private String name;
    private int age;
    public Link next;
    public Link previous;

    public Link(String name, int age){
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayLink(){
        System.out.println("{"+name+". "+age+"}");
    }
}

