public class Recursion {

    public static void main(String[] args) {

        Recursion recursionTool = new Recursion();

        //recursionTool.calculateSquaresToPrint(6);

        //System.out.println("TN: " + recursionTool.getTriangularNum(6));

        //System.out.println("TN: " + recursionTool.getTriangularNumR(6));

        System.out.println("FACTORIAL: " + recursionTool.getFactorial(6));

    }

    // How to calculate triangular numbers when you didn't want to use recursion?
    public int getTriangularNum(int number) {
        int triangularNumber = 0;

        // 3+2+1 =6
        while(number > 0) {
            triangularNumber += number;
            number--;
        }

        return triangularNumber;
    }

    // How to calculate triangular numbers with recursion?
    public int getTriangularNumR(int number) {

        // To reiterate every recursive method
        // Well have a condition that leads to the method no longer making another
        // Condition: base case

        System.out.println("Method " + number);

        if(number == 1) {
       
            System.out.println("Returned 1");
            return 1;

        } else {

            int result = number + getTriangularNumR(number - 1);
            System.out.print("Returned " + result);
            System.out.println(" : " + number + " + getTN(" + number + " - 1)");

            return result;
        }
    }

    // How to calculate factorials?
    // ex. F(3) = 3 * 2 * 1
    public int getFactorial(int number) {
        System.out.println("Method " + number);

        if(number == 1) {

            System.out.println("Returned 1");
            return 1;

        } else {

            int result = number * getFactorial(number - 1);

            System.out.print("Returned " + result);
            System.out.println(" : " + number + " * getFACT(" + number + " - 1)");

            return result;
        }
    }

    // USED TO DEMOSTRATE TRIANGULAR NUMBERS --------------------

    // Draws the number of squares that are passed in Horizontally
    public void drawSquares(int howmanySquares) {

        for (int i = 0; i < howmanySquares; i++) {
            System.out.print(" --  ");
        }

        System.out.println();

        for (int i = 0; i < howmanySquares; i++) {
            System.out.print("|" + howmanySquares + " | ");
        }

        System.out.println();

        for (int i = 0; i < howmanySquares; i++) {
            System.out.print(" --  ");
        }

        System.out.println("\n");

    }

    // Outputs the number of squares to print to represent a triangle
    public void calculateSquaresToPrint(int number) {

        for (int i = 1; i <= number; i++) {

            for (int j = 1; j < i; j++) {
                drawSquares(j);
            }
            
            System.out.println("Triangular Number: " + calcTriangularNum(i));
        }
    }

    public double calcTriangularNum(int number) {
        return (.5 * number * (1 + number));
    }
}


/*
* What's Recursion?
*   A method that calls itself
*   With each method call the problem becomes simpler
*   Must have a condition that leads to the method no longer making another method call on itself
*
* Example
*   if(num == 1){
*
*       return 1;
*
*   } else {
*
*       return (num + getTriNum( num - 1)):
*
*   }
*
*
* */
