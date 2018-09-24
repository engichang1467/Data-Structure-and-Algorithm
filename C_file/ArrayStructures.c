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

// Print my array
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

// How to get our value from the index?
int getValueAtIndex(int index) 
{
	if(index < arraySize)
		printf("%d\n", theArray[index]);

	return 0;
}

// To find out if an array contains a value
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

// Deleting index and then moving all the other values up
void deleteIndex(int index) 
{
	if(index < arraySize)
	{
		for (int i = index; i < (arraySize - 1); i++)
		{
			theArray[i] = theArray[i+1];
		}
		arraySize--;
	}
}

// How to insert a value?
void insertValue(int value)
{
	if(arraySize < 50)
	{
		theArray[arraySize] = value;
		arraySize++;
	}
}

// Linear Search
char linearSearchForValue(int value)
{
	bool valueInArray = false;
	char indexWithValue;
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
		printf("None");
	}
	printf("\n");
	return indexWithValue;
}

int main() {

	generateRandomArray();
	printArray();

	getValueAtIndex(3);
	printf("%d\n", doesArrayContainThisValue(36));  // 1 = true; 0 = false

	deleteIndex(4);
	printArray();

	insertValue(17);
	printArray();

	printf("%c\n", linearSearchForValue(36));

	return 0;
}
