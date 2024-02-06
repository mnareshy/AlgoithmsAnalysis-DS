package com.aads.linkedkists;


public class LinkedList {


    Node head = null;
    static LinkedList list = null;

    Node last = null;

    static class Node {

        Object data;
        Node next;
    }

    public static LinkedList createList(int[] inArray) {

        list = new LinkedList();

        int inArrLength = inArray.length;
        Node tempNode;


        Node headNode = new Node();
        headNode.data = inArray[0];
        headNode.next = null;

        list.head = headNode;

        list.last = list.head;

        for (int i = 1; i < inArrLength; i++) {

            tempNode = new Node();
            tempNode.data = inArray[i];
            tempNode.next = null;

            list.last.next = tempNode;
            list.last = tempNode;

        }


        return list;
    }

    public void add(int ele) {

        Node tempNode = new Node();
        tempNode.data = ele;
        tempNode.next = null;

        if (list.head == null) {

            list.head = tempNode;

        } else {
            list.last.next = tempNode;
            list.last = tempNode;
        }


    }

    public void displayList(LinkedList list) {

        Node cursorNode = list.head;

        while (cursorNode != null) {

            System.out.print(cursorNode.data + "  ");
            cursorNode = cursorNode.next;
        }


    }

    public void recursiveDisplayList(Node cursorNode) {

        if (cursorNode != null) {

            System.out.print(cursorNode.data + "  ");
            recursiveDisplayList(cursorNode.next);
        }
    }

    public void reverseRecursiveDisplayList(Node cursorNode) {

        if (cursorNode != null) {

            reverseRecursiveDisplayList(cursorNode.next);
            System.out.print(cursorNode.data + "  ");

        }
    }

    public int count(Node node) {

        int counter = 0;

        while (node != null) {

            counter++;
            node = node.next;

        }

        return counter;
    }

    public int recurresiveCount(Node node) {
        if (node == null)
            return 0;
        else
            return recurresiveCount(node.next) + 1;
    }

    public int sum(Node node) {

        int sum = 0;

        while (node != null) {

            sum = sum + (int)node.data;
            node = node.next;

        }

        return sum;
    }

    public int recurresiveSum(Node node) {

       if (node == null)
           return 0;
       else
           return recurresiveSum(node.next)+ (int)node.data;

    }

    public int max(Node node){

        int maxValue = Integer.MIN_VALUE;

        while (node != null){

            if((int)node.data > maxValue)
                maxValue = (int)node.data;

            node = node.next;
        }

        return maxValue;

    }

    public int recrrusiveMax(Node node){

        int temp = 0;

        if(node == null)
            return Integer.MIN_VALUE;

        temp = recrrusiveMax(node.next);

        return temp > (int)node.data ? temp : (int)node.data;


    }

    public Node search(Node node, int key){

        while(node != null){

            if(key == (int)node.data)
                return node;

            node = node.next;

        }

        return null;
    }

    public Node recurrsiveSearch(Node node, int key){

        if(node == null)
            return null;
        if(key == (int)node.data)
            return node;

        return recurrsiveSearch(node.next,key);

    }

    public Node improvedSearch(Node node, int key){

        Node previousNode = null;

        while (node != null){

            System.out.print(node.data +" ");

            if(key == (int)node.data){

                if(node != head) {
                    previousNode.next = node.next;
                    node.next = head;

                    head = node;
                }
                return node;

            }

            previousNode = node;
            node = node.next;

        }

        return null;
    }


    public void insert(int position ,int data){

        Node newNode = new Node();
        newNode.data = data;

        if(position == 0){

            newNode.next = head;
            head = newNode;

        }
        else {

            Node positionNode = head;

            for (int i = 0; i < position-1 && positionNode!= null; i++) {
                positionNode = positionNode.next;
            }

            newNode.next = positionNode.next;
            positionNode.next = newNode;

        }

    }


