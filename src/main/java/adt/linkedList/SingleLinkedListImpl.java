package adt.linkedList;
 
public class SingleLinkedListImpl<T> implements LinkedList<T> {
 
    protected SingleLinkedListNode<T> head;
     
    public SingleLinkedListImpl() {
        this.head = new SingleLinkedListNode<T>();
    }
 
    @Override
    public boolean isEmpty() {
        return this.head.isNIL();
    }
 
    @Override
    public int size() {
        int count = 0;
        SingleLinkedListNode<T> aux = head;
        while (!aux.isNIL()) {
            ++count;
            aux = aux.getNext();
        }
        return count;
    }
 
    @Override
    public T search(T element) {
        SingleLinkedListNode<T> aux = head;
        
        while (!aux.isNIL() && !aux.getData().equals(element)) {
            aux = aux.getNext();
        }
        
        return aux.getData();
    }
 
    @Override
    public void insert(T element) {
        SingleLinkedListNode<T> newNode = new SingleLinkedListNode(element, new SingleLinkedListNode<>());
        
        if (isEmpty()) {
        	this.head = newNode;        	
        }
        else {
            SingleLinkedListNode<T> aux = head;
           
            while (!aux.getNext().isNIL()) {
            	aux = aux.getNext();            	
            }
 
            aux.setNext(newNode);
        }
    }
 
    @Override
    public void remove(T element) {
        if (!isEmpty()) {
 
            if (this.head.getData().equals(element)) {
                this.head = this.head.getNext();
                return;
            }
 
            SingleLinkedListNode<T> prev = new SingleLinkedListNode<>();
            SingleLinkedListNode<T> aux = head;
             
            while (!aux.isNIL() && !aux.getData().equals(element)) {
                prev = aux;
                aux = aux.getNext();
            }
 
            if (!aux.isNIL()){
                prev.setNext(aux.getNext());
                return;
             }
        }
    }
     
    @Override
    public T[] toArray(){
        T[] array = (T[]) new Comparable[this.size()];
         
        int count = 0;
        SingleLinkedListNode<T> aux = head;
        while (!aux.isNIL()) {
            array[count] = aux.getData();
            aux = aux.getNext();
            count++;
        }
         
        return array;
         
    }
 
    public SingleLinkedListNode<T> getHead() {
        return head;
    }
 
    public void setHead(SingleLinkedListNode<T> head) {
        this.head = head;
    }
 
     
}
