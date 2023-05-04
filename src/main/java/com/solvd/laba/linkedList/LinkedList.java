package com.solvd.laba.linkedList;

import java.util.Objects;

public class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList(){
        head = null;
    }

    public void add(T t) {
        Node<T> newNode = new Node<>(t);
        Node<T> currentNode = head;
        if (head==null) {
            head = newNode;
        } else {
            while(currentNode.nextNode !=null) {
                currentNode=currentNode.nextNode;
            }
            currentNode.nextNode=newNode;
        }
        size++;
    }

    public void addPosition(T t, int index){
        if (size+1<index){
            System.out.println("Wrong index in LinkedList ");
        }
        if(index==1){
            Node<T> temp = head;
            head= new Node<>(t);
            head.nextNode=temp;
            return;
        }
        Node<T> temp = head;
        Node<T> prevNode = new Node<T>(null);
        while (index - 1 > 0) {
            prevNode = temp;
            temp = temp.nextNode;
            index--;
        }
        prevNode.nextNode = new Node<T>(t);
        prevNode.nextNode.nextNode = temp;
    }

    public void remove(T t) {
        Node<T> currentNode = head;
        Node<T> prevNode = null;
        while (currentNode != null) {
            if (currentNode.data.equals(t)) {
                size--;
                if(currentNode == head) {
                    head = currentNode.nextNode;
                } else {
                    prevNode.nextNode = currentNode.nextNode;
                }
            } else {
                prevNode = currentNode;
            }
            currentNode = currentNode.nextNode;
        }
    }

    public void clear(){
        size=0;
        head=null;
    }

    public void printList() {
        Node<T> currentNode = head;
        if (head !=null){
            System.out.println(head.data);
        }
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
            System.out.println(currentNode.data + " ");
        }
    }
    public int getSize() {
        return size;
    }
    public static class Node<T> {
        private T data;
        private Node<T> nextNode;

        public Node(T data) {
            this.data = data;
            nextNode = null;
        }

        public Node() {
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<T> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", nextNode=" + nextNode +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(nextNode, node.nextNode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, nextNode);
        }
    }

}
