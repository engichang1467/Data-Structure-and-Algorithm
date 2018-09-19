import java.util.Arrays;

public class TheStack {

    // Create a stack
    private String[] stackArray;
    private int stackSize;  // the size of the array
    private int topOfStack = -1;  // represents that its empty

    TheStack(int size) {

        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");
    }

    // To put an item on to the stack, you have to push it on to the stack
    public void push(String input) {

        if (topOfStack + 1 < stackSize){
            topOfStack++;
            stackArray[topOfStack] = input;            
        } else {
            System.out.println("Sorry But the stack is Full");
        }

        displayTheStack();
        System.out.println("PUSH " + input + " Was Added to the Stack");
    }

    // To get information off the stack & remove it, its called a pop
    public String pop(){

        if(topOfStack >= 0) {

            displayTheStack();
            System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];

        } else {
            // if the stack is empty
            displayTheStack();
            System.out.println("Sorry But the Stack is Empty");
            return "-1";
        }
    }

    // To peek - to see what's at the top of the stack but not remove it
    public String peek() {

        displayTheStack();
        System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");

        return stackArray[topOfStack];
    }



    public void displayTheStack() {

        for(int n = 0; n < 61; n++) {
            System.out.print("-");
        }

        System.out.println();

        for(int n = 0; n < stackSize; n++){
            System.out.format("| %2s " + " ", n);
        }

        System.out.println("|");

        for(int n = 0; n < 61; n++){
            System.out.print("-");
        }

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            if(stackArray[n].equals("-1")){

                System.out.print("|     ");

            } else {

                System.out.print(String.format("| %2s " + " ", stackArray[n]));

            }

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++){

            System.out.print("-");

        }

        System.out.println();

    }

    public void pushMany(String multipleValues) {

        String[] tempString = multipleValues.split(" ");

        for(int i = 0; i < tempString.length; i++){
            push(tempString[i]);
        }
        
    }

    public void popAll(){

        for(int i = topOfStack; i >= 0; i--){
            pop();
        }
        
    }



    public static void main(String[] args) {

        // Testing it
        TheStack theStack = new TheStack(10);

        theStack.push("10");

        theStack.push("15");

        theStack.peek();

        theStack.pop();

        theStack.pushMany("12 13 14 15");

        theStack.popAll();

        theStack.displayTheStack();


    }

}

/*Stacks and Queues are used to complete a task
*
* Stack vs Queue
* Stack is going to allow access to just one item being the last item put into the stack
*
* Queue is going to provide access to just one item, bu t the 1st item put in is going to be the first item pulled out
*
* */
