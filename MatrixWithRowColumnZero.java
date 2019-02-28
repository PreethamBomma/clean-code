/*
	Practices followed in the below code
	Small functions
	Descriptive names
	Brief description for all functions about what they do and the parameters they accept
	Less number of function arguments ( Max 2 )
    Atmost one return statement
	Space complexity - O(M x N)
	where M = number of rows
		  N = number of columns



*/
import java.util.Scanner;
import java.util.logging.Logger;

public class MatrixWithRowColumnZero {

	 private static Logger logger = Logger.getLogger("Matrix log");
	 static Scanner scanner = new Scanner(System.in);
	 static int matrix[][];
	 static int numberOfColumns = 0;
	 static int numberOfRows = 0;
	 static String rowIndex = "";
	 static String columnIndex = "";
	 static int i = 0, j = 0;
     
	 public static void main(String args[]){
	 logger.info("Enter the number of numberOfRows and numberOfColumns");
	 numberOfRows = scanner.nextInt();
	 numberOfColumns = scanner.nextInt();
	 logger.info("Enter the values");
	 readMatrixValues(numberOfRows,numberOfColumns);	
	 }
	 
	 /**
	  *	reads values entered by user
      *
	  * @param numberOfRows
      *
	  *	@param numberOfColums
	  *
	 */

	 public static void readMatrixValues(int numberOfRows, int numberOfColumns){
	 matrix = new int[numberOfRows][numberOfColumns];
	 for(i = 0; i < numberOfRows ; i++){
	 	for(j = 0; j < numberOfColumns ; j++){
	 		matrix[i][j] = scanner.nextInt();
	 	}
	 }
	 checkAndStoreZeroes();
    }

    /**
     *
	 *	checks for zeroes in the matrix and stores the index where an zero occurs
     *
    */


    public static void checkAndStoreZeroes(){

    for(i = 0; i< numberOfRows; i++){
    	for(j = 0;j< numberOfColumns; j++){
    		if(matrix[i][j] == 0){
    			rowIndex += i;
    			columnIndex += j;
    		}
    	}
    }
    parseStoredIndexesOfZero();
    displayResultMatrix();
    }

   /**
	*  parses the stored indexes where zero occurs 
   */

	public static void parseStoredIndexesOfZero(){
		for(i = 0; i < rowIndex.length(); i++){
			changeValueToZero(Character.getNumericValue(rowIndex.charAt(i)), Character.getNumericValue(columnIndex.charAt(i)));
		}
	}


	/**
	 *  changes the entire row and entire column to zero
     *
	 *	@param rowNumber 
	 *		   rowNumber where an zero occurred
     *
	 *	@param columnNumber
	 *			columnNumber where an zero occurred		   	
     *
	*/


    public static void changeValueToZero(int rowNumber, int columnNumber){

    System.out.println("makeZero "+ rowNumber + " "+ columnNumber);
    for(i = 0; i < numberOfColumns; i++){
    	matrix[rowNumber][i] = 0;
    }
    for(j = 0; j < numberOfRows; j++){
    	matrix[j][columnNumber] = 0;
    }

    }

    /**
	  *	displays the result matrix, after corresponding rows and columns are changed to zeroes
    */

    public static void displayResultMatrix(){

    for(i = 0 ;i < numberOfRows; i++){
    	for(j = 0;j<numberOfColumns; j++){
    		System.out.print(matrix[i][j]+ "  ");
    	}
    	System.out.println();
    }	
    }

}
