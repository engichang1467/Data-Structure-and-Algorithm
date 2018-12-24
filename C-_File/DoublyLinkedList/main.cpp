#include <cstdlib>
#include <iostream>

using namespace std;

struct node
{
	int data;
	node* next;
	node* prev;
};

void PrintForward(node* head);
void PrintReverse(node* tail);

int main(int argc, char** argv)
{
	node* head;
	node* tail;
	node* n; // n = new

	n = new node;
	n->data = 1;
	n->prev = NULL;
	head = n;
	tail = n;

	// create a 2nd node
	n = new node;
	n->data = 2;
	n->prev = tail;
	tail->next = n; // link the previous node into this new node
	tail = n;

	n = new node;
	n->data = 3;
	n->prev = tail;
	tail->next = n; // link the 1st node into the 2nd node
	tail = n;

	n = new node;
	n->data = 4;
	n->prev = tail;
	tail->next = n; // link the 1st node into the 2nd node
	tail = n;
	tail->next = NULL; // make sure the last element's pointer points to null

	PrintForward(head);
	PrintReverse(tail);

	return 0;
}

void PrintForward(node* head)
{
	node* temp = head;

	while (temp != NULL)
	{
		cout << temp->data << " ";
		temp = temp->next;
	}
	cout << endl;
}

void PrintReverse(node* tail)
{
	node* temp = tail;

	while (temp != NULL)
	{
		cout << temp->data << " ";
		temp = temp->prev;
	}
	cout << endl;

}
