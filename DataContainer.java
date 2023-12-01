
public class DataContainer 
{
	private int data;
	private DataContainer left;
	private DataContainer right;
	//private int count;
	
	public DataContainer(int d)
	{
		data = d;
		left = null;
		right = null;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	
	public void setLeft(int l)
	{
		left = new DataContainer(l);
	}
	
	public void setRight(int r)
	{
		right = new DataContainer(r);
	}
	
	public int getData()
	{
		return data;
	}
	
	public DataContainer getLeft()
	{
		return left;
	}
	
	public DataContainer getRight()
	{
		return right;
	}
	
	public boolean containsLeft()
	{
		return left != null;
	}
	
	public boolean containsRight()
	{
		return right != null;
	}
	
}
