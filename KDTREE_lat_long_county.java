import java.io.*;
import au.com.bytecode.opencsv.CSVReader;
import java.util.*;
public class KDTREE
{

    Node root;
	public KDTREE()
	{
		root=null;
	}	
	public Node getRoot(){return root;}

	public void insert(double latitude,double longitude,int level,String county,String state )
	{
		Node n1=new Node(latitude,longitude,level,county,state);

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

					if(latitude<insNode.getlatitude())
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
					if(longitude<insNode.getlongitude())
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
				if(latitude<parIns.getlatitude())
				{
					parIns.setLeft(n1);
				}
				else
				{
					parIns.setRight(n1);
				}
			}
			else
			{	
				if(longitude<parIns.getlongitude())
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

public void search_nearest_neighbour(double latitude,double longitude,int level)
{
	Node n1=new Node(latitude,longitude,level);

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

				if(latitude<insNode.getlatitude())
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
				if(longitude<insNode.getlongitude())
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
		System.out.println("For Node of Data:"+latitude+","+longitude);
		System.out.println("Nearest Neighbour is:"+parIns.getlatitude()+","+parIns.getlongitude()+","+parIns.getcounty() 			+","+parIns.getstate());
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
	System.out.println("Enter Latitude of Node to be Searched");
	double lat1=in.nextDouble();
	System.out.println("Enter Longitude of Node to be Searched");
	double long1=in.nextDouble();
//Random rn=new Random();
//int a=1000000;
	long starttime = System.nanoTime();
	try
	{	
		String fileName = "County_lat_long.csv";
		CSVReader reader = new CSVReader(new FileReader(fileName ));
		String[] header = reader.readNext();
		for(int i=0;i<3140;i++)
		{
			String[] line = reader.readNext();
			//while(line[1] == null ||line[1].trim().equals(""))
			//	line = reader.readNext();
//System.out.println("data is:"+line[0]);

			double latitude=Double.parseDouble(line[2]);
			double longitude=Double.parseDouble(line[3]);
			//double zipcode=Double.parseDouble(line[0]);
			String county=line[0];
			String state=line[1];
			b1.insert(latitude,longitude,0,county,state);
//System.out.println("Random Number is:"+r);
		}
	}
	catch(IOException e)
	{
		System.out.println("IOException: ");
             	e.printStackTrace();
	}	
//b1.printInorder(b1.getRoot());
	long endtime=System.nanoTime();
	double diff=(endtime-starttime)/1000000000.0;
	System.out.println("Time To Create KDTREE is:"+diff+" "+"seconds");
//double r=18.523;
//double s=-66.4555;
	starttime= System.nanoTime();
//b1.printInorder(b1.getRoot());
	b1.search_nearest_neighbour(lat1,long1,0);
	endtime=System.nanoTime();
	diff=(endtime-starttime)/1000000.0;
	System.out.println("Time to Search in KDTREE is:"+ diff+" "+"millisecond");
	}
}
