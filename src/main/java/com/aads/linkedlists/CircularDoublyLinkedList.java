package com.aads.linkedlists;

import java.util.Base64;
import java.util.LinkedList;

public class CircularDoublyLinkedList {

    Node head = null;
    Node last = null;

    int length = 0;

    class Node {

        Node prev;
        Object data;
        Node next;

    }

    public void create(int[] inArray) {

        Node node = new Node();

        node.data = inArray[0];
        node.prev = null;
        node.next = null;

        int arrLenght = inArray.length;

        head = node;
        last = node;
        length++;


        for (int i = 1; i < arrLenght; i++) {

            node = new Node();
            node.data = inArray[i];
            node.prev = last;
            node.next = null;
            last.next = node;

            last = node;
            length++;
        }

        last.next = head;
        head.prev = last;

    }

    public void display(Node node){

        do{
            System.out.print(node.data + " ");
            node = node.next;
        }while (node != head);

        System.out.println();
    }

    public void insert(int position, int data){

    Node positionNode = head;

    Node newNode = new Node();
    newNode.data = data;

        if (position == 0) {

            newNode.next = head;
           // head.prev = newNode;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;

            head = newNode;

        } else {

            for (int i = 0; i < position - 1; i++) {

                positionNode = positionNode.next;

            }

            newNode.prev = positionNode;
            newNode.next = positionNode.next; // if there no next null will be assigned

            // if there is no next
            if (positionNode.next != null)
                positionNode.next.prev = newNode;
            else
                last = newNode;

            positionNode.next = newNode;

        }

    }

    public static void main(String[] args) {



        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        int[] inArray = {1, 2, 3, 4, 5, 6, 7};

        list.create(inArray);
        System.out.println();

        list.display(list.head);

        list.insert(0,12);
        list.display(list.head);

        list.insert(4,12);
        list.display(list.head);
    }

}
