#include <cstdlib>
#include "list.h"

using namespace std;

// To compile the file: g++ -std=c++11 filename.cpp
int main( int argc, char** argv)
{
	List Mike;

	// test the addNode function
	Mike.AddNode(3);
	Mike.AddNode(5);
	Mike.AddNode(7);
	Mike.PrintList();

	// test the deleteNode function
	Mike.DeleteNode(3);
	Mike.PrintList();

	return 0;
}