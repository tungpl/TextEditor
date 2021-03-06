package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode(null);
		tail = new LLNode(null);
		head.next = tail;
		tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		try{
			LLNode newNode = new LLNode(element);
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev.next = newNode;
			tail.prev = newNode;
			this.size ++;
			return true;
		}
		catch(NullPointerException ne){
			
		}	
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.	
			if(index < 0) throw new IndexOutOfBoundsException();
			LLNode<E> tNode = head;
			int i = 0;			
			while(i<=index && tNode.next!= null){
				tNode = tNode.next;
				if(tNode == tail) throw new IndexOutOfBoundsException();
				else
				i++;
			}
		return (E)tNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode<E> tNode = head;
		int i = 0;		
		while(i <= index&& tNode.next !=null){
			tNode = tNode.next;
			i++;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next= tNode;
		newNode.prev = tNode.prev;
		tNode.prev.next = newNode;
		tNode.prev = newNode;	
		this.size ++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		LLNode<E> tNode = head;
		int i = 0;		
		while(i <= index&& tNode.next !=null){
			tNode = tNode.next;
			i++;
		}
		if(tNode == tail) throw new IndexOutOfBoundsException();
		tNode.prev.next = tNode.next;
		tNode.next.prev = tNode.prev;
		this.size --;
		return (E)tNode.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method
		if(index < 0) throw new IndexOutOfBoundsException();
		LLNode<E> tNode = head;
		int i = 0;		
		while(i <= index&& tNode.next !=null){
			tNode = tNode.next;
			i++;
		}
		if(tNode == tail ) throw new IndexOutOfBoundsException();
		LLNode<E> newNode = new LLNode<E>(element);
		newNode.next= tNode.next;
		newNode.prev = tNode.prev;
		tNode.prev.next = newNode;
		tNode.next.prev = newNode;	
		return (E)newNode.data;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
