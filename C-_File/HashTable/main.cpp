#include <cstdlib>
#include <iostream>
#include <string>

#include "hash.h"

using namespace std;

int main(int argc, char** argv)
{
	hashT Hashy;
	string name = "";

	Hashy.AddItem("Mike", "Locha");
	Hashy.AddItem("Kim", "Iced Mocha");
	Hashy.AddItem("Emma", "Strawberry Smoothy");
	Hashy.AddItem("Annie", "Hot Chocolate");
	Hashy.AddItem("Sarah", "Passion Tea");
	Hashy.AddItem("Pepper", "Caramel Mocha");
	Hashy.AddItem("Paul", "Chai Tea");
	Hashy.AddItem("Steve", "Dixon Cider");
	Hashy.AddItem("Bill", "Root Beer");
	Hashy.AddItem("Marie", "Skinny Latte");
	Hashy.AddItem("Susan", "Water");
	Hashy.AddItem("Joe", "Green Tea");

	//Hashy.PrintTable();

	Hashy.PrintItemsInIndex(2);

	// To search through the hash table
	while(name != "exit")
	{
		cout << "Search for ";
		cin >> name;
		if (name != "exit")
			Hashy.FindDrink(name);
	}

	// To remove stuff
	while(name != "quit")
	{
		cout << "Remove ";
		cin >> name;
		if (name != "exit")
		{
			Hashy.RemoveItem(name);
		}
	}

	//Hashy.PrintTable();
	Hashy.PrintItemsInIndex(2);

	return 0;
}