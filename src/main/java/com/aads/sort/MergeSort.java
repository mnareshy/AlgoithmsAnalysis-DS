package com.aads.sort;

public class MergeSort {


	public void merge(int in1[], int in2[], int in[])
	{ 

		int in1Length = in1.length;
		int in2Length = in2.length;

		int i = 0; 
		int j = 0; 
		int k = 0;

		while(i < in1Length && j < in2Length) {

			if(in1[i] < in2[j]) {

				in[k] = in1[i];
				i++;

			}
			else {

				in[k] = in2[j];
				j++;
			}

			k++;

		}


		if(i == in1Length) {

			System.arraycopy(in2, j, in, k, in2Length - j);
		}
		else if(j == in2Length)
		{
			System.arraycopy(in1, i, in, k, in1Length - i);
		}

		/*
		 * while(i < in1Length ) { in[k] = in1[i]; i++; k++;
		 * 
		 * }
		 * 
		 * while(j < in2Length ) { in[k] = in2[j]; j++; k++;
		 * 
		 * }
		 */

	}


	public void mergeSort(int in[]) {

		int inLength = in.length;

		if(inLength < 2) 
			return;

		int mid = inLength/2;

		int inLeft[] = new int[mid];
		int inRight[] = new int[inLength - mid];
		
		System.arraycopy(in, 0, inLeft, 0, mid);
		System.arraycopy(in, mid , inRight, 0, inLength - mid);
		
		mergeSort(inLeft);
		mergeSort(inRight);
		
		merge(inLeft, inRight, in);

	}


	public static void main(String[] args) {


		int in[] = {12, 1, 4, 2, 7, 9, 8, 0,27,32,8, 7,4};
		/*
		 * int in1[] = {1, 2, 4, 12, 27,32}; int in2[] = {0, 7, 8, 9, 8, 7};
		 * 
		 * MergeSort mSort = new MergeSort(); mSort.merge(in1, in2, in);
		 */

		MergeSort mSort = new MergeSort();
		mSort.mergeSort(in);

		for (int i = 0; i < in.length; i++) {

			System.out.print(in[i] + "\t");
		}


	}

}
