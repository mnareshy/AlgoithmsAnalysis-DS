package com.aads.array_atd;

public class MyArrayAtd {

    int size;
    int length;

    int[] myArray;

    public MyArrayAtd(int size) {

        this.size = size;
        myArray = new int[size];
        this.length = 0;

    }

    public void display() {

        for (int i = 0; i < size; i++) {

            System.out.print(myArray[i] + " ");

        }
    }

    public int add(int ele) {

        if (length < size) {
            myArray[length] = ele;
            length++;

        } else
            throw new ArrayIndexOutOfBoundsException("length < size");


        return length;
    }

    public int insert(int ele, int index) {

        if (length + 1 < size && index >= 0 && index <= size) {

            for (int i = length; i >= index; i--) {

                myArray[i] = myArray[i - 1];

            }

            display();

            myArray[index] = ele;
            length++;

        }

        return length;
    }

    public int delete(int index) {

        int deletedEle = 0;

        if (index < size) {
            if (index > length)
                myArray[index] = 0;
            else {
                deletedEle = myArray[index];
                for (int i = index; i < length; i++) {

                    myArray[i] = myArray[i + 1];
                }
                length--;
            }


        } else
            throw new ArrayIndexOutOfBoundsException("delete(int " + index + ")");
        // display();
        System.out.println("--->" + deletedEle);
        return deletedEle;
    }

    public int linearSerch(int ele) {


        for (int i = 0; i < length; i++) {

            if (myArray[i] == ele)
                return i;

        }

        return -1;
    }

    public int linearSerchTransposition(int ele) {

        for (int i = 0; i < length; i++) {

            if (myArray[i] == ele) {

                myArray[i] = myArray[i - 1];
                myArray[i - 1] = ele;

                return i;
            }
        }

        return -1;
    }

    public int linearSerchMoveToFirst(int ele) {


        for (int i = 0; i < length; i++) {

            if (myArray[i] == ele) {

                myArray[i] = myArray[0];
                myArray[0] = ele;

                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int low, int high, int key) {

        int mid;
        while (low <= high) {

            mid = (low + high) / 2;

            if (myArray[mid] == key)
                return mid;
            else if (key < myArray[mid])
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -1;
    }

    public int binarySearchRecrrusion(int low, int high, int key) {

        int mid;

        if (low <= high) {
            mid = (low + high) / 2;

            if (myArray[mid] == key)
                return mid;
            else if (key < myArray[mid])
                return binarySearchRecrrusion(low, mid - 1, key);
            else
                return binarySearchRecrrusion(mid + 1, high, key);

        }

        return -1;
    }

    public int get(int index) {

        if (index >= 0 && index < myArray.length)
            return myArray[index];

        throw new ArrayIndexOutOfBoundsException("index is not in the range");
    }

    public void set(int index, int element) {

        if (index >= 0 && index < myArray.length)
            myArray[index] = element;
        else
            throw new ArrayIndexOutOfBoundsException("index is not in the range");
    }

    public int max() {

        int maxE = myArray[0];

        for (int i = 0; i < length; i++) {
            if (myArray[i] > maxE)
                maxE = myArray[i];


        }
        return maxE;
    }

    public int min() {

        int minE = myArray[0];

        for (int i = 0; i < length; i++) {
            if (myArray[i] < minE)
                minE = myArray[i];


        }
        return minE;
    }

    public int sum() {

        int total = 0;
        for (int i = 0; i < length; i++) {

            total = total + myArray[i];

        }

        return total;
    }

    public int sumRecurrecion(int n) {

        if (n < 0)
            return 0;
        else
            return sumRecurrecion(n - 1) + myArray[n];
    }

    public float avg() {

        return sum() / myArray.length;
    }

    public void reverseWithAuxilaryArray() {

        int[] auxArray = new int[length];

        for (int i = length - 1, j = 0; i >= 0; i--, j++) {
            auxArray[j] = myArray[i];
        }

        for (int i = 0; i < length; i++) {
            myArray[i] = auxArray[i];
        }
    }

    public void reverseWithSwap() {

        int temp = 0;
        for (int i = 0, j = length - 1; i <= j; i++, j--) {
            temp =  myArray[i];
            myArray[i] = myArray[j];
            myArray[j] = temp;
        }

    }


    public static void main(String[] args) {


        MyArrayAtd myArrayAtd = new MyArrayAtd(12);

        System.out.println(myArrayAtd.length);
        System.out.println(myArrayAtd.size);

        myArrayAtd.add(1);
        myArrayAtd.add(2);
        myArrayAtd.add(3);
        myArrayAtd.add(4);
        myArrayAtd.add(5);
        myArrayAtd.add(6);
        myArrayAtd.add(7);

        myArrayAtd.display();

        System.out.println(myArrayAtd.length);
        System.out.println(myArrayAtd.size);

        myArrayAtd.insert(7, 2);

        System.out.println(myArrayAtd.length);
        System.out.println(myArrayAtd.size);
        myArrayAtd.display();

        myArrayAtd.delete(2);
        myArrayAtd.display();
        System.out.println(myArrayAtd.length);
        System.out.println(myArrayAtd.size);


        System.out.println(myArrayAtd.linearSerch(4));


        System.out.println(myArrayAtd.linearSerchTransposition(4));
        myArrayAtd.display();
        System.out.println(myArrayAtd.linearSerchMoveToFirst(4));
        myArrayAtd.display();


        System.out.println(myArrayAtd.binarySearch(0, myArrayAtd.length, 7));
        System.out.println(myArrayAtd.binarySearchRecrrusion(0, myArrayAtd.length, 2));


        System.out.println(myArrayAtd.sum());
        System.out.println(myArrayAtd.sumRecurrecion(myArrayAtd.length));

        System.out.println(myArrayAtd.get(2));
        myArrayAtd.set(3, 12);

        System.out.println(myArrayAtd.min());
        System.out.println(myArrayAtd.max());
        System.out.println(myArrayAtd.avg());

        myArrayAtd.display();
        System.out.println();

        myArrayAtd.reverseWithAuxilaryArray();
        myArrayAtd.display();
        System.out.println();

        myArrayAtd.reverseWithSwap();
        myArrayAtd.display();
        System.out.println();
    }


}
