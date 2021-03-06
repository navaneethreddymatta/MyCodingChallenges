package nav.sortingAlgos;

public class SelectionSort {
	public static void main(String[] args) {
		int[] myArray = {1,5,9,-3,0,5,9,22,66};
		System.out.println("Selection Sort\n");
		System.out.println("Before Sorting");
		display(myArray);
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int temp;
		for(int i = 0; i < myArray.length; i++) {
			min = Integer.MAX_VALUE;
			for(int j = i; j < myArray.length; j++) {
				if(myArray[j] < min) {
					min = myArray[j];
					minIndex = j; 
				}
			}
			temp = myArray[i];
			myArray[i] = myArray[minIndex];
			myArray[minIndex] = temp;
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
