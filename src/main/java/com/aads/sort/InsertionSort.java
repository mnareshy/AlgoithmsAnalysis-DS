package src.com.aads.sort;

/**
 * @author Naresh M
 * 
 * InsertionSort - Time Complexity Worst Case - O(n^2)
 * 			     - Time Complexity Average Case - O(n^2)
 * 			     - Time Complexity Best Case - O(n)
 * 
 * 
 * Ref - Statements on Instructions
 * 
 * In Worst and Average cases 
 *
 * Final Equation would be T(n) = (n-1)C1 + n(n-1)/2 *C2 
 * This can be seen as polynomial equation   -  T(n) = an^2 + bn + c
 * 
 * Time Complexity is the Highest Order term of the Equation -> O(n^2) '
 * 
 * In Best Case - where the Array is already sorted , While loop will not execute
 * 
 * Time Complexity would be O(n) -considering C1 executes only (n-1) times and highest order is n.
 *
 */
public class InsertionSort {




	public void iSort(int in[],int n) {


		//	This Statement call C1 runs for (n-1) times
		
		for (int i = 1; i < n; i++) {
			
			int mark = i;
			int value = in[mark];

			/*
			 * for every i , loop runs until mark > 0 and in[mark -1] > value
			 * consider the statements execute C2
			 * 
			 *  worst and avarage cases loop runs for (n-1) + (n-2) + (n-3) ....+1 
			 *    
			 * 
			 * This can be seen as (n-1) + (n-2) + (n-3) ....+1 = n(n-1)/2 *C2
			 * 
			 * In Best Case  where the Array is already sorted , While loop will not execute
			 * 			 
			 */
			
			while (mark > 0 && in[mark -1] > value) {
				
				
				in[mark] = in[mark -1];
				mark = mark - 1;

				}

			in[mark] = value;
			}

			


	}


	public static void main(String[] args) {


		InsertionSort sSortInst = new InsertionSort();


		int sArray[] = {7, 8, 1, 4, 2, 12, 0};

		sSortInst.iSort(sArray, sArray.length);

		for (int i = 0; i < sArray.length; i++) {

			System.out.print(sArray[i] + "\t"); }




	}

}
