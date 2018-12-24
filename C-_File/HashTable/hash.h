#include <string>

using namespace std;

#ifndef HASH_H
#define HASH_H

class hashT
{
	private:
		static const int tableSize = 4;

		struct item
		{
			string name;
			string drink;
			item* next;
		};

		item* HashTable[tableSize];

	public:
		hashT();
		// it'll take the string and use it change it into integer of the index number
		int Hash(string key); 
		void AddItem(string name, string drink);
		int NumberOfItemsInIndex(int index);
		void PrintTable();
		void PrintItemsInIndex(int index); // Finding the multiple stuff in a hash table
		void FindDrink(string name); // search through the hash table
		void RemoveItem(string name);

};


#endif
