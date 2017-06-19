import java.io.*;
public class QuickSort{
public static void main(String [] args){	   
   // Read the name of the input file sent as an argument from the command line 
   String ipFile = args[0];
   String content = "";
   String tempContent = "";
   // Create the instance of a FileReader and BufferedReader
   try{
      FileReader fr = new FileReader(ipFile);
      BufferedReader br = new BufferedReader(fr);
      // Read each line from the file and append it to a string variable
      while((tempContent = br.readLine()) != null){
         content = content + tempContent;            
      }   
      // Close the BufferedReader instance
      br.close();         
   }
   catch(FileNotFoundException ex){
      // Return an error message if the input file is not found
      System.out.println("Unable to open file '" + ipFile + "'");                
   }
   catch(IOException ex){
      // Return an error message if there is any problem in reading the input file
      System.out.println("Error reading file '" + ipFile + "'");  
   }
   // Split the input string and parse each element and add to an array 
	  if(content.indexOf(":") != -1){
		String[] contentElements = content.split(":");
		content = contentElements[1];
	  }
   String[] elements = content.split(";");
   int arrayElements[] = new int[elements.length];
   int i=0;
   for (String element : elements){
      arrayElements[i] = Integer.parseInt(element);
      i++; 
   } 
   // Call the function to sort the array elements
   sortArray(arrayElements);        
	}
	public static void sortArray(int elemArray[]){
		int low = 0;
		int high = elemArray.length - 1;
		long start = System.currentTimeMillis();		
		quickSort(elemArray, low, high);	
		long end = System.currentTimeMillis();		
		long duration = end - start;
		//print the numbers to an output file
		printNumbers(elemArray,duration);             
	}
	public static void quickSort(int[] unSortedArray, int low, int high){			
		if(unSortedArray == null || unSortedArray.length == 0)
			return;
		if(low >= high)
			return;
		// Select the pivot element
		int pivotPosition = high;
		int pivot = unSortedArray[pivotPosition];
		// move smaller elements to left of pivot and greater elements to right
		int i = low - 1, j = low, temp = 0;
		while(j < high){
			if(unSortedArray[j] <= pivot){
				i++;
				temp = unSortedArray[i];
				unSortedArray[i] = unSortedArray[j];
				unSortedArray[j] = temp;
			}			
			j++;
		}
		i++;
		//move the pivot element to ith position, so that all the smaller elements will be on left to the pivot and larger elements will be on the right 
		if(i != high){
			temp = unSortedArray[i];
			unSortedArray[i] = unSortedArray[high];
			unSortedArray[high] = temp;
		}
		if(i != 0)
			quickSort(unSortedArray,low,i-1);
		if(i != high)
			quickSort(unSortedArray,i+1,high);
	} 	
	public static void printNumbers(int sortedArray[],long duration){
		// Set the name of the output file
		String opFile = "answer.txt";
		String sortedArrayStr = "";
		// Generate the output string from the sorted integer array
		for(int k = 0; k < sortedArray.length; k++){
			sortedArrayStr = sortedArrayStr + sortedArray[k] + ";";         
		}
		// Remove the last semicolon(;) at the end of the output string
		if(sortedArrayStr.length() > 0){
			sortedArrayStr = sortedArrayStr.substring(0, sortedArrayStr.length() - 1);
		}
		// Create the instance of a FileWriter and BufferedWriter      
		try{
			FileWriter fw = new FileWriter(opFile);
			BufferedWriter bw = new BufferedWriter(fw); 
			// Write the output string to the file 
			bw.write(sortedArrayStr);    
			bw.newLine();
			bw.write("Performance analysis:");
			bw.newLine();
			bw.write(String.format("%-20s %-20s%n", "Size", "Sorting Time(in milliseconds)"));
			bw.write(String.format("%-20s %-20s%n", sortedArray.length, duration)); 			
			// Close the BufferedWriter 
			bw.close();
		}
		catch(IOException ex){
			// Return an error message if there is any problem in writting to the output file      
			System.out.println("Error writing to file '" + opFile + "'");
		}   
	}
}