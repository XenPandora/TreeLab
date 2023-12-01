
public class Tree 
{
	private DataContainer root;
	
	public Tree()
	{
		root = null;
	}
	
	public Tree(int r)
	{
		root = new DataContainer(r);
	}
	
	public Tree(DataContainer r)
	{
		root = r;
	}
	
	public void addValue(int value)
	{
		if(root == null)
		{
			root = new DataContainer(value);
		}
		else if(value < root.getData())
		{
			if(root.getLeft() == null)
			{
				root.setLeft(value);
					//size++;
			}
			else
			{
				DataContainer temp = root;
				root = root.getLeft();
				addValue(value);
				root = temp;
			}
		}
		else
		{
			if(root.getRight() == null)
			{
				root.setRight(value);
			}
			else
			{
				DataContainer temp = root;
				root = root.getRight();
				addValue(value);
				root = temp;
			}
		}
	}
	
	public boolean search(int value)
	{
		if(root == null)
		{
			return false;
		}
		else if(root.getData() == value)
		{
			return true;
		}
		else if(value<root.getData())
		{
			if(root.getLeft().getData() == value)
			{
				return true;
			}
			else
			{
				//need to find a way to access the left and then search from there
				Tree left = new Tree(root.getLeft());
				return left.search(value);
			}
		}
		else 
		{
			if(root.getRight().getData() == value)
			{
				return true;
			}
			else
			{
				//need to find a way to access the right and then search from there
				Tree right = new Tree(root.getRight());
				return right.search(value);
			}
		}
	}
	
	//gets the largest DataContainer in the tree and returns it
	public DataContainer findLargest()
	{
		DataContainer largest = root;
		if(largest.getRight() != null)
		{
			if(largest.getRight().getData() > largest.getData())
			{
				largest = largest.getRight();
				return findLargest();
			}
		}
		if(largest.getLeft() != null)
		{
			if(largest.getLeft().getData() > largest.getData())
			{
				largest = largest.getLeft();
				return findLargest();
			}
		}
		return largest;
	}
	
	public DataContainer getRoot()
	{
		return root;
	}
	
	public DataContainer rootLeft()
	{
		return root.getLeft();
	}
	
	public DataContainer rootRight()
	{
		return root.getRight();
	}
	
	public boolean hasLeft()
	{
		return root.getLeft()!=null;
	}
	
	public boolean hasRight()
	{
		return root.getRight()!=null;
	}

}
