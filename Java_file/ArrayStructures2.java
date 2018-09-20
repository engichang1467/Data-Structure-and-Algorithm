public class ArrayStructures2 {
    
    private int[] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray(){

        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int)(Math.random()*10)+10;
        }
    }

    // Linear Search
    public String linearSearchForValue(int value) {

        boolean valueInArray = false;
        String indexsWithValue = "";

        for( int i = 0; i < arraySize; i++) {

            if(theArray[i] == value){

                valueInArray = true;
                indexsWithValue += i + " ";

            }
            printHorzArray(i, -1);
        }

        if(!valueInArray){
            indexsWithValue = "None";
        }
        System.out.print("The Value was Found in the Following: " + indexsWithValue);
        System.out.println();
        return indexsWithValue;
    }

    public void printHorzArray(int i, int j) {

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + n + "  ");
        }

        System.out.println("|");

        for (int n = 0; n < 51; n++){
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + theArray[n] + " ");
        }

        System.out.println("|");

        for(int n = 0; n < 51; n++) {
            System.out.print("-");
        }

        System.out.println();

        // End of first part

        // ADDED FOR BUBBLE SORT
        if (j != -1) {

            // Add the +2 to fix spacing
            for(int k = 0; k < ((j*5)+2); k++) {

                System.out.print(" ");

            }

            System.out.print(j);
        }

        // Then add this code
        if(i != -1) {

            // Add the -1 to fix spacing
            for(int l = 0; l < (5*(i-j)-1); l++) {
                System.out.print(" ");
            }
            System.out.print(i);
        }
        System.out.println();
    }

    // Bubble Sort - it sorts everything from smallest to largest, or by changing one little tiny piece of code it's going to sort largest and smallest
    public void bubbleSort() {

        for(int i = arraySize - 1; i > 1; i--) {

            for(int j = 0; j < i; j++) {

                if(theArray[j] > theArray[j+1]) {

                    swapValues(j, j+1);
                    printHorzArray(i, j);
                }
                printHorzArray(i, j);
            }
        }
    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

    public void binarySearchForValue(int value) {

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex) {

            int middleIndex = (highIndex + lowIndex) / 2;

            if(theArray[middleIndex] < value) {

                lowIndex = middleIndex + 1;

            } else if(theArray[middleIndex] > value) {

                highIndex = middleIndex - 1;

            } else {

                System.out.println("\nFound a Match for " + value + " at index " + middleIndex);
                lowIndex = highIndex + 1;

            }
            printHorzArray(middleIndex, -1);
        }
    }

    // Selection sort - it's going to save a number in a minimum spot as it finds it, and then repeat searching through the entire array each time to slowly put teh whole entire array in order
    public void selectionSort(){

        for(int x = 0; x < arraySize; x++) {

            int minimum = x;

            for (int y = x; y < arraySize; y++) {

                if(theArray[minimum] > theArray[y]) {
                    minimum = y;
                }
            }
            swapValues(x, minimum);
            printHorzArray(x, -1);
        }

    }


    //
    public void insertionSort() {

        for(int i = 1; i < arraySize; i++){

            int j = i;
            int toInsert = theArray[i];

            while((j > 0) && (theArray[j-1] > toInsert)){

                theArray[j] = theArray[j-1];
                j--;
                printHorzArray(i, j);
            }

            theArray[j] = toInsert;
            printHorzArray(i, j);
            System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert);
        }
    }


    public static void main(String[] args) {

        ArrayStructures2 newArray = new ArrayStructures2();

        newArray.generateRandomArray();
        
        //newArray.linearSearchForValue(11);

        //newArray.bubbleSort();

        //newArray.binarySearchForValue(11);

        //newArray.selectionSort();

        newArray.insertionSort();

    }
}
