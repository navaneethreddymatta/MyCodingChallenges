import java.util.Scanner;
public class HeapSort 
{    
    private static int len;
	/* Sort Function */
    public static void sort(int a[])
    {       
        heapify(a);      
        for (int i = len-1; i >= 0; i--)
        {
            swap(a,0, i);
            len = len-1;
			maxheap(a, 1);
        }
    }     
    /* Build heap */   
    public static void heapify(int a[])
    {
        len = a.length;
        for (int i = len/2; i > 0; i--){
            maxheap(a, i);
		}
    }
    /* Swap largest element in heap */        
    public static void maxheap(int a[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= len && a[left-1] > a[i-1]){
            max = left;
		}
        if (right <= len && a[right-1] > a[max-1]){     	
            max = right;
		} 
        if (max != i)
        {
            swap(a, i-1, max-1);
            maxheap(a, max);
        }
    }    
    /* Swap two numbers in an array */
    public static void swap(int a[], int i, int j)
    {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp; 
    }    
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner( System.in );        
        System.out.println("Heap Sort \n");
        int n, i;    
        System.out.println("Enter number of elements");
        n = scan.nextInt();    
        int a[] = new int[ n ];
        /* Read the elements to be sorted */
        System.out.println("\nEnter "+ n +" numbers which are to be sorted");
        for (i = 0; i < n; i++){
            a[i] = scan.nextInt();
		}
        /* Sort the array */
        sort(a);
        /* Print sorted Array */
        System.out.println("\nElements after sorting ");        
        for (i = 0; i < n; i++){
            System.out.print(a[i]+" ");            
		}
        System.out.println();            
    }    
}