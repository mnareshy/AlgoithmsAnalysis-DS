package com.aads.linkedlists;

public class DoublyLinkedList {

    //DoublyLinkedList list = null;

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
    }



    public void display(Node node) {

        while (node != null) {

            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    public int length(Node node) {
        int lenght = 0;

        while (node != null) {

            lenght++;
            node = node.next;

        }

        return lenght;
    }


    public void insert(int position, int data) {

        Node positionNode = head;

        Node tempNode = new Node();
        tempNode.data = data;

        if (position == 0) {

            tempNode.next = head;
            head.prev = tempNode;
            tempNode.prev = null;

            head = tempNode;

        } else {

            for (int i = 0; i < position - 1; i++) {

                positionNode = positionNode.next;

            }

            tempNode.prev = positionNode;
            tempNode.next = positionNode.next; // if there no next null will be assigned

            // if there is no next
            if (positionNode.next != null)
                positionNode.next.prev = tempNode;
            else
                last = tempNode;

            positionNode.next = tempNode;

        }

    }

    public void delete(int index) {

        Node positionNode = head;

        if (index < 0 || index > length)
            return;

        if (index == 1) {

            if (head.next != null) {
                head = head.next;
                head.prev = null;
            }

        } else {
            for (int i = 0; i < index - 1; i++) {

                positionNode = positionNode.next;

            }

            positionNode.prev.next = positionNode.next;
            positionNode.next.prev = positionNode.prev;

        }

        positionNode = null;

    }

    public void reverse(Node node) {

        Node positionNode = node;
        Node tempNode = null;

        while (positionNode != null) {

            tempNode = positionNode.next;
            positionNode.next = positionNode.prev;
            positionNode.prev = tempNode;

           /*
             this or the last if works

            if(positionNode.prev == null)
                head = positionNode;
            */
            // since the link is reversed
            positionNode = positionNode.prev;

            if (positionNode != null && positionNode.next == null)
                head = positionNode;

        }

    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        int[] inArray = {1, 2, 3, 4, 5, 6, 7};

        list.create(inArray);

        System.out.println("Display List");
        list.display(list.head);


        System.out.println("Lenght " + list.length);
        System.out.println("lenght " + list.length(list.head));

        System.out.println("\ninsert at 0th position");
        list.insert(0, 12);

        list.display(list.head);

        System.out.println("insert at other positions");
        list.insert(4, 12);
        list.display(list.head);

        System.out.println("delete at index 1");
        list.delete(1);
        list.display(list.head);

        System.out.println("delet at other than 1 indexe");
        list.delete(7);
        list.display(list.head);

        System.out.println("reverse list");
        list.reverse(list.head);
        System.out.println(list.head.data);
        list.display(list.head);

    }

}
