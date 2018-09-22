public class DoubleEndedLinkedList {

    // a double-ended linked list as a reference to both the first as well as the last link in the list\
    Neighbor firstLink;
    Neighbor lastLink;

    public void insertInFirstPosition(String homeOwnerName, int houseNumber){

        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        if(isEmpty()){

            lastLink = theNewLink;

        } else {

            firstLink.previous = theNewLink;

        }

        theNewLink.next = firstLink;
        firstLink = theNewLink;


    }

    public void insertInlastPosition(String homeOwnerName, int houseNumber){

        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        if(isEmpty()){

            firstLink = theNewLink;

        } else {

            lastLink.next = theNewLink;
            theNewLink.previous = lastLink;

        }
        lastLink = theNewLink;
    }

    public boolean isEmpty() {
        return (firstLink == null);
    }

    public boolean insertAfterKey(String homeOwnerName, int houseNumber, int key){

        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);
        Neighbor currentNeighbor = firstLink;

        while(currentNeighbor.houseNumber != key){

            currentNeighbor = currentNeighbor.next;

            // this allows us throw ourselves out of the method
            if(currentNeighbor == null){
                return false;
            }
        }

        // When we find the match for our key
        if(currentNeighbor == lastLink){

            theNewLink.next = null;
            lastLink = theNewLink;

        } else {

            theNewLink.next = currentNeighbor.next;
            currentNeighbor.next.previous = theNewLink;

        }

        theNewLink.previous = currentNeighbor;
        currentNeighbor.next = theNewLink;
        return true;
    }

    // To insert all our house numbers in order
    public void insertInOrder(String homeOwnerName, int houseNumber){

        Neighbor theNewLink = new Neighbor(homeOwnerName, houseNumber);

        Neighbor previousNeighbor = null;
        Neighbor currentNeighbor = firstLink;

        while ((currentNeighbor != null) && (houseNumber > currentNeighbor.houseNumber)) {

            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;

        }

        if(previousNeighbor == null){

            firstLink = theNewLink;

        } else {

            previousNeighbor.next = theNewLink;

        }
        theNewLink.next = currentNeighbor;
    }

    public static void main(String[] args) {

        DoubleEndedLinkedList theLinkedList = new DoubleEndedLinkedList();

        /*
        theLinkedList.insertInFirstPosition("Jay-Z", 7);
        theLinkedList.insertInFirstPosition("Biggie Small", 9);
        theLinkedList.insertInFirstPosition("2 Pac", 6);
        theLinkedList.insertInFirstPosition("Logic", 4);
        */

        theLinkedList.insertInOrder("Jay-Z", 7);
        theLinkedList.insertInOrder("Biggie Small", 9);
        theLinkedList.insertInOrder("2 Pac", 6);
        theLinkedList.insertInOrder("Logic", 4);

        theLinkedList.insertAfterKey("Michael Chang", 10, 4);

        theLinkedList.display();

        System.out.println("\n");

        NeighborIterator neighbors = new NeighborIterator(theLinkedList);

        neighbors.currentNeighbor.display();

        System.out.println(neighbors.hasNext());

        neighbors.next();

        neighbors.currentNeighbor.display();

        neighbors.remove();

        neighbors.currentNeighbor.display();


    }

    public void display(){

        Neighbor theLink = firstLink;

        while(theLink != null) {

            theLink.display();
            System.out.println("Next Link: " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }



}

class Neighbor {

    public String homeOwnerName;
    public int houseNumber;

    public Neighbor next;
    public Neighbor previous;

    public Neighbor(String homeOwnerName, int houseNumber) {

        this.homeOwnerName = homeOwnerName;
        this.houseNumber = houseNumber;
    }

    public void display(){
        System.out.println(homeOwnerName + ": " + houseNumber + " Privet Drive");
    }

    public String toString() {
        return homeOwnerName;
    }


}


// Iterator provides an easy way for us to cycle through all the objects of our linked lists
class NeighborIterator{

    Neighbor currentNeighbor;
    Neighbor previousNeighbor;

    DoubleEndedLinkedList theNeighbors;

    NeighborIterator(DoubleEndedLinkedList theNeighbors){

        this.theNeighbors = theNeighbors;
        currentNeighbor = theNeighbors.firstLink;
        previousNeighbor = theNeighbors.lastLink;

    }


    public boolean hasNext(){

        if(currentNeighbor.next != null) {
            return true;
        }

        return false;
    }

    // To get the next value
    public Neighbor next() {

        if(hasNext()){

            previousNeighbor = currentNeighbor;
            currentNeighbor = currentNeighbor.next;

            return currentNeighbor;

        }
        return null;
    }

    // To remove objects from our linked list
    public void remove(){

        if(previousNeighbor == null){

            theNeighbors.firstLink = currentNeighbor.next;

        } else {

            previousNeighbor.next = currentNeighbor.next;

            if(currentNeighbor.next == null){

                currentNeighbor = theNeighbors.firstLink;
                previousNeighbor = null;

            } else {

                currentNeighbor = currentNeighbor.next;
            }
        }
    }
}
