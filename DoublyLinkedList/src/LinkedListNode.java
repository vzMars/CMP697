public class LinkedListNode<I extends java.lang.Comparable<? super I>> {

    private I element;
    private LinkedListNode<I> next;
    private LinkedListNode<I> previous;

    public LinkedListNode(I element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public LinkedListNode(I element, LinkedListNode<I> next) {
        this.element = element;
        this.next = next;
        this.previous = null;
    }

    public I getElement() {
        return element;
    }

    public void setElement(I element) {
        this.element = element;
    }

    public LinkedListNode<I> getNext() {
        return next;
    }

    public void setNext(LinkedListNode<I> next) {
        this.next = next;
    }

    public LinkedListNode<I> getPrevious() {
        return previous;
    }

    public void setPrevious(LinkedListNode<I> previous) {
        this.previous = previous;
    }
}