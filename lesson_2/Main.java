package ru.mylife.algorithmHomeWork1;
/*
1. Создать массив большого размера (миллион элементов).
2. Написать методы удаления, добавления, поиска элемента массива.
3. Заполнить массив случайными числами.
4. Написать методы, реализующие рассмотренные виды сортировок 
и проверить скорость выполнения каждой.
*/

/*
 Решение:
 1.Создан массив  arr;
 2.В классе ArrayDemo написаны медоты: insert, find, binaryFind, delete
 3.Массивы arr1,arr2,arr3 заполнены случайными числами.
 4.В классе ArrayDemo написаны медоты: bubbleSort, selectSort, itsertSort. Для оценки эффективности каждого вида
 сортировки внутри каждого метода определены переменные countMove и countCompare, подсчитывающие кол-во операций
 сравнения и перемещения. В каждом методе сортировки выводится в консоль кол-во фактически
 выполненных операций сравнения и перемещения.

 Результат показывает, что все три вариатна сортировки медленные.
 */

public class Main {

    public static void main(String[] args) {

        ArrayDemo arr = new ArrayDemo(1000000); //создан массив на 1000000 элементов
        ArrayDemo arr1 = new ArrayDemo(10000);
        ArrayDemo arr2 = new ArrayDemo(10000);
        ArrayDemo arr3 = new ArrayDemo(10000);
        /*
        три массива заполнены случайными элементами. Массивы созданы на 10000 элементов, т.к. при сортировке массива на
        1000000 процессор умирает
        */
        for (int i = 0; i < arr1.getLength(); i++) {
            arr1.insert((int) (Math.random() * 10000));
        }
        for (int i = 0; i < arr2.getLength(); i++) {
            arr2.insert((int) (Math.random() * 10000));
        }
        for (int i = 0; i < arr3.getLength(); i++) {
            arr3.insert((int) (Math.random() * 10000));
        }

        //System.out.println(arr1.find(28));
        //System.out.println(arr2.find(25));
        //System.out.println(arr3.find(55));
        //System.out.println();
        arr1.bubbleSort();
        //arr1.display();
        //System.out.println();
        arr2.selectSort();
        //arr2.display();
        //System.out.println();
        arr3.itsertSort();
        //arr3.display();
        //System.out.println();
        //System.out.println(arr1.binaryFind(28));
        //System.out.println(arr2.binaryFind(25));
        //System.out.println(arr3.binaryFind(55));
    }
}
