package ru.mylife.LinkList.QueueList;

public class QueueListApp {
    public static void main(String[] a){
        QueueList queue = new QueueList();
        for (int i = 0; i < 8; i++) {
            queue.insert("Гуманоид №" + i,10*i);
        }
        queue.display();
        while (!queue.isEmpty()) {
            System.out.println("Образец:" + queue.delete() + " растаял");
        }
    }
}
