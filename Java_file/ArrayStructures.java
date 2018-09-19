public class ArrayStructures {

    private int[] theArray = new int[50];
    private int arraySize = 10;
    public void generateRandomArray(){

        for(int i = 0; i < arraySize; i++) {
            theArray[i] = (int)(Math.random()*10)+10;
        }
        
    }
    
    public void printArray() {

        System.out.println("----------");

        // print out all my different values
        for (int i = 0; i < arraySize; i++) {

            System.out.print("| " + i + " | ");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");

        }
    }

    //How to get our value from the index?
    public int getValueAtIndex(int index) {

        if(index < arraySize){
            return theArray[index];
        }
        return 0;
    }

    // To find out if an array contains a value
    public boolean doesArrayContainThisValue(int searchValue) {

        boolean valueInArray = false;
        for(int i = 0; i < arraySize; i++) {

            if(theArray[i] == searchValue){
                valueInArray = true;
            }
        }
        return valueInArray;
    }

    // Deleting an index and then moving all the other values up
    public void deleteIndex(int index) {

        if(index < arraySize) {
            
            for(int i = index; i < (arraySize - 1); i++) {
                theArray[i] = theArray[i+1];
            }
            arraySize--;
        }
    }

    // How to insert value?
    public void insertValue(int value){

        if(arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }

    // Linear Search
    public String linearSearchForValue(int value) {

        boolean valueInArray = false;
        String indexsWithValue = "";
        System.out.print("The Value was Found in the Following: ");

        for( int i = 0; i < arraySize; i++) {

            if(theArray[i] == value){
                valueInArray = true;
                System.out.println(i + " ");
                indexsWithValue += i + " ";
            }
        }

        if(!valueInArray){
            indexsWithValue = "None";
            System.out.print(indexsWithValue);
        }
        
        System.out.println();
        return indexsWithValue;
    }


    public static void main(String[] args) {

        ArrayStructures newArray = new ArrayStructures();

        newArray.generateRandomArray();

        //print my array
        newArray.printArray();

        System.out.println(newArray.getValueAtIndex(3));

        System.out.println(newArray.doesArrayContainThisValue(18));

        newArray.deleteIndex(4);

        newArray.printArray();

        newArray.insertValue(55);

        newArray.printArray();

        newArray.linearSearchForValue(17);

    }
}

/*
 * What's an algorithm?
 *
 * Steps you take to manipulate data
 * Data Structures: The way data is arranged in memory
 * Main Data Structure Operations
 *   Inserting, Deleting, and Searching
 *
 * Arrays
 *
 * int[] arrayName = new int[3];
 * int thirdValue = arrayName[2];
 * int[] arrayName = {12,16,24};
 * arrayName[1] ---> Return 16
 *
 * What is going on?
 * String[][][] arrayName = {{{"000"}, {"100"}, {"200"}, {"300"}},
 *                           {{"010"}, {"110"}, {"210"}, {"310"}},
 *                           {{"020"}, {"120"}, {"220"}, {"320"}}};
 * arrayName[How many down (3)][How many across (4)][How many of those groups (1)]
 *
 *
 * Deleting an index value row
 *
 *   +----+----+----+----+
 * 0 | 12 | 18 | 18 | 18 |
 *   +----+----+----+----+
 * 1 | 18 | 18 | 10 | 10 |
 *   +----+----+----+----+
 * 2 | 10 | 10 | 10 |    |
 *   +----+----+----+----+
 *
 * Linear Search
 *
 *   +----+
 * 0 | 11 |
 *   +----+
 * 1 | 18 |
 *   +----+
 * 2 | 11 |
 *   +----+
 * */
