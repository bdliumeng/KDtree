import java.util.*;
public class KDTREE
{

  Node root;
	public KDTREE()
	{
		root=null;
	}
	public Node getRoot(){return root;}
	
	public void insert(int key1,int key2,int level)
	{
		Node n1=new Node(key1,key2,level);

		if(root ==null)
		{
			root=n1;
		}
		else
		{
			Node parIns=root;
			Node insNode=root;
			while(insNode!=null)
			{
				parIns=insNode;
				if(level%2==0)
				{				

					if(key1<insNode.getKey1())
					{	
						level++;
						insNode=insNode.getLeft();	
					}
					else
					{
						level++;
						insNode=insNode.getRight();
					}
				}
				else
				{
					if(key2<insNode.getKey2())
					{	
						level++;
						insNode=insNode.getLeft();	
					}
					else
					{
						level++;
						insNode=insNode.getRight();
					}
				}				
			}
		if(level%2==1)
		{
			if(key1<parIns.getKey1())
			{
				parIns.setLeft(n1);
			}
			else
			{
				parIns.setRight(n1);
			}
		}
		else
		{	if(key2<parIns.getKey2())
			{
				parIns.setLeft(n1);
			}
			else
			{
				parIns.setRight(n1);
			}
		}
		}
	}
	public void printInorder(Node n)
	{
		if(n!=null)
		{
			printInorder(n.getLeft());
			n.print();
			printInorder(n.getRight());
		}
	}

	public void search_nearest_neighbour(int key1,int key2,int level)
	{
		Node n1=new Node(key1,key2,level);

		if(root ==null)
		{
			root=n1;
		}
		else
		{
			Node parIns=root;
			Node insNode=root;
			while(insNode!=null)
			{
				parIns=insNode;
				if(level%2==0)
				{				

					if(key1<insNode.getKey1())
					{	
						level++;
						insNode=insNode.getLeft();	
					}
					else
					{
						level++;
						insNode=insNode.getRight();
					}
				}
				else
				{
					if(key2<insNode.getKey2())
					{	
						level++;
						insNode=insNode.getLeft();	
					}
					else
					{
						level++;
						insNode=insNode.getRight();
					}
				}				
			}
		System.out.println("For Node of Data:"+key1+","+key2);
		System.out.println("Nearest Neighbour is:"+parIns.getKey1()+","+parIns.getKey2());
		}

	}	
	public static void main(String args[])
	{
		KDTREE b1=new KDTREE();
		/*b1.insert(20,30,0);
		b1.insert(25,40,0);
		b1.insert(30,25,0);
		b1.insert(26,45,0);
		b1.insert(50,50,0);
		b1.insert(15,60,0);
		b1.insert(18,40,0);
		b1.insert(19,70,0);*/
		Scanner in=new Scanner(System.in);
		System.out.println("Enter No. of Nodes");
		int a=in.nextInt();
		Random rn=new Random();
		//int a=1000000;
		long starttime= System.nanoTime();
		while(a!=0)
		{
			int r=rn.nextInt(1000000);
			int s=rn.nextInt(1000000);
			b1.insert(r,s,0);
			//System.out.println("Random Number is:"+r);
			a--;
		}
		//b1.printInorder(b1.getRoot());
		long endtime=System.nanoTime();
		double diff=(endtime-starttime)/1000000000.0;
		System.out.println("Time To Create KDTREE is:"+diff+" "+"seconds");
		int r=rn.nextInt(1000000);
		int s=rn.nextInt(1000000);
		starttime= System.nanoTime();
		//b1.printInorder(b1.getRoot());
		b1.search_nearest_neighbour(r,s,0);
		endtime=System.nanoTime();
		diff=(endtime-starttime)/1000000.0;
		System.out.println("Time to Search in KDTREE is:"+ diff+" "+"millisecond");
	}
}
