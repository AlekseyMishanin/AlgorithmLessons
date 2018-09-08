package ru.mylife.LinkList.StackList;

public class StackListApp {
    public static void main(String[] agrs){
        StackList stack = new StackList();
        for (int i = 0; i < 7; i++) {
            stack.push("Человек " + i,i);
        }
        stack.display();
        while (!stack.isEmpty()){
            System.out.println("Удалили элемент - " + stack.pop());
        }
    }
}
