import java.io.*;
public class InsertionSort {
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
   // Start the loop taking second element in the array as key and then increment the key position
   for (int i = 1; i < elemArray.length; i++){
      int key = elemArray[i];
      int j = i-1;
      // Compare the key element with the previous elements in the array and if the key is smaller than the other element, swap them
      while((j > -1) && (elemArray[j] > key)){
         elemArray[j+1] = elemArray[j];
         j--;
      }
      elemArray[j+1] = key;         
   }      
   printNumbers(elemArray);             
}
public static void printNumbers(int sortedArray[]){
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
      // Close the BufferedWriter 
      bw.close();
   }
   catch(IOException ex){
      // Return an error message if there is any problem in writting to the output file      
      System.out.println("Error writing to file '" + opFile + "'");
   }   
}
}