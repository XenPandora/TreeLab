import java.util.Queue;
import java.util.LinkedList;

public class MarqueSearch extends Tree
{
	public MarqueSearch(){}
	
	//printing methods
	
	//prints out all elements in a tree using depth first
	public void dft(Tree bt)
	{
		Queue<DataContainer> traverser = new LinkedList<DataContainer>();
		
		//goes to the bottom and back tracks, lowest levels get offered to queue
		if(bt.hasLeft())
		{
			Tree left = new Tree(bt.rootLeft());
			dft(left);
		}
		
		traverser.offer(bt.getRoot());
		
		if(bt.hasRight())
		{
			Tree right = new Tree(bt.rootRight());
			dft(right);
		}
		
		
		
		//polls the traverser queue and prints it out
		while(!traverser.isEmpty())
		{
			System.out.println(traverser.poll().getData());
			
		}
	}
	
	//prints out all elements in a tree using breath first
	public void bft(Tree bt)
	{
		Queue<DataContainer> traverser = new LinkedList<DataContainer>();
		
		//goes level by level, left to right, and offers values to the queue
		traverser.offer(bt.getRoot());
		
		
		//polls the traverser queue and prints it out
		while(!traverser.isEmpty())
		{
			System.out.println(traverser.poll().getData());
			if(bt.hasLeft())
			{
				Tree left = new Tree(bt.rootLeft());
				bft(left);
			}
			if(bt.hasRight())
			{
				Tree right = new Tree(bt.rootRight());
				bft(right);
			}
		}
	}
	
	
	
	//searching methods
	
	public boolean dfs(Tree bt, int searchTarget)
	{
		Queue<DataContainer> traverser = new LinkedList<DataContainer>();
		boolean found = false;
		
		//goes to the bottom and back tracks, lowest levels get offered to queue
		if(bt.hasLeft())
		{
			traverser.offer(bt.getRoot().getLeft());
		}
		traverser.offer(bt.getRoot());
		if(bt.hasRight())
		{
			traverser.offer(bt.getRoot().getRight());
		}
		
		//goes through entire traverser queue and returns true if searchTarget is in the queue
		while(!traverser.isEmpty() && !found)
		{
			if(traverser.peek().getData() == searchTarget)
			{
				System.out.println("Target found!");
				found = true;
				break;
			}
			else
			{
				System.out.println(traverser.peek().getData() +" Checked");
				if(bt.getRoot() != null && !found)
				{
					if(bt.hasLeft() && !found)
					{
						Tree left = new Tree(bt.rootLeft());
						dfs(left, searchTarget);
					}
					
					traverser.offer(bt.getRoot());
					
					if(bt.hasRight() && !found)
					{
						Tree right = new Tree(bt.rootRight());
						dfs(right, searchTarget);
					}
				}
				
			}
			
			traverser.poll();
		}
		
		return found;
	}
	
	public boolean bfs(Tree bt, int searchTarget)
	{
		Queue<DataContainer> traverser = new LinkedList<DataContainer>();
		boolean found = false;
		
		
		//goes level by level, left to right, and offers values to the queue
		traverser.offer(bt.getRoot());
		
	
		//goes through entire traverser queue and returns true if searchTarget is in the queue
		while(!traverser.isEmpty() && !found)
		{
			if(traverser.peek().getData() == searchTarget)
			{
				System.out.println("We found the target!");
				found = true;
				break;
			}
			
			else
			{
				System.out.println(traverser.poll().getData() +" Checked");
				if(bt.hasLeft() && !found)
				{
					Tree left = new Tree(bt.rootLeft());
					found = bfs(left, searchTarget);
				}
				if(bt.hasRight() && !found)
				{
					Tree right = new Tree(bt.rootRight());
					found = bfs(right, searchTarget);
				}
			}
		}
		
		return found;
		
	}
}
