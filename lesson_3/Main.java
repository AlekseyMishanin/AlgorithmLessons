package ru.mylife.algorithmHomeWork2;

/*
1. Реализовать рассмотренные структуры данных в консольных программах.
2. Создать программу, которая переворачивает вводимые строки (Читает справа налево).
3. Создать класс для реализации дека.
*/

/*
Решение:
1.В классах Stack, Queue, PriorityQueue реализованы рассмотренные структуры. Примеры выводятся в метод main
2.Создан функциональный интерфейс InvertString с методом test. В методе
main объявлена интерфейсная ссылочная переменная. В рамках целевого типа интерфейса
реализовано блочное лямбда-выражение, которое при помощи стека переворачивает строку
3.Класс дека содержится в файле QueueA.java. В очереди реализованы методы: вставки слева
и справа, удаление слева и справа, а также печать содержимого очереди.
*/
public class Main {

    public static void main(String[] args) {

    	//пример стека
    	String input;
    	input=Bracket.getString();
	    if(!input.equals("")) {
			Bracket br = new Bracket(input);
			br.chack();
		}
		//пример очереди
        Queue q = new Queue(5);
	    q.insert(50);
		q.insert(40);
		q.insert(10);
		q.insert(20);
		q.insert(60);

		q.remove();
		q.remove();

		q.insert(70);
		q.insert(80);
		while (!q.isEmpty()){
			int n = q.remove();
			System.out.println(n + " ");
		}

		System.out.println();

		//пример приоритетной очереди
		PriorityQueue pq = new PriorityQueue(5);
		pq.insert(50);
		pq.insert(80);
		pq.insert(90);
		pq.insert(20);
		pq.insert(10);

		while (!pq.isEmpty()){
			int n = pq.remove();
			System.out.println(n + " ");
		}

		System.out.println();

		//премер программы переворачивающей строку
		InvertString iStr = (str)->{
			int lenStr = str.length();
			Stack stack = new Stack(lenStr);
			for (char ch: (new String(str)).toCharArray()) {
				stack.push((int)ch);
			}
			str.delete(0,lenStr);
			while(!stack.isEmpty()){
				str.append((char)stack.pop());
			}
			return str;
		};

		StringBuilder str = new StringBuilder("Java initial experience");
		System.out.println("Исходная строка - " + str);
		System.out.println();
		str = iStr.test(str);
		System.out.println("Перевернутая строка - " + str);
		System.out.println();


		//пример двухсторонней очереди
	   FixedDeque<Integer> dec = new FixedDeque<Integer>(new Integer[10]);
	   try{
		   dec.insertLeft(10);
		   dec.insertLeft(20);
		   dec.insertLeft(30);
		   dec.insertLeft(40);
		   dec.removeLeft();
		   dec.removeLeft();

		   dec.insertRight(50);
		   dec.insertRight(40);
		   dec.insertRight(80);
		   dec.insertRight(90);
		   dec.removeRight();
		   dec.removeRight();
		   dec.removeRight();
		   dec.insertRight(100);
		   dec.insertRight(150);
		   dec.insertRight(170);

		   dec.print();
	   } catch (QueueFullException|QueueEmptyException exc){
	   		System.out.println(exc.toString());
	   }

    }
}
