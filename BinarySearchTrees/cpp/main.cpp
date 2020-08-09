#include <bits/stdc++.h>

#include "BinarySearchTree.h"

using namespace std;

int main(){

	I_Tree<int> *bst = new BinarySearchTree<int>();
	I_Tree<int> *other_bst = new BinarySearchTree<int>();

	bst->insert(5);
	bst->insert(10);
	bst->insert(4);
	bst->insert(11);
	bst->insert(3);
	bst->insert(2);
	bst->insert(6);

	other_bst->insert(5);
	other_bst->insert(10);
	other_bst->insert(4);
	other_bst->insert(11);
	other_bst->insert(3);
	other_bst->insert(2);
	other_bst->insert(6);

	bst->traversal();
	cout << "\n";

	cout << std::boolalpha << "Equals: " << bst->compareTo(other_bst) << endl;

	cout << bst->find(10) << endl;
	cout << "Size: " << bst->size() << endl;
	cout << "Height: " << bst->height() << endl;
	cout << "Max: " << bst->getMax() << endl;
	cout << "Min: " << bst->getMin() << endl;

	bst->remove(10);

	cout << bst->find(10) << endl;
	bst->traversal();
	cout << "\n";

	bst->remove(5);
	
	cout << bst->find(2) << endl;    
	bst->traversal();
	cout << "\n";

	return 0;
}