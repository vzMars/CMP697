public class DoublyLinkedList<I extends java.lang.Comparable<? super I>> implements ListInterface<I> {

    private LinkedListNode<I> head;
    private LinkedListNode<I> tail;
    private int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void showList() {
        LinkedListNode<I> currentNode = this.head;
        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.getNext();
        }
    }

    public void showListReverse() {
        LinkedListNode<I> currentNode = this.tail;
        while (currentNode != null) {
            System.out.println(currentNode.getElement());
            currentNode = currentNode.getPrevious();
        }
    }

    @Override
    public void add(I element) {
        LinkedListNode<I> node = new LinkedListNode<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
        }

        this.length++;
    }

    @Override
    public void add(I element, int index) {
        if (index >= this.length || index < 0) {
            return;
        }

        LinkedListNode<I> node = new LinkedListNode<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }

        if (index == 0) {
            node.setNext(this.head);
            this.head.setPrevious(node);
            this.head = node;
            this.length++;
            return;
        }

        if (index == this.length - 1) {
            this.tail.setNext(node);
            node.setPrevious(this.tail);
            this.tail = node;
            this.length++;
            return;
        }

        LinkedListNode<I> currentNode = this.head;
        LinkedListNode<I> previousNode = this.head;

        int count = 0;
        while (count < index) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            count++;
        }

        node.setPrevious(previousNode);
        node.setNext(currentNode);
        previousNode.setNext(node);
        currentNode.setPrevious(node);
        this.length++;
    }

    @Override
    public void addSorted(I element) {
        LinkedListNode<I> node = new LinkedListNode<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }

        LinkedListNode<I> currentNode = this.head;
        LinkedListNode<I> previousNode = this.head;

        int count = 0;
        while (currentNode != null) {
            if (currentNode.getElement().compareTo(element) > 0) {
                node.setNext(currentNode);

                if (count == 0) {
                    this.head = node;
                } else {
                    node.setPrevious(previousNode);
                    previousNode.setNext(node);
                }

                this.length++;
                return;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            count++;
        }

        // Adds element to the end of the list if it is the largest
        this.add(element);
    }

    @Override
    public ListInterface<I> copy() {
        DoublyLinkedList<I> copy = new DoublyLinkedList<>();

        LinkedListNode<I> currentNode = this.head;
        while (currentNode != null) {
            copy.add(currentNode.getElement());
            currentNode = currentNode.getNext();
        }

        return copy;
    }

    @Override
    public I get(int index) {
        if (index >= this.length || index < 0 || this.head == null) {
            return null;
        }

        if (index == 0) {
            return this.head.getElement();
        }

        if (index == this.length - 1) {
            return this.tail.getElement();
        }

        LinkedListNode<I> currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            if (count == index) {
                return currentNode.getElement();
            }
            currentNode = currentNode.getNext();
            count++;
        }


        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public I remove(int index) {
        if (index >= this.length || index < 0 || this.head == null) {
            return null;
        }

        I removed = null;

        if (this.length == 1) {
            removed = this.head.getElement();
            this.head = null;
            this.tail = null;
            this.length = 0;
            return removed;
        }

        if (index == 0) {
            removed = this.head.getElement();
            this.head = this.head.getNext();
            this.head.setPrevious(null);
            this.length--;
            return removed;
        }

        LinkedListNode<I> currentNode = this.head;
        LinkedListNode<I> previousNode = this.head;

        int count = 0;
        while (currentNode != null) {
            if (count == index && index == this.length - 1) {
                removed = currentNode.getElement();
                previousNode.setNext(null);
                this.tail = previousNode;
                this.length--;
                return removed;
            } else if (count == index) {
                removed = currentNode.getElement();
                currentNode.getNext().setPrevious(previousNode);
                previousNode.setNext(currentNode.getNext());
                this.length--;
                return removed;
            }
            previousNode = currentNode;
            currentNode = currentNode.getNext();
            count++;
        }

        return null;
    }

    @Override
    public void removeAll() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public I replace(I element, int index) {
        if (index >= this.length || index < 0 || this.head == null) {
            return null;
        }

        LinkedListNode<I> currentNode = this.head;
        int count = 0;
        while (currentNode != null) {
            if (count == index) {
                I replaced = currentNode.getElement();
                currentNode.setElement(element);
                return replaced;
            }
            currentNode = currentNode.getNext();
            count++;
        }

        return null;
    }

    @Override
    public int size() {
        return this.length;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);

//        linkedList.remove(3);
//        System.out.println(linkedList.get(3));

        linkedList.addSorted(2);

        linkedList.showList();
//        linkedList.showListReverse();
//        System.out.println(linkedList.isEmpty());
    }
}
