package nav.sortingAlgos;

public class MergeSort {
	public static void main(String[] args) {
		int[] myArray = {99,1,5,9,-3,0,5,9,22,66};
		System.out.println("Merge Sort\n");
		System.out.println("Before Sorting");
		display(myArray);
		sortPartition(myArray,0,myArray.length - 1);
		System.out.println();
		System.out.println("After Sorting");
		display(myArray);		
	}
	
	public static void sortPartition(int[] myArray,int lowerIndex,int higherIndex) {
		if(lowerIndex < higherIndex) {
			int midIndex = (lowerIndex + higherIndex) / 2;
			sortPartition(myArray, lowerIndex, midIndex);
			sortPartition(myArray, midIndex + 1, higherIndex);
			merge(myArray, lowerIndex, midIndex, higherIndex);
		}
	}
	
	public static void merge(int[] myArr, int lower, int mid , int high) {
		int n1 = mid - lower + 1;
		int n2 = high - mid;
		int[] arr1 = new int[n1 + 1];
		int[] arr2 = new int[n2 + 1];
		for(int i = 0; i < n1; i++) {
			arr1[i] = myArr[lower + i];
		}
		arr1[n1] = Integer.MAX_VALUE;
		for(int i = 0; i < n2; i++) {
			arr2[i] = myArr[mid + 1 + i];
		}
		arr2[n2] = Integer.MAX_VALUE;
		int i = 0, j = 0, k = 0;
		while(k < (n1 + n2)) {
			if(arr1[i] <= arr2[j]) {
				myArr[k + lower] = arr1[i];
				i++;
			} else {
				myArr[k + lower] = arr2[j];
				j++;
			}
			k++;
		}
	}
	
	public static void display(int[] myArr) {
		for(int k = 0; k < myArr.length; k++) {
			System.out.print(myArr[k] + " ");
		}
		System.out.println();
	}
}