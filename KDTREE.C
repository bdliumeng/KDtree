#include<stdio.h>
//#include<conio.h>
#include<stdlib.h>
#include<time.h>
struct node  
{
  int data1;
	int data2;
	struct node *left;
	struct node *right;
};
void insert(struct node** node,int key1,int key2,int level)
{
	//static int level=0;
	if(level%2==0)
	{	
		if((*node)==NULL)
		{
			(*node)= (struct node*)malloc(sizeof(struct node));
			(*node)->data1=key1;
			(*node)->data2=key2;
			(*node)->left=NULL;
			(*node)->right=NULL;
			//(*node)->level=0;
			//printf("Inserted Node with data %d   %d\n",(*node)->data1,(*node)->data2);
		}
		else if( (*node)->data1 > key1)
		{
			level++;
			insert((&(*node)->left),key1,key2,level);
		}
		else
		{
			level++;
			insert((&(*node)->right),key1,key2,level);
		}
	}
	else
	{
		if((*node)==NULL)
		{
			(*node)= (struct node*)malloc(sizeof(struct node));
			(*node)->data1=key1;
			(*node)->data2=key2;
			(*node)->left=NULL;
			(*node)->right=NULL;
			//(*node)->level=0;
			//printf("Inserted Node with data %d   %d\n",(*node)->data1,(*node)->data2);
		}
		else if( (*node)->data2 > key2)
		{
			level++;
			insert((&(*node)->left),key1,key2,level);
		}
		else
		{
			level++;
			insert((&(*node)->right),key1,key2,level);
		}
	}
		
}
void search_nearest_neighbour(struct node** node,int key1,int key2,int level)
{
	if(level%2==0)
	{	
		if((*node)==NULL)
		{
			(*node)= (struct node*)malloc(sizeof(struct node));
			(*node)->data1=key1;
			(*node)->data2=key2;
			(*node)->left=NULL;
			(*node)->right=NULL;
			//(*node)->level=0;
			printf("For Node of data %d   %d\n",(*node)->data1,(*node)->data2);
		}
		else if( (*node)->data1 > key1)
		{
			if( (*node)->left==NULL)
				printf("Nearest Neighbour is  %d   %d\n",(*node)->data1,(*node)->data2);
			level++;
			search_nearest_neighbour((&(*node)->left),key1,key2,level);
		}
		else
		{
			if( (*node)->right==NULL)
				printf("Nearest Neighbour is  %d   %d\n",(*node)->data1,(*node)->data2);
			level++;
			search_nearest_neighbour((&(*node)->right),key1,key2,level);
		}
	}
	else
	{
		if((*node)==NULL)
		{
			(*node)= (struct node*)malloc(sizeof(struct node));
			(*node)->data1=key1;
			(*node)->data2=key2;
			(*node)->left=NULL;
			(*node)->right=NULL;
			//(*node)->level=0;
			printf("For Node of data %d   %d\n",(*node)->data1,(*node)->data2);
		}
		else if( (*node)->data2 > key2)
		{	if( (*node)->left==NULL)
				printf("Nearest Neighbour is  %d   %d\n",(*node)->data1,(*node)->data2);
			level++;
			search_nearest_neighbour((&(*node)->left),key1,key2,level);
		}
		else
		{
			if( (*node)->right==NULL)
				printf("Nearest Neighbour is  %d   %d\n",(*node)->data1,(*node)->data2);
			level++;
			search_nearest_neighbour((&(*node)->right),key1,key2,level);
		}
	}
}
void inorder(struct node* node)
{
	if(node)
	{
		inorder(node->left);
		printf("Traversed Node is %d..%d\n",node->data1,node->data2);
		inorder(node->right);
	}
}
int main()
{
	struct node* root =NULL;
	/*insert(&root,20,30,0);
	insert(&root,25,40,0);
	insert(&root,30,25,0);
	insert(&root,26,45,0);
	insert(&root,15,60,0);
	insert(&root,18,40,0);
	insert(&root,19,70,0);
	insert(&root,50,30,0);
	inorder(root);
	search_nearest_neighbour(&root,50,50,0);
	return 0;*/
	clock_t start, end;
	double duration = 0,duration2=0;
	start=clock();
	long a=1000000,r,s;
	srand(time(NULL));
	while(a--)
	{	
		long r,s;
		r=rand();
		s=rand();
		insert(&root,r,s,0);
	}
	end=clock();
	duration = (((float)end - (float)start) / CLOCKS_PER_SEC ) ;  
	printf("TIme to Create is %f  Sec\n",duration);	
//	inorder(root);
	r=rand();
	s=rand();
	clock_t t1,t2;
	t1=clock();
	search_nearest_neighbour(&root,r,s,0);
	t2=clock();
	duration2 = ((((float)t2 - (float)t1) / CLOCKS_PER_SEC )*1000);  
	printf("TIme to Search is %f  sec\n",duration2);		
	return 0;
}

	
