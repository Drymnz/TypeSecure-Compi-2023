package com.cunoc.Logic.Parser.Tree;

import java.util.ArrayList;

public class Node<T> {
    private T data;
    private Node<T> father = null;
    private ArrayList<T> listChild = new ArrayList<>();
    
    public Node(T data) {
        this.data = data;
    }
    
    public T getData() {
        return data;
    }
    public Node<T> getFather() {
        return father;
    }
    public ArrayList<T> getListChild() {
        return listChild;
    }
    
}
