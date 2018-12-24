class BST
{
	private:
		struct node
		{
			int key;
			node* left;
			node* right;
		};

		node* root;

		void AddLeafPrivate(int key, node* Ptr);
		void PrintInOrderPrivate(node* Ptr);
		node* ReturnNodePrivate(int key, node* Ptr);
		int FindSmallestPrivate(node* Ptr);
		void RemoveNodePrivate(int key, node* parent);
		void RemoveRootMatch();
		void RemoveMatch(node* parent, node* match, bool left);
		node* CreateLeaf(int key);
		node* ReturnNode(int key); // helper function
		void RemoveSubtree(node* Ptr);

	public:

		BST();
		~BST();
		void AddLeaf(int key);
		void PrintInOrder();
		int ReturnRootKey();
		void PrintChildren(int key);
		int FindSmallest();
		void RemoveNode(int key);


};