package ru.lessons6;

public class Tree {

    public Node root;

    public Node find (int key){
        Node current = root;
        while (current.getItem().getData()!=key){
            if(current.getItem().getData()>key){
                current=current.leftChild;
            } else{
                current=current.rightChild;
            }
            if(current==null){
                return null;
            }
        }
        return current;
    }

    public void insert(Item value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
        } else{
            Node current, parent;
            current=root;
            while (true){
                parent=current;
                if(value.getData()<current.getItem().getData()){
                    current=current.leftChild;
                    if(current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                } else if(value.getData()>current.getItem().getData()){
                    current=current.rightChild;
                    if(current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                } else {return;}
            }
        }
    }

    public boolean delete (Item value){
        if(root==null){
            return false;
        } else{
            Node parent = root, current = root;
            boolean isLeftChild = false;
            while (current.getItem().getData()!=value.getData()){
                parent=current;
                if (current.getItem().getData()>value.getData()){
                    isLeftChild=true;
                    current=current.leftChild;
                } else if(current.getItem().getData()<value.getData()){
                    isLeftChild=false;
                    current=current.rightChild;
                }
                if (current==null){ return false;}
            }

            //удаление листа
            if (current.leftChild==null&&current.rightChild==null){
                if(current==root){
                    root=null;
                } else if (isLeftChild){
                    parent.leftChild=null;
                } else {
                    parent.rightChild=null;
                }
            }

            //удаление узла с одним потомком
            if (current.leftChild==null){
                if(current==root){
                    root=current.rightChild;
                } else if (isLeftChild){
                    parent.leftChild=current.rightChild;
                } else {
                    parent.rightChild=current.rightChild;
                }
            } else if (current.rightChild==null) {
                if (current == root) {
                    root = current.leftChild;
                } else if (isLeftChild) {
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            } else {
                //удаление узла с двумя потомками
                Node succesor = getSuccesor(current);
                if (current == root) {
                    root = succesor;
                } else if (isLeftChild) {
                    parent.leftChild = succesor;
                } else {
                    parent.rightChild = succesor;
                }
                succesor.leftChild=current.leftChild;
            }
            return true;


        }
    }

    private Node getSuccesor(Node node){
        Node parentSuccesor = node;
        Node succesor = node;
        Node current = node.rightChild;
        while (current!=null){
            parentSuccesor=succesor;
            succesor=current;
            current=current.leftChild;
        }
        if(succesor!=node.rightChild){
            parentSuccesor.leftChild=succesor.rightChild;
            succesor.rightChild=node.rightChild;
        }
        return succesor;
    }

    public void display(){
        StringBuilder[] str = new StringBuilder[6];         //массив строк для вывода уровней дерева
        int line = 0;                                       //номер строки
        char[] ch = new char[200];                          //буфер символов
        for (int i = 0; i < ch.length; i++) {ch[i]=' ';}    //наполнение буфера пробелами
        rec(root, line, str, ch, 0);                    //вызов рекурсивного метода

        for (int i = 0; i < str.length; i++) {                  //вывод содержимоного каждого уровня
            if(str[i]!=null) {
                System.out.println(str[i]);}
        }
    }

    /*
    node - вершина дерева/поддерева;
    line - уровень дерева;
    str - массив строк для записи содержимого узла;
    ch - массив пробелов для разделения узлов
    parent - содержимое родительского узла
    */
    public void rec(Node node, int line, StringBuilder[] str, char[] ch, int parent){
        if(node!=null){
            if(str.length>line&&str[line]==null){str[line] = new StringBuilder();} //если строка, для записи содержимого всех узлов одного уровня дерева, не создана, то создаем ее
            if(str.length>line&&str[line]!=null) { //если строка создана
                str[line].append(new String(ch, 0, str.length-line+(int) Math.pow(2, str.length - line + 1) / 4) + node.getItem().getData() + "(" + parent + ")"); //вставляем str.length-line+Math.pow(2, str.length - line + 1) / 4) кол-во пробелов, далее содержимое узла и идентификатор родителя
            }
            line++; //переходим к следующему уровню дерева
            rec(node.leftChild,line, str, ch, node.getItem().getData()); //идем по левому потомку
            rec(node.rightChild,line, str, ch, node.getItem().getData());//идем по правому потомку
            if(str.length>line&&str[line]!=null) {str[line-1].append(new String(ch, 0, str.length-line+(int) Math.pow(2, str.length - line + 1) / 2));} //вставляем str.length-line+Math.pow(2, str.length - line + 1) / 2) кол-во пробелов

        } //else {if(line<str.length&&str[line]!=null) {str[line].append(new String(ch, 0, (int)(Math.pow(2,str.length-line+1)/2))+ "null" + "("+parent+")"+ new String(ch, 0, (int)(Math.pow(2,str.length-line+1)/2)));}}
    }
}
