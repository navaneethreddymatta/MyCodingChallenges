package nav.sortingAlgos;

public class BubbleSort {
	public static void main(String[] args) {
		int[] myArray = {1,5,9,-3,0,5,9,22,66};
		System.out.println("Bubble/Simple Sort\n");
		System.out.println("Before Sorting");
		display(myArray);
		int temp;
		for(int i = 0; i < myArray.length; i++) {
			for(int j = i; j < myArray.length; j++) {
				if(myArray[i] > myArray[j]) {
					temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
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
