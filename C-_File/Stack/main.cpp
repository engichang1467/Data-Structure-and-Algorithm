#include <cstdlib>
#include <iostream>

#include "stack.h"

using namespace std;

// to test the function: g++ -std=c++11 main.cpp stack.cpp
int main(int argc, char** argv)
{
	Stack Mike;

	// Test push function
	Mike.Push("Mike", 3);
	Mike.Push("Coffee", 0);
	Mike.Push("Lunch", 0);
	Mike.Push("Video", 6);
	Mike.Print();

	// Test pop function
	cout << "\n\nPopping" << endl;	
	Mike.Pop();
	cout << "Popping" << endl;	
	Mike.Pop();
	cout << "Popping" << endl;	
	Mike.Pop();
	cout << "Popping" << endl;	
	Mike.Pop();
	cout << "Popping" << endl;	
	Mike.Pop();

	// test if we can create a new stack
	cout << "\n\nNew stack\n";
	Mike.Push("Books", 100);
	Mike.Push("Pencils", 5);
	Mike.Print();


}