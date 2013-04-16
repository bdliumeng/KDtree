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
	if(level%2==0)
	{	
		if((*node)==NULL)
		{
			(*node)= (struct node*)malloc(sizeof(struct node));
			(*node)->data1=key1;
			(*node)->data2=key2;
			(*node)->left=NULL;
			(*node)->right=NULL;
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
