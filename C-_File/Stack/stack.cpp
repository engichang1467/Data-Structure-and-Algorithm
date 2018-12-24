#include <iostream>
#include <cstdlib>

#include "stack.h"

using namespace std;


// constructor
Stack::Stack()
{
	stackPtr = NULL;
}

// deconstructor
Stack::~Stack()
{
	item* p1;
	item* p2;

	p1 = stackPtr;
	while (p1 != NULL)
	{
		p2 = p1;
		p1 = p1->prev;
		p2->prev = NULL;
		delete p2;
	}
}

void Stack::Push(string name, int value)
{
	item* n = new item;

	n->name = name;
	n->value = value;

	if (stackPtr == NULL)
	{
		// put the new stack as the first one
		stackPtr = n;
		stackPtr->prev = NULL;
	}
	else
	{
		n->prev = stackPtr;
		stackPtr = n;
	}
}

void Stack::ReadItem(item* r)
{
	cout << "--------------\n";
	cout << "name:  " << r->name << endl;
	cout << "value: " << r->value << endl;
	cout << "--------------\n";
}

void Stack::Pop()
{
	if (stackPtr == NULL)
	{
		cout << "There's nothing on the stack" << endl;
	}
	else
	{
		item* p = stackPtr;
		ReadItem(p);
		stackPtr = stackPtr->prev;
		p->prev = NULL;
		delete p;
	}
}

// This print the entire data of the stack
void Stack::Print()
{
	item* p = stackPtr;

	while (p != NULL)
	{
		ReadItem(p);
		p = p->prev;
	}
}







