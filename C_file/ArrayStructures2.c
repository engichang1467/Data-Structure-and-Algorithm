/*
 * ArrayStructure.c
 *
 * Class Description: Array ADT with some sorting algorithms
 *
 * Author: Michael Chang
 * Date:   April 22.2019
 * 
 * 
 * 
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


// Desc: declare an empty array and its size
int theArray[50] = {};
int arraySize = 10;


// Desc: it generates a random array
void generateRandomArray()
{
	for (int i = 0; i < arraySize; i++)
		theArray[i] = rand() % 50;  // the numbers from rand() are big
}


// Desc: print array horizontally
void printHorzArray(int i, int j)
{
	for (int n = 0; n < 51; n++)
		printf("-");

	printf("\n");

	for (int m = 0; m < arraySize; m++)
		printf("| %d  ", m);

	printf("|\n");

	for (int n = 0; n < 51; n++)
		printf("-");
	
	printf("\n");

	for (int n = 0; n < arraySize; n++)
		printf("| %d ", theArray[n]);
	
	printf("|\n");

	for (int n = 0; n < 51; n++)	
		printf("-");

	printf("\n");

    // ADDED FOR BUBBLE SORT
    if(j != -1)
    {
    	// Add the +2 to fix spacing
    	for(int k = 0; k < ((j*5)+2); k++)
    		printf(" ");
    	
    	printf("%d", j);
    }

    // Then add this code
    if(i != -1)
    {
    	// Add the -1 to fix spacing
    	for(int l = 0; l < (5*(i-j)-3); l++)	
			printf(" ");
    	printf("%d", i);
    }
    printf("\n");
}


// Desc: Linear search
const char* NONE = "NONE";
void linearSearchForValue(int value)
{
	bool valueInArray = false;
	const char* indexWithValue = NULL;
	int size = 0, indexCounted[size];

	for (int i = 0; i < arraySize; i++)
	{
		if(theArray[i] == value)
		{
			valueInArray = true;
			indexCounted[size] = i;
			size++;
		}
		printHorzArray(i, -1);
	}

	printf("The Value was Found in the Following: ");
	
	if(!valueInArray)
	{
		indexWithValue = NONE; 
		printf("%s \n", indexWithValue);
	}
	else
	{	
		for (int j = 0; j < size; j++)
			printf("%d ", indexCounted[j]);	
	}	
	
	printf("\n");
}


// Desc: it swaps value
void swapValues(int index1, int inedx2)
{
	int temp = theArray[index1];
	theArray[index1] = theArray[inedx2];
	theArray[inedx2] = temp;
}


// Desc: Bubble Sort
void bubbleSort()
{
	for (int i = arraySize - 1; i > 1; i--)
	{
		for (int j = 0; j < i; j++)
		{
			if (theArray[j] > theArray[j+1])
			{
				swapValues(j, j+1);
				printHorzArray(i, j);
			}
			printHorzArray(i, j);
		}
	}
}


// Desc: binary search
void binarySearchForValue(int value)
{
	int lowIndex = 0, highIndex = arraySize - 1;

	while (lowIndex <= highIndex)
	{
		int middleIndex = (highIndex + lowIndex) / 2;

		if (theArray[middleIndex] < value)
			lowIndex = middleIndex + 1;
		else if (theArray[middleIndex] > value)
			highIndex = middleIndex - 1;
		else
		{
			printf("\nFound a Match for %d at index %d\n", value, middleIndex);
			lowIndex = highIndex + 1;
		}
		printHorzArray(middleIndex, -1);
	}
}


// Desc: Selection sort
void selectionSort()
{
	for (int x = 0; x < arraySize; x++)
	{
		int minimum = x;

		for (int y = x; y < arraySize; y++)
		{
			if (theArray[minimum] > theArray[y])
				minimum = y;
		}
		swapValues(x, minimum);
		printHorzArray(x, -1);
	}
}


// Desc: insertion sort
void insetionSort()
{
	for (int i = 1; i < arraySize; i++)
	{
		int j = i, toInsert = theArray[i];

		while ((j > 0) && (theArray[j-1] > toInsert))
		{
			theArray[j] = theArray[j-1];
			j--;
			printHorzArray(i,j);
		}
		theArray[j] = toInsert;
		printHorzArray(i, j);
		printf("\n Array[i] = %d, Array[j] = %d, toInsert = %d\n", theArray[i], theArray[j], toInsert);
	}
}

int main()
{
	generateRandomArray();
	// linearSearchForValue(36);
	// bubbleSort();
	// binarySearchForValue(36);
	// selectionSort();
	insetionSort();
	

	return 0;
}
