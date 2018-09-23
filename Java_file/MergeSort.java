import java.util.Arrays;

// Merge Sort is going to sort in a very neat and organized way & very fast
public class MergeSort {

    public static void main(String a[]) {

        int array[] = { 10, 8, 4, 80, 13, 1, 3, 11 };

        System.out.println("STARTING ARRAY\n");

        printHorzArray(-1, -1, array, 49);

        System.out.println();

        //Send the array, 0 and the array size
        mergeSort_srt(array, 0, array.length - 1);

        System.out.print("FINAL SORTED ARRAY\n");

        printHorzArray(-1, -1, array, 49);
    }

    // Receives the array, 0 and the array size
    public static void mergeSort_srt(int array[], int lo, int n) {
        int low = lo;
        int high = n;

        if (low >= high){
            return;
        }

        // Find the middle index of the array
        int middle = (low + high) / 2;

        // CREATE 2 ARRAYS FROM THE ONE
        //Send the array, the middle index of the array
        mergeSort_srt(array, low, middle);

        // Send the array, the middle index + 1 and the highest index of the array
        mergeSort_srt(array, middle + 1, high);

        // Store the last index of the first array
        int end_low = middle;

        // Store the first index of the second array
        int start_high = middle + 1;

        // (the lowest index <= the bottom arrays) --> (highest Index & lowest index of the 2nd array <= its highest index)
        while ((low <= end_low) && (start_high <= high)) {

            System.out.println("\nBUTTON ARRAY");
            printSmallArray(array, lo, middle);
            System.out.println("\nTOP ARRAY");
            printSmallArray(array, start_high, high);
            printHorzArray(-1, -1, array, 49);

            // (1st array[1st index]) < value in 2nd array[1st index])
            System.out.println("Is " + array[low] + " < " + array[start_high] + "? " + (array[low] < array[start_high]));

            if (array[low] < array[high]){

                // Increment to the next index in the 1st array
                low++;

            } else {

                // Store the value in the 1st index of the 2nd array
                int Temp = array[start_high];
                System.out.println("Temp: " + Temp);

                // Decrement backwards through the 1st array starting at the last index oin the 1st array
                for (int k = start_high - 1; k >= low; k--) {

                    System.out.println("array[" + k + "] = " + array[k] + " Stored in array index " + (k + 1));
                    array[k + 1] = array[k];

                }

                System.out.println(Temp + " is stored in index " + low);

                printHorzArray(-1, -1, array, 49);

                array[low] = Temp;
                low++;
                end_low++;
                start_high++;
            }
        }
        printHorzArray(-1, -1, array, 49);
    }

    static void printSmallArray(int theArray[], int lo, int high){

        int[] tempArray = Arrays.copyOfRange(theArray, lo, high);
        int tempArrayDashes = tempArray.length * 6;
        System.out.println("Array Index Start " + lo + " and End " + high);
        printHorzArray(-1, -1, tempArray, tempArrayDashes);

    }


    static void printHorzArray(int i, int j, int theArray[], int numDashes){

        for (int n = 0; n < numDashes; n++) {
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < theArray.length; n++){
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");

        for (int n = 0; n < numDashes; n++){
            System.out.print("-");
        }

        System.out.println();

        for (int n = 0; n < theArray.length; n++) {
            System.out.print(String.format("| %2s " + " ", theArray[n]));
        }

        System.out.println("|");

        for (int n = 0; n < numDashes; n++){
            System.out.print("-");
        }

        System.out.println();

    }
}
