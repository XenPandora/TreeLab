
public class TreeTest 
{
	public static void main(String [] args)
	{
		Tree tree = new Tree();
		tree.addValue(5);
		tree.addValue(10);
		tree.addValue(3);
		tree.addValue(4);
		tree.addValue(1);
		tree.addValue(0);
		tree.addValue(7);
		tree.addValue(69);
		tree.addValue(40);
		
		MarqueSearch george = new MarqueSearch();
		System.out.println("Printing out breath first traversal:");
		george.bft(tree);
		System.out.println("Printing out depth first traversal:");
		george.dft(tree);
		
		System.out.println("Searching for a 3 in the heap using breath first method:");
		boolean bfsTest = george.bfs(tree, 3);
		if(bfsTest)
		{
			System.out.println("Breath first method has terminated correctly");
			System.out.println("Good job Ethan, you did something good for once");
		}
		
		System.out.println("Searching for a 3 in the heap using depth first method:");
		boolean dfsTest = george.dfs(tree, 3);
		if(dfsTest)
		{
			System.out.println("Depth first method has terminated correctly");
			System.out.println("Good job Ethan, you did something good again");
		}
	}
}
