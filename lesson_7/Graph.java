package ru.lessons7;

import java.util.*;

public class Graph {

    private final int MAX_VERT = 20;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int nVerts;
    StackX stack;
    QueueX queue;

    Graph(){
        vertexList = new Vertex[MAX_VERT];
        adjMat = new int[MAX_VERT][MAX_VERT];
        nVerts=0;
        stack = new StackX();
        queue = new QueueX();
    }

    public void addVertex(char label){
        vertexList[nVerts++]= new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end]=1;
        adjMat[end][start]=1;
    }

    public void display(int index){
        System.out.print(vertexList[index].label);
    }
    public void displayAdjMat(){
        System.out.print("  ");
        for (int i = 0; i<10;i++){
            System.out.print(vertexList[i].label + " ");
        }
        System.out.println();
        for (int i = 0; i<10;i++){
            System.out.print(vertexList[i].label + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getAdjUnvisitedVertex(int vert){
        for (int i =0; i<nVerts;i++){
            if (adjMat[vert][i]==1&&vertexList[i].wasVisited==false){
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited=true;
        display(0);
        stack.push(0);
        while (!stack.isEmpty()){
            int temp = getAdjUnvisitedVertex(stack.peek());
            if (temp==-1){
                stack.pop();
            } else {
                vertexList[temp].wasVisited=true;
                display(temp);
                stack.push(temp);
            }
        }
        for (int i = 0; i<nVerts;i++){
            vertexList[i].wasVisited=false;
        }
    }

    public void bfs(){
        vertexList[0].wasVisited=true;
        //display(0);
        queue.insert(0);
        int temp;
        int flag = 0; //флаг для определения конечной вершины на которой путь обрывается
        int sumVert=0; //переменная для подсчета количества пройденных вершин
        System.out.println("Список вариантов маршрутов от минимального до максимального:");
        while (!queue.isEmpty()){
            int local_temp=queue.remove();

            while ((temp=getAdjUnvisitedVertex(local_temp))!=-1){
                flag = 1;
                vertexList[temp].wasVisited=true;
                //display(temp);
                queue.insert(temp);
            }
            if (flag==0){System.out.println("Путь от " + vertexList[0].label + " до "+ vertexList[local_temp].label + ", количество пройденных вершин " + sumVert);}
            flag=0;
            sumVert++;
        }
        for (int i = 0; i<nVerts;i++){
            vertexList[i].wasVisited=false;
        }
    }
}
