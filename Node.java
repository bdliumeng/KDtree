
public class Node
{
  private	Node left;
	private Node right;
	private int key1;
	private int key2;

	public Node(int key1,int key2,int level)
	{
		this.key1=key1;
		this.key2=key2;
		left=null;
		right=null;
	}
	public void setRight(Node right)
	{
		this.right=right;
	}	
	public void setLeft(Node left)
	{
		this.left=left;
	}	
	public Node getLeft(){return left;}
	public Node getRight(){return right;}
	//public void setKey(int k1,int k2){this.key1=k1,this.key2=k2;}
	public int getKey1(){return key1;}
	public int getKey2(){return key2;}
	public void print()
	{
		
		System.out.println("Keys are:"+getKey1()+","+getKey2());
	}
}
