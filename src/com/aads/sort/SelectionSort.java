package src.com.aads.sort;

/**
 * @author Naresh M
 * 
 * Selection Sort - Time Complexity  - O(n^2)
 * 
 * 
 * Ref - Statements on Instructions
 * 
 * Final Equation would be T(n) = (n-2)C2 + n(n-1)/2 *C2 + (n-2)C3
 * This can be seen as polynomial equation   -  T(n) = an^2 + bn + c
 * 
 * Time Complexity is the Highest Order term of the Equation -> O(n^2) 
 *
 */
public class SelectionSort {

	public void sSort(int in[],int n) {

		int	tempArray[] = new int[n];  
		int max = 2147483647; //(2^31)-1

		for (int i = 0; i < n; i++) {

			int iMin = i;

			for (int j = 0; j < n; j++) {

				if(in[j] <= in[iMin])
				{

					iMin = j;
				}

			}

			tempArray[i] = in[iMin];
			in[iMin] = max;



		}


		System.arraycopy(tempArray, 0, in, 0, n);

	}


	public void sSortInPlace(int in[],int n) {


		for (int i = 0; i < n-2 ; i++) {

			//		This Statement call C1 runs for (n-2) times

			int iMin = i;

			for (int j = i+1; j < n; j++) {

				/*
				 * These Statements call C2 run 
				 * for i=0 (n-1) times 
				 * for i=2 (n-2) times
				 * .
				 * .
				 * etc
				 * 
				 * This can be seen as (n-1) + (n-2) + (n-3) ....+1
				 *  = n(n-1)/2 *C2
				 * 
				 * 
				 *  
				 */
				if(in[j] < in[iMin])
					iMin = j;

			}

			//			These Statements call C3 runs for (n-2) times

			int temp = in[iMin];
			in[iMin] = in[i];
			in[i] = temp;

		}

	}


	public static void main(String[] args) {


		SelectionSort sSortInst = new SelectionSort();

		int sArray[] = {7, 8, 1, 4, 2, 12};

		sSortInst.sSort(sArray, sArray.length);

		for (int i = 0; i < sArray.length; i++) {

			System.out.print(sArray[i] + "\t");
		}


		System.out.println("\n");
		int sArray1[] = {7, 8 , 1, 4, 2, 12};

		sSortInst.sSortInPlace(sArray1, sArray1.length);

		for (int i = 0; i < sArray1.length; i++) {

			System.out.print(sArray1[i] + "\t");
		}

	}

}