    public void insetInSortedLinkedList(int data){

        Node node = head;
        Node tailerNode = null;

        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if(head == null) {
            head = newNode;
        }
        else
        {
            while (node != null && (int)node.data < data){

                tailerNode = node;
                node = node.next;

            }

            if(node == head){

                newNode.next = head ;
                head = newNode;

            }
            else {

                newNode.next = node;
                tailerNode.next = newNode;

            }
        }

    }

    public void deleteFromList(int position){

        if(position == 0) {
            Node tempNode = head;
            head = head.next;
            tempNode = null;
        }
        else{

            Node node = head;
            Node tailerNode = null;

            for (int i = 0; i < position-1; i++) {

                tailerNode = node;
                node = node.next;

            }

            tailerNode.next = node.next;
            node = null;

        }

    }

    public boolean isLinkedListSorted(){

        int min = Integer.MIN_VALUE;

        Node node = head;

        while(node != null){

            if((int)node.data < min)
                return false;

            min = (int)node.data;
            node = node.next;

        }

        return true;
    }

    public void removeDuplicates(){

        Node node = head;
        Node nextNode = head.next;

        while (nextNode != null){

            if ((int)node.data != (int)nextNode.data) {
                //slide the poinetes to next nodes

                node = nextNode;
                nextNode = nextNode.next;

            }
            else{
                //remove the next node

                node.next = nextNode.next;
                nextNode = null;
                nextNode = node.next;
            }

        }

    }

    public static void main(String[] args) {

        int[] inArray = {1, 2, 3, 4, 5, 6, 7};
        LinkedList list = LinkedList.createList(inArray);

        list.displayList(list);
        System.out.println();

        list.add(8);

        list.displayList(list);
        System.out.println();

        list.recursiveDisplayList(list.head);
        System.out.println();

        list.reverseRecursiveDisplayList(list.head);
        System.out.println();

        System.out.println("Count " +list.count(list.head));
        System.out.println("Count Recurresive " +list.recurresiveCount(list.head));

        System.out.println("Sum " +list.sum(list.head));
        System.out.println("Sum Recurresive " +list.recurresiveSum(list.head));

        System.out.println("max " + list.max(list.head));
        System.out.println("max Recurresive " + list.recrrusiveMax(list.head));

        System.out.println("search "+ list.search(list.head, 7).data);
        System.out.println("search recurrsive " + list.recurrsiveSearch(list.head, 7).data );

        System.out.println("search improved " + list.improvedSearch(list.head, 7).data );
        System.out.println("search improved again " + list.improvedSearch(list.head, 8).data );

        System.out.println("insert at head 12");
        list.insert(0, 12);
        list.displayList(list);
        System.out.println();

        System.out.println("insert at position 4 and the data 12");
        list.insert(4, 12);
        list.displayList(list);
        System.out.println();

        int[] inArray1 = {1, 2, 3, 4, 5, 6, 8};
        LinkedList sortedList = LinkedList.createList(inArray1);
        sortedList.displayList(sortedList);
        sortedList.insetInSortedLinkedList(7);
        System.out.println();
        sortedList.displayList(sortedList);
        sortedList.insetInSortedLinkedList(12);
        System.out.println();
        sortedList.displayList(sortedList);

        list.deleteFromList(0);
        System.out.println();
        list.displayList(list);

        list.deleteFromList(4);
        System.out.println();
        list.displayList(list);

        int[] inArray2 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println();
        LinkedList sortedList1 = LinkedList.createList(inArray2);
        System.out.println("is list sorted "+ sortedList1.isLinkedListSorted());

        int[] inArray4 = {1, 2, 3, 4, 5, 5, 6, 8, 8, 8};
        System.out.println();
        LinkedList sortedList4= LinkedList.createList(inArray4);
        sortedList4.displayList(sortedList4);
        sortedList4.removeDuplicates();
        System.out.println("\nafter removing duplicates");
        sortedList4.displayList(sortedList4);

    }
}
