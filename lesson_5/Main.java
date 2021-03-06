package ru.lessons5;

import java.util.LinkedList;

/*
* 1. Написать программу по возведению числа в степень с помощью рекурсии.
* 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
*/

/*
* 1. Реализован метод myPower()
* 2. Реализован метод recursio()
**/

public class Main {

    public static void main(String[] args) {
        System.out.println(myPower(3,3));   //пример возведения числа в степень
        recursio(bag[0],weight,0);          //пример решения задачи с рюкзаком
    }

    /*
    х - число, которое нужно возвести в степеть;
    у - степень;
    возвращаемое значение = х^у;
     */
    static int myPower(int x, int y){
        if(y==1) {                  //базовое ограничение. Если степень равна 1
            return x;               //то возвращаем результат возведения х в степень у
        } else {
            /*
            Рекурсивно перемножаем число Х на самого себя, уменьшая значение степени(У) в два раза.
            Если степень нечетное число, то дополнительно умножаем результат возведения в степень на Х.
            */
            return y%2==1 ? x*myPower(x*x,y/2) : myPower(x*x,y/2);
        }
    }

    static int weight = 23;             //вес рюкзака (кг)
    static int[] bag = {5,3,5,8,10};    //мешок с несколькими предметами отличающимися друг от друга весом

    static LinkedList<Integer> list = new LinkedList<>();   //список куда заносятся последовательности с идеальным заполнением рюкзака

    /*
    item - вес n-ой вещи (кг)
    partBag - неизрасходованная полезная нагрузка рюкзака (кг)
    start - индекс начала перебора всех возможных комбинаций элементов с индексами >start. Данный индекс используется, чтобы
    сократить количество холостых вариантов итераций.
    Если идеальные комбинации существуют, то в консоль выводится содержимое list. В проитвном случае в консоль ничего не
    выводится
    */
    static void recursio (int item, int partBag, int start){

        /*
        Если вес рюкзака равен 0 следовательно найдена идеальная последовательность. Добавляем в list последний подходящий элемент
        Выводим содержимое списка в консоль. Удаляем из списка первый элемент. Возвращаем управление.
        */
        if(partBag==0){list.addFirst(item); for (Object i: list.toArray()) { System.out.print(i + " ");} list.removeFirst(); System.out.println(); return;}

        //если вес рюкзака отрицательное число, то последний выбранный предмет не подходит. Возвращаем управление
        if(partBag<0){ return;}

        /*
        цикл последовательно просматривает все возможные комбинации для каждого предмета, начиная с предмета с индексмо 0
        предметы которые переполняют рюкзак в рассматриваемой комбинации - перескакиваются if(partBag<0){ return;}
        */
        for (int i = start+1; i <= bag.length; i++){
            if (start>0)list.addFirst(item);                //добавляем в список элемент
            recursio(bag[i-1],partBag-bag[i-1], i);  //запихиваем в рюкзак следующий предмет bag[i-1], взвешиваем рюкзак partBag-bag[i-1], определяем шаг итерации i
            if (start>0)list.removeFirst();                 //удаляем из списка элемент
        }
    }
}
