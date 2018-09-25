#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


int theArray[50] = {};
int arraySize = 10;

void generateRandomArray()
{
	for (int i = 0; i < arraySize; i++){
		theArray[i] = rand() % 50;  // the numbers from rand() are big
	}	
}

const char* NONE = "NONE";
char linearSearchForValue(int value)
{
	bool valueInArray = false;
	//const char* indexWithValue = NULL;
	const char* indexWithValue[6] = {};
	

	for (int i = 0; i < arraySize; i++)
	{
		if(theArray[i] == value)
		{
			valueInArray = true;
			indexWithValue[6] += i;

			// in java: indexsWithValue += i + " ";
			// fix this part in c
		}
		printHorzArray(i, -1);
	}

	if(!valueInArray)
	{
		indexWithValue[6] = NONE; 
		printf("%s \n", indexWithValue[6]);
	}
	printf("The Value was Found in the Following: %s ", indexWithValue[6]);
	printf("\n");
	return indexWithValue[6];
}

void printHorzArray(int i, int j)
{
	for (int n = 0; n < 51; n++)
	{
		printf("-");
	}
	printf("\n");

	for (int n = 0; n < arraySize; n++)
	{
		printf("| %d  ", n);
	}
	printf("|\n");

	for (int n = 0; n < 51; n++)
	{
		printf("-");
	}
	printf("\n");

	for (int n = 0; n < arraySize; n++)
	{
		printf("| %d ", theArray[n]);
	}
	printf("|\n");

	for (int n = 0; n < 51; n++)
	{
		printf("-");
	}
	printf("\n");

	// End of first part

    // ADDED FOR BUBBLE SORT
    //int j;
    if(j != -1)
    {
    	// Add the +2 to fix spacing
    	for(int k = 0; k < ((j*5)+2); k++)
    	{
    		printf(" ");
    	}
    	printf("%d", j);
    }

    // Then add this code
    //int i;
    if(i != -1)
    {
    	// Add the -1 to fix spacing
    	for(int l = 0; l < (5*(i-j)-1); l++)
    	{
    		printf(" ");
    	}
    	printf("%d", i);
    }
    printf("\n");
}

int main()
{
	generateRandomArray();
	linearSearchForValue(36);
	

	return 0;
}
