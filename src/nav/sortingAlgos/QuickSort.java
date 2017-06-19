package nav.sortingAlgos;

public class QuickSort {
	public static void main(String[] args) {
		int[] myArray = {99,1,5,9,-3,0,5,9,22,66};
		System.out.println("Quick Sort\n");
		System.out.println("Before Sorting");
		display(myArray);
		sortPartition(myArray,-1,myArray.length - 1);
		System.out.println();
		System.out.println("After Sorting");
		display(myArray);		
	}
	
	public static void sortPartition(int[] myArray,int lowerIndex,int higherIndex) {
		int pivot = higherIndex;
		if(lowerIndex + 1 < pivot) {
			int temp;
			int i;
			for(i = lowerIndex + 1; i < higherIndex; i++) {
				if(myArray[i] <= myArray[pivot]) {
					lowerIndex++;
					temp = myArray[i];
					myArray[i] = myArray[lowerIndex];
					myArray[lowerIndex] = temp; 
				}			
			}
			temp = myArray[i];
			myArray[i] = myArray[++lowerIndex];
			myArray[lowerIndex] = temp; 
			sortPartition(myArray, -1, lowerIndex-1);
			sortPartition(myArray, lowerIndex, higherIndex);
		}
	}
	
	public static void display(int[] myArr) {
		for(int k = 0; k < myArr.length; k++) {
			System.out.print(myArr[k] + " ");
		}
		System.out.println();
	}
}
