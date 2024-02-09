package com.aads.linkedlists;

public class CircularLinkedList {

    CircularLinkedList circularLinkedList = null;

    Node head = null;
    Node last = null;

    static class Node {

        Object data;
        Node next;
    }

    public void createList(int[] inArray) {

        circularLinkedList = new CircularLinkedList();

        int inArrLength = inArray.length;
        Node tempNode;


        Node headNode = new Node();
        headNode.data = inArray[0];
        headNode.next = null;


        head = headNode;
        last = head;

        for (int i = 1; i < inArrLength; i++) {

            tempNode = new Node();
            tempNode.data = inArray[i];
            tempNode.next = null;

            last.next = tempNode;
            last = tempNode;

        }

        last.next = head;
    }

    public void dispaly(Node node) {

        if(node == null )
           return;

        do {

            System.out.print(node.data + " ");
            node = node.next;

        } while (node != head);// While loop will not work as first condirion node != head will fial! should fail for second


    }

    static int flag = 0;

    public void displayRecurssive(Node node) {

        if (node != head || flag == 0) { //node!= head files here, so use flag to tackle
            flag = 1;
            System.out.print(node.data + " ");
            displayRecurssive(node.next);
        }

        // flag = 0;
    }

    public void insert(int position, int data) {

        if (position < 0 || position > lenght(head))
            return;

        Node node = head;

        Node tempNode = new Node();
        tempNode.data = data;
        tempNode.next = null;


        if (position == 0) {

            if (head == null) {

                head = tempNode;
                head.next = head;

            } else {

                while (node.next != head)
                    node = node.next;

                tempNode.next = head;
                node.next = tempNode;
                head = tempNode;
            }

        } else {
            for (int i = 0; i < position - 1; i++) {

                node = node.next;

            }

            tempNode.next = node.next;
            node.next = tempNode;

        }

    }

    public int lenght(Node node) {
        int length = 0;

        do {
            node = node.next;
            length++;
        } while (node != head);

        return length;
    }

    public void dellete(int position) {

        if (position < 0 || position > lenght(head))
            return;


        Node node  = head;

        if(position == 0){

            // if head is alone
            if(node.next == node)
            {
                head = null;
                return;
            }

            while (node.next != head)
                node = node.next;

            node.next = head.next;
            head = null;
            head = node.next;

        }
        else {

            for (int i = 0; i < position-2; i++) { //genarally position-1 - since taking the currtent pointer at -1 position using poition-2
                node = node.next;

            }

            Node tempNode = node.next;
            node.next = tempNode.next;
            tempNode = null;

        }

    }


    public static void main(String[] args) {
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        int[] inArray = {1, 2, 3, 4, 5, 6, 7, 8};
        circularLinkedList.createList(inArray);

        circularLinkedList.dispaly(circularLinkedList.head);
        System.out.println();
        circularLinkedList.displayRecurssive(circularLinkedList.head);

        System.out.println("\ninsert at 0 position");
        circularLinkedList.dispaly(circularLinkedList.head);
        circularLinkedList.insert(0, 17);
        System.out.println();
        circularLinkedList.dispaly(circularLinkedList.head);

        System.out.println("\ninsert at + position");
        circularLinkedList.insert(-1, 16);
        System.out.println();
        circularLinkedList.dispaly(circularLinkedList.head);

        System.out.println("\ndeleting at 0 position");
        circularLinkedList.dellete(0);
        System.out.println();
        circularLinkedList.dispaly(circularLinkedList.head);

        System.out.println("\ndeleting at + position");
        circularLinkedList.dellete(4);
        System.out.println();
        circularLinkedList.dispaly(circularLinkedList.head);

        System.out.println();
        CircularLinkedList circularLinkedList1 = new CircularLinkedList();
        int[] inArray1 = {4,8};
        circularLinkedList1.createList(inArray1);
        circularLinkedList1.dispaly(circularLinkedList1.head);
        System.out.println();
        circularLinkedList1.dellete(0);
        circularLinkedList1.dispaly(circularLinkedList1.head);



    }
}
