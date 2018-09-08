package ru.mylife.algorithmHomeWork2;

//абстрактый класс очереди
public abstract class QueueA {
}

//абстрактный подкласс двухсторонней очереди
abstract class Deque extends QueueA {
    abstract void print();
}

//обобщенный класс двухсторонней очереди с фиксированной длиной, который реализует
//интерфейс, содержащий медоты вставки и удаления элементов
class FixedDeque<T extends Number> extends Deque implements DequeInterface<T>{
    private int size;           //размер очереди
    private T[] decue;          //массив под элементы
    private int leftBound, rightBound;  //левая и правая граница очереди

    FixedDeque(T[] array){
        this.decue = array;
        this.size = array.length;
        this.leftBound=0;
        this.rightBound=this.size-1;
    }

    @Override
    public void insertLeft (T value) throws QueueFullException{
        if(leftBound==rightBound){
            throw new QueueFullException(); //если очередь заполнена создается исключение
        }
        if(leftBound==size){leftBound=0;}
        decue[leftBound++]= value;
    }

    @Override
    public void insertRight (T value) throws QueueFullException{
        if(rightBound<leftBound){
            throw new QueueFullException(); //если очередь заполнена создается исключение
        }
        if(rightBound<0){rightBound=size-1;}
        decue[rightBound--]= value;
    }

    @Override
    public T removeLeft() throws QueueEmptyException{
        if((leftBound-1)<0&&(size-1)==rightBound) {
            throw new QueueEmptyException(); //если очередь пуста создается исключение
        }
        if((leftBound-1)<0&&(size-1)!=rightBound) {leftBound=size-1;}
        return decue[--leftBound];
    }

    @Override
    public T removeRight() throws QueueEmptyException{
        if((rightBound+1)==size&&0==leftBound) {
            throw new QueueEmptyException(); //если очередь пуста создается исключение
        }
        if((rightBound+1)==size&&0!=leftBound) {rightBound=0;}
        return decue[rightBound++];
    }

    @Override
    void print() {
        for (int i = leftBound-1; i != rightBound; i--) {
            if(i<0){i=size; continue;}
            System.out.println(decue[i] + " "); //печатается содержимое очереди слева направо
        }
    }
}