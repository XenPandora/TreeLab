
public class Tester 
{
	public static void main(String[] args)
	{
		//makes an array to test
		int[] tester = new int[5];
		tester[0] = 10;
		tester[1] = 40;
		tester[2] = 32;
		tester[3] = 67;
		tester[4] = 4;
		
		//uses the test array to make a heap
		Heap testHeap = new Heap(tester);
		//prints out the initial heap
		System.out.println("Printing Inital Heap:");
		testHeap.printVictims();
		
		//makes a max heap using the array
		MaxHeap test2 = new MaxHeap();
		for(int x = 0; x<tester.length; x++)
		{
			test2.add(tester[x]);
		}
		
		//makes a min heap using the array
		MinHeap test3 = new MinHeap();
		for(int x = 0; x<tester.length; x++)
		{
			test3.add(tester[x]);
		}
		
		//sorts the maxHeap in descending order
		//test2.maxHeapSort();
		//prints out the sorted heap
		test2.printMaxHeap();
		
		//sorts the minHeap in ascending order
		//test3.minHeapSort();
		//prints out the sorted heap
		test3.printMinHeap();
		
	}
}
