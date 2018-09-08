package ru.mylife.LinkList.LinkedIterator;

import ru.mylife.LinkList.LinkedList.Link;
import ru.mylife.LinkList.LinkedList.LinkedList;

public class LinkedIterator {
    private Link current;       //ссылка на элемент двусвязного списка
    private LinkedList list;    //ссылка на список элементов

    public LinkedIterator(LinkedList list){
        this.list=list;
        reset();
    }

    public void reset(){
        current=list.getFirst();
    }

    public void nextLink(){
        current=current.next;
    }

    public Link getCurrent(){
        return current;
    }
    public boolean atEnd(){
        return current==null;
    }

    //при добавлении элемента итератор ссылается на старый элемент (исключительнаяа ситуация - пустой список)
    public void insertAfter(String name, int age){
        Link newLink = new Link(name,age);  //создаем новый элемент списка
        if(list.isEmpty()){                 //если список пуст
            list.insertFirst(name,age);     //вызываем метод списка для вставки первого элемента
            reset();               //присваиваем итератору ссылку на первый элемент
        } else{
            if(current.next==null){         //если следующий элемент null
                                            //ничего не делаем
            } else {                            //в противном случае
                current.next.previous=newLink;  //в следующем элементе меняем связь с предыдущим элементом
            }
            newLink.next=current.next;          //строим для нового элемента связь со следующим элементом
            newLink.previous=current;           //строим для нового элемента связь с предыдущим элементом
            current.next=newLink;               //для элемента на который ссылается итератор указываем в качестве следующего элемента - newLink
        }
    }

    //при добавлении элемента итератор ссылается на старый элемент (исключительнаяа ситуация - пустой список)
    public void insertBefore(String name, int age){
        Link newLink = new Link(name,age);      //создаем новый элемент списка
        if(list.isEmpty()){                     //если список пуст
            list.insertFirst(name,age);         //вызываем метод списка для вставки первого элемента
            reset();                            //меняем ссылку итератора с null на ссылку на первый элемент
        } else{
            if(current.previous==null){         //если предшествующий элемент отсутствует
                list.setFirst(newLink);         //обновляем первый элемент
            } else {
                current.previous.next=newLink;  //присваиваем предыдущему элементу ссылку на текущий элемент
            }
            newLink.previous=current.previous;  //присваиваем новому элементу ссылку на предыдущий элемент
            newLink.next=current;               //присваиваем новокум элементу ссылку на следующий элемент (соответствует ссылке итератора)
            current.previous=newLink;           //в элементе на который ссылается итератор, меняем связь с предыдущим элементом, указав сссылку на новый элемент
        }
    }

    public Link deleteCurrent(){
        Link temp = current;                        //создаем ссылку на удаляемы элемент
        if(current!=null&&current.previous==null) { //если итератор указывает на первый элемент
            if(current.next!=null){                 // и если существует следующий элемент
                current.next.previous=current.previous; //то связываем элемент следующий за удаляемым с элементом преджествующим удаляемому, т.е. с null
            }
            current=current.next; //передвигаем итератор на следующий элементы
            list.setFirst(current); //удаляем из списка первый элемент
        }
        else if (current!=null&&current.next==null) { //если итератор указывает на последний элемент
            if (current.previous!=null){                //и предпоследний элемент существует
                current.previous.next=current.next;     //то связываем предпоследний элемент с элементом следущиюм за последним, т.е с null
            }
            current=current.previous;                   //передвигаем итератор на предшествующий элемент
            list.setLast(current);                      //удаляем из списка последний элемент
            reset();                                    //перемещаем итератор на первый элемент (движение по кольцу)
        }
        else {                                          //если итератор указывает на элемент в середине списка
            current.previous.next=current.next;         //то связываем элемент, предшествувующий элементу на который ссылается итератор, с элементом следующим за итератором
            current.next.previous=current.previous;     //а также связываем элемент, следующий за элеметом на который ссылается итератор, с элементом предшествующим итератору
            nextLink();                                 //передвигаем итератор на следующий элемент
        }
        return temp;
    }
}
