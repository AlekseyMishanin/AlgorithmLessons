package ru.mylife.algorithmHomeWork1;

public class ArrayDemo {

    private long[] array;       //массив
    private int nElem;          //кол-во элементов в массиве
    private int length;         //размер массива
    private boolean flagSort;   //признак упорядоченного массива

    public ArrayDemo(int size){
        array = new long[size];
        nElem=0;
        length=size;
        flagSort=false;
    }

    public int getLength(){
        return length;
    }

    public void display(){
        for (int i = 0; i < nElem; i++) {
            System.out.println(array[i] + " ");
        }
        System.out.println();
    }

    //при вставке элемент помещается в конец массива из-за выигрыша в скорости. Массив становится не упорядоченным
    public void insert (long value){
        if(nElem==length){System.out.println("Array full."); return;}
        array[nElem]=value;
        nElem++;
        flagSort=false;
    }

    //линейный поиск
    public int find (long value){
        for (int i = 0; i < nElem; i++) {
            if (array[i]==value){return i;}
        }
        return nElem;
    }

    //двоичный поиск
    public int binaryFind (long value){
        int lowerBound = 0;
        int upperBound = nElem-1;
        while (true){
            int middle = (lowerBound+upperBound)/2;
            if (lowerBound>upperBound){return nElem;}
            if (array[middle]==value){return middle;}
            if (array[middle]<value){
                lowerBound=middle+1;
            } else{
                upperBound=middle-1;
            }
        }
    }

    //при удалении если массив не упорядочен, то поиск элемента осуществляется линейным методом, если массив упорядочен,
    //то поиск осуществляется двоичным методом
    public boolean delete(long value){
        int j;
        if(flagSort){
            j=binaryFind(value);
        } else {
            j=find(value);
        }
        if (j==nElem){return false;}
        for (int i = j; i < nElem-1; i++) {
            array[i]=array[i+1];
        }
        nElem--;
        return true;
    }

    //сортировка методом пузырька. В методе подсчитывается кол-во операций перемещения и сравнения, что
    //отражает скорость, эффективность алгоритма
    public void bubbleSort(){
        int out, in;
        long countMove = 0, countCompare=0;
        for (out = nElem-1;  out>1 ; out--) {
            for (in=0;in<out;in++){
                countCompare++;
                if(array[in]>array[in+1]){
                    long temp=array[in];
                    array[in]=array[in+1];
                    array[in+1]=temp;
                    countMove++;
                    countMove++;
                }
            }
        }
        flagSort=true;
        System.out.println("Сортировка методом пузырька.");
        System.out.println("Операций стравнения = " + countCompare);
        System.out.println("Операций перемещения = " + countMove);
    }

    //сортировка методом выбора.В методе подсчитывается кол-во операций перемещения и сравнения, что
    //отражает скорость, эффективность алгоритма
    public void selectSort(){
        int out, in, min;
        long countMove = 0, countCompare=0;
        for (out=0;out<nElem;out++){
            min=out;
            for (in=out+1; in<nElem;in++){
                countCompare++;
                if(array[min]>array[in]){min=in;}
            }
            if (min!=out){
                long temp = array[out];
                array[out]=array[min];
                array[min]=temp;
                countMove++;
                countMove++;
            }
        }
        flagSort=true;
        System.out.println("Сортировка методом выбора.");
        System.out.println("Операций стравнения = " + countCompare);
        System.out.println("Операций перемещения = " + countMove);
    }

    //сортировка методом вставки.В методе подсчитывается кол-во операций перемещения и сравнения, что
    //отражает скорость, эффективность алгоритма
    public void itsertSort(){
        int out, in;
        long countMove = 0, countCompare=0;
        for (out = 1; out < nElem; out++) {
            long temp = array[out];
            for (in = out;in>0&&array[in-1]>=temp;in--){
                array[in]=array[in-1];
                countCompare++;
                countMove++;
            }
            array[in]=temp;
            countMove++;
        }
        flagSort=true;
        System.out.println("Сортировка методом вставки.");
        System.out.println("Операций стравнения = " + countCompare);
        System.out.println("Операций перемещения = " + countMove);
    }
}
