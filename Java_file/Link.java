public class Link {

    public String bookName;
    public int millionsSold;

    public Link next;

    public Link(String bookName, int millionsSold){

        this.bookName = bookName;
        this.millionsSold = millionsSold;

    }

    public void display() {

        System.out.println(bookName + ": " + millionsSold + ",000,000");

    }

    public String toString() {

        return bookName;

    }

    public static void main(String[] args) {

        LinkList theLinkedList = new LinkList();

        // to insert new link
        theLinkedList.insertFirstLink("12 Rules of Life", 400);
        theLinkedList.insertFirstLink("Zero to One", 600);
        theLinkedList.insertFirstLink("The Space Baron", 700);
        theLinkedList.insertFirstLink("4-hour work week", 500);

        // display the list
        // theLinkedList.display();

        // remove the last item
        theLinkedList.removeFirst();
        //theLinkedList.display();

        // To search for a specific book
        System.out.println(theLinkedList.find("The Space Baron").bookName + " Was Found");

        // To remove a specific book
        theLinkedList.removeLink("The Space Baron");
        theLinkedList.display();

    }
}


class LinkList{

    public Link firstLink;

    LinkList() {

        firstLink = null;

    }

    public boolean isEmpty(){

        return (firstLink == null);

    }

    // How to insert a new link into a linked list?
    public void insertFirstLink(String bookName, int millionsSold){

        Link newLink = new Link(bookName, millionsSold);

        newLink.next = firstLink;

        firstLink = newLink;
    }

    //How to remove a link
    public Link removeFirst(){

        Link linkReference = firstLink;

        if(!isEmpty()){

            firstLink = firstLink.next;

        } else {

            System.out.println("Empty LinkedList");

        }

        return linkReference;
    }

    // How we cycle through a link list?
    public void display() {

        Link theLink = firstLink;

        while (theLink != null) {

            theLink.display();

            System.out.println("Next Link: " + theLink.next);

            theLink = theLink.next;

            System.out.println();

        }
    }

    // How to find a link list inside of the linked list?
    public Link find(String bookName) {

        Link theLink = firstLink;

        if(!isEmpty()){

            while (theLink.bookName != bookName){

                if(theLink.next == null){

                    return null;

                } else {

                    theLink = theLink.next;

                }
            }

        } else {

            System.out.println("Empty LinkedList");

        }

        return theLink;

    }

    // How to remove a specific link?
    public Link removeLink(String bookName) {

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while (currentLink.bookName != bookName){

            if(currentLink.next == null){

                return null;

            } else {

                previousLink = currentLink;

                currentLink = currentLink.next;
            }
        }

        if(currentLink == firstLink){

            firstLink = firstLink.next;

        } else {

            previousLink.next = currentLink.next;

        }

        return currentLink;

    }

}
