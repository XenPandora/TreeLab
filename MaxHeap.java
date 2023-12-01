
//heapsort #2

public class MaxHeap extends Heap implements Heapify
{
	public MaxHeap(int[] initialHeap)
	{
		super(initialHeap);
	}
	
	public MaxHeap()
	{
		super();
	}
	
	//sorts the heap where the root is the largest value, and all its kids go in descending order
	public void maxHeapSort()
	{
		int index = 0;
		while(super.hasRight(index))
		{
			int biggerIndex = super.getRightIndex(index);
			if(super.hasLeft(index) && super.getLeft(index) > super.getRight(index))
			{
				biggerIndex = super.getLeftIndex(index);
			}
			
			if(super.getParentIndex(index) > super.getParentIndex(biggerIndex))
			{
				break;
			}
			else
			{
				super.swap(index, biggerIndex);
				index = biggerIndex;
			}
		}
	}
	
	//returns the first element in the array and adjusts the heap
	public int poll()
	{
		int first = super.poll();
		heapifyDown();
		return first;
	}
	
	public void add(int victim)
	{
		super.add(victim);
		heapifyUp();
	}
	
	//makes sure the heap looks correct from top down
	public void heapifyDown()
	{
		int index = 0;
		while(super.hasRight(index))
		{
			int biggerChildIndex = super.getRightIndex(index);
			if(super.hasLeft(index) && super.getRight(index) < super.getLeft(index))
			{
				biggerChildIndex = super.getLeftIndex(index);
			}
			
			if(super.currentElement(index) > super.currentElement(biggerChildIndex))
			{
				break;
			}
			else
			{
				super.swap(index, biggerChildIndex);
				index = biggerChildIndex;
			}
		}
	}
	
	//makes sure the heap looks correct from down to top
	public void heapifyUp()
	{
		int index = super.getSize() - 1;
		while(super.notDeadBeat(index) && super.getParent(index) < super.currentElement(index))
		{
			super.swap(super.getParentIndex(index), index);
			index = super.getParentIndex(index);
		}
	}
	
	//prints out the heap
	public void printMaxHeap()
	{
		System.out.println("Printing Max Heap:");
		super.printVictims();
	}
}
