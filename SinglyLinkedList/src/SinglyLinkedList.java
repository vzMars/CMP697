public class SinglyLinkedList <I extends java.lang.Comparable<? super I>> implements ListInterface<I> {
    private LinkedListNode<I> head;
    private LinkedListNode<I> tail;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public void add(I element) {
        LinkedListNode<I> node = new LinkedListNode<>(element);

        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            this.tail.setNext(node);
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
            this.head = node;
            this.length++;
            return;
        }

        if (index == this.length - 1) {
            this.tail.setNext(node);
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

        node.setNext(currentNode);
        previousNode.setNext(node);
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
        SinglyLinkedList<I> copy = new SinglyLinkedList<>();

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
        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();

        linkedList.add(1);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
//        linkedList.add(20, 4);

//        System.out.println("Removed: " + linkedList.remove(2));

//        System.out.println("Replaced: " + linkedList.replace(15, 2));

//        System.out.println("Added: 2");
        linkedList.addSorted(8);

        for(int i = 0; i < linkedList.length; i++) {
            System.out.println(linkedList.get(i));
        }


//        linkedList.removeAll();
//        System.out.println(linkedList.isEmpty());
//        System.out.println(linkedList.size());
//        System.out.println(linkedList.head.getNext());
//        System.out.println(linkedList.tail.getNext());
//        SinglyLinkedList<Integer> copyLinkedList = (SinglyLinkedList<Integer>) linkedList.copy();
//        LinkedListNode<Integer> currentNode = copyLinkedList.head;
//        while (currentNode != null) {
//            System.out.println(currentNode.getElement());
//            currentNode = currentNode.getNext();
//        }

//        linkedList.add(5, 5);
//
//        System.out.println("Added 5");
//        currentNode = linkedList.head;
//        while (currentNode != null) {
//            System.out.println(currentNode.getElement());
//            currentNode = currentNode.getNext();
//        }
    }
}