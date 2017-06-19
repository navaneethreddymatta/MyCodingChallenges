package nav.sortingAlgos;

public class InsertionSort {
	public static void main(String[] args) {
		int[] myArray = {1,5,9,-3,0,5,9,22,66};
		System.out.println("Insertion Sort\n");
		System.out.println("Before Sorting");
		display(myArray);
		int temp;
		for(int i = 1; i < myArray.length; i++) {			
			for(int j = i; j > 0; j--) {
				if(myArray[j] < myArray[j-1]) {
					temp = myArray[j];
					myArray[j] = myArray[j-1];
					myArray[j-1] = temp;
				}
			}
		}
		System.out.println();
		System.out.println("After Sorting");
		display(myArray);		
	}
	
	public static void display(int[] myArr) {
		for(int k = 0; k < myArr.length; k++) {
			System.out.print(myArr[k] + " ");
		}
		System.out.println();
	}
}
