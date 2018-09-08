package ru.lessons7;

public class Main {

    public static void main(String[] args) {
	    Graph graph = new Graph();
	    for (int i = 0; i<10;i++) {
            graph.addVertex((char)('A'+i));
        }
        for (int i = 0; i<10;i++){
            for (int j = 0; j < 10; j++) {
                if (i!=j){
                    if(Math.random()>0.8){graph.addEdge(i,j);}
                }
            }
        }

        System.out.println("Матрица смежности:");
        graph.displayAdjMat();


        graph.bfs();
    }
}

