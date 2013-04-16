#include<stdio.h>
#include<time.h>
#include "KDTREE.h"
int main(int argc,char **argv)
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
	long a=(atoi(argv[1]));
	long r,s;
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

	
