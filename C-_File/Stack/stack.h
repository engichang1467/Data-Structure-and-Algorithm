#ifndef STACK_H
#define STACK_H

#include <string>

using namespace std;

class Stack
{
	private:
		// create an item
		struct item
		{
			string name;
			int value;
			item* prev; // pointing to the previous item
		};

		// stack pointer
		item* stackPtr;

	public:
		void Push(string name, int value);
		void Pop();
		void ReadItem(item* r);
		void Print();

		Stack(); // constructor
		~Stack(); // destructor
};

#endif
