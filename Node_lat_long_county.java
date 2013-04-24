public class Node
{
    private	Node left;
	private Node right;
	private double latitude;
	private double longitude;
	//private double zipcode;
	private String county;
	private	String state;

public Node(double latitude,double longitude,int level,String county,String state)
{
	this.latitude=latitude;
	this.longitude=longitude;
	//this.zipcode=zipcode;
	this.county=county;
	this.state=state;
	left=null;
	right=null;
}
public Node(double latitude,double longitude,int level)
{
	this.latitude=latitude;
	this.longitude=longitude;
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
public double getlatitude(){return latitude;}
public double getlongitude(){return longitude;}
//public double getzipcode(){return zipcode;}
public String getcounty(){return county;}
public String getstate(){return state;}
public void print()
{
	System.out.println("Keys are:"+getlatitude()+","+getlongitude());
}
}

