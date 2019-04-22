/*
 * ArrayStructure.c
 *
 * Class Description: Array ADT
 *
 * Author: Michael Chang
 * Date:   April 20.2019
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


// Desc: Print the array
void printArray() 
{
	printf("----------\n");

	// prin out all my different values
	for (int i = 0; i < arraySize; i++) 
	{
		printf("| %d | ", i);
		printf("%d |\n", theArray[i]);
		printf("----------\n");
	}
}

// Desc: it gets our value from the index
int getValueAtIndex(int index) 
{
	if(index < arraySize)
		printf("%d\n", theArray[index]);
	return 0;
}


// Desc: To find out if an array contains a value
bool doesArrayContainThisValue(int searchValue) 
{
	bool valueInArray = false;

	for (int i = 0; i < arraySize; i++)
	{		
		if(theArray[i] == searchValue)
			valueInArray = true;
	}
	return valueInArray;
}


// Desc: Deleting index and then moving all the other values up
void deleteIndex(int index) 
{
	if(index < arraySize)
	{
		for (int i = index; i < (arraySize - 1); i++)
			theArray[i] = theArray[i+1];
		arraySize--;
	}
}

// Desc: insert the value
void insertValue(int value)
{
	if(arraySize < 50)
	{
		theArray[arraySize] = value;
		arraySize++;
	}
}

// Linear Search
const char* NONE = "NONE";
void linearSearchForValue(int value)
{
	bool valueInArray = false;
	const char* indexWithValue = NULL;
	printf("The Value was Found in the Following: ");

	for (int i = 0; i < arraySize; i++)
	{
		if(theArray[i] == value)
		{
			valueInArray = true;
			printf("%d ", i);
		}
	}

	if(!valueInArray)
	{
		indexWithValue = "NONE"; 
		printf("%s \n", indexWithValue);
	}
	printf("\n");
}

int main() 
{
	generateRandomArray();
	printArray();

	getValueAtIndex(3);
	printf("%d\n", doesArrayContainThisValue(36));  // 1 = true; 0 = false

	deleteIndex(4);
	printArray();

	insertValue(17);
	printArray();

	// printf("%c\n", linearSearchForValue(36));
	linearSearchForValue(36);

	return 0;
}
