import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] itemArray;
	private int size;
	
	public RandomizedQueue() {
		itemArray = (Item[])new Object[1];
		size = 0;
	}

	public boolean isEmpty() {
		return (size == 0);
	}
	
	private void resize(int capacity) {
		assert capacity >= size;
		
		Item[] temp = (Item[])new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = itemArray[i];
		}
		itemArray = temp;
	}

	public int size() {
		return size;
	}

	public void enqueue(Item item) {
		if (item == null)
			throw new java.lang.IllegalArgumentException(" Illegal argument");
		
		if (size == itemArray.length)
			resize(2 * itemArray.length);
		
		itemArray[size++] = item;	
	}

	public Item dequeue() {
		if (isEmpty())
			throw new NoSuchElementException(" No such element");
		
		int index = StdRandom.uniform(size);
		Item item = itemArray[index];
		itemArray[index] = itemArray[size-1];
		itemArray[size - 1] = null;
		size--;
		
		if (size > 0 && size == itemArray.length/4)
			resize(itemArray.length/2);
		
		return item;
	}

	public Item sample() {
		if (isEmpty())
			throw new NoSuchElementException(" No such element");
		
		int index = StdRandom.uniform(size);
		Item item = itemArray[index];
		
		return item;
	}

	public Iterator<Item> iterator() {
		return new ArrayIterator();
	}

	private class ArrayIterator implements Iterator<Item> {
		private int i;
		private final Item[] randomArray;
		
		public ArrayIterator() {
			i = size - 1;
			randomArray = (Item[])new Object[size];
			for (int j = 0; j < size; j++) {
				randomArray[j] = itemArray[j];
			}
			StdRandom.shuffle(randomArray);
		}
		
		public boolean hasNext() {
			return i >= 0;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			
			return randomArray[i--];
			
		}

		public void remove() {
			throw new java.lang.UnsupportedOperationException(" Remove not supported ");
		}
	}

	public static void main(String[] args) {
		RandomizedQueue<String> stack = new RandomizedQueue<String>();
		stack.enqueue("one");
		stack.enqueue("two");
		stack.enqueue("three");
		stack.enqueue("four");
		stack.enqueue("nine");
		stack.enqueue("five");
		stack.enqueue("six");
		stack.enqueue("seven");
		stack.enqueue("eight");
		
		for (String item:stack) {
			System.out.printf("%s\t", item);
		}
		
		System.out.println();
		System.out.println(" Dequeing: \n");
		stack.dequeue();
		stack.dequeue();
		stack.dequeue();
		
		for (String s: stack) {
			System.out.printf("%s\t", s);
		}
	}
}
