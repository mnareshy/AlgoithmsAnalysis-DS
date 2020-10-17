package src.com.aads.sort;

/**
 * @author Naresh M
 * 
 * BubbleSort - Time Complexity Worst Case - O(n^2)
 * 			  - Time Complexity Average Case - O(n^2)
 * 			  - Time Complexity Best Case - O(n)
 * 
 * 
 * Ref - Statements on Instructions
 * 
 * Final Equation would be T(n) = (n-1)C1 + n(n-1)/2 *C2 
 * This can be seen as polynomial equation   -  T(n) = an^2 + bn + c
 * 
 * Time Complexity is the Highest Order term of the Equation -> O(n^2) 
 * 
 * If we skip the passes ,if the array is already sorted  Time COmpleity would be O(n)
 *
 */
public class BubbleSort {


	public void bSort(int in[],int n) {

		for (int i = 0; i < n-1; i++) {

			for (int j = 0; j < n-1 ; j++) {


				if(in[j] > in[j+1])
				{

					int temp = in[j];
					in[j] = in[j+1];
					in[j+1] = temp;

				}

			}

		}


	}

	

	public void bSortOpt(int in[],int n) {


		//	This Statement call C1 runs for (n-2) times
		for (int i = 0; i < n-1; i++) {

			boolean isSorted = true;


			/*
			 * j < n-i-1 - optimized to skip the sorted array This Statement call C2 runs
			 * for (n-i-1) times
			 *  for i=0 (n-1) times
			 *  for i=2 (n-2) times . . etc
			 * 
			 * This can be seen as (n-1) + (n-2) + (n-3) ....+1 = n(n-1)/2 *C2
			 */
			for (int j = 0; j < n-i-1 ; j++) {


				if(in[j] > in[j+1])
				{

					int temp = in[j];
					in[j] = in[j+1];
					in[j+1] = temp;
					isSorted = false;

				}

			}

			// optimized to skip the passed if the array is sorted before completing all the passes
			// This make the best case where the Array is already sorted time complexity  - O(n)
			if(isSorted) 
				break;

		}


	}


	public static void main(String[] args) {


		BubbleSort sSortInst = new BubbleSort();


		int sArray[] = {7, 8, 1, 4, 2, 12, 0};

		sSortInst.bSort(sArray, sArray.length);

		for (int i = 0; i < sArray.length; i++) {

			System.out.print(sArray[i] + "\t"); }


		System.out.println("\n");
		int sArray1[] = {7, 8 , 1, 4, 2, 12, 0, 1, 27, 20 , 28 , 29 , 30};

		sSortInst.bSortOpt(sArray1, sArray1.length);

		for (int i = 0; i < sArray1.length; i++) {

			System.out.print(sArray1[i] + "\t");
		}

	}

}
