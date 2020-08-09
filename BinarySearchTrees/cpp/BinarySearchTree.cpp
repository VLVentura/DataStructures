#include <iostream>
#include "BinarySearchTree.h"

template <typename T>
BinarySearchTree<T>::BinarySearchTree()
	: root{nullptr} {
}

template <typename T>
Node<T>* BinarySearchTree<T>::getRoot(){
	return this->root;
}

template <typename T>
void BinarySearchTree<T>::insert(T data){
	this->root = insert(this->root, data);
}

template <typename T>
Node<T>* BinarySearchTree<T>::insert(Node<T> *node, T data){
	if(node == nullptr){
		node = new Node<T>(data);
	}
	else {
		if(data < node->getData()){
			node->setLeftNode(insert(node->getLeftNode(), data));
		}
		else{
			node->setRightNode(insert(node->getRightNode(), data));
		}
	}

	return node;
}


template <typename T>
void BinarySearchTree<T>::remove(T data){
	this->root = remove(this->root, data);
}

template <typename T>
Node<T>* BinarySearchTree<T>::remove(Node<T> *node, T data){
	if(node == nullptr){
		return node;
	}

	// Smaller
	if(data < node->getData()){
		node->setLeftNode(remove(node->getLeftNode(), data));
	}
	// Greater
	else if(data > node->getData()){
		node->setRightNode(remove(node->getRightNode(), data));
	}
	// Equal - time to remove
	else{
		// Case 1: Has no child - is a leaf
		if(node->getLeftNode() == nullptr && node->getRightNode() == nullptr){
			delete node;
			node = nullptr;
		}
		// Case 2: Has 1 childs
		else if(node->getLeftNode() == nullptr){
			Node<T> *temp = node;
			node = node->getRightNode();
			delete temp;
		}
		// Case 3: Has 3 childs
		else if(node->getRightNode() == nullptr){
			Node<T> *temp = node;
			node = node->getLeftNode();
			delete temp;
		}
		else{
			T maxElement = max_elem(node->getLeftNode());
			node->setData(maxElement);
			node->setLeftNode(remove(node->getLeftNode(), maxElement));
		}
	}

	return node;
}

template <typename T>
void BinarySearchTree<T>::traversal(){
	inOrder(this->root);
	// preOrder(this->root);
	// postOrder(this->root);
}

template <typename T>
void BinarySearchTree<T>::inOrder(Node<T> *root){
	if(root == nullptr){
		return;
	}
	inOrder(root->getLeftNode());
	std::cout << root->getData() << " ";
	inOrder(root->getRightNode());
}

template <typename T>
void BinarySearchTree<T>::preOrder(Node<T> *root){
	if(root == nullptr){
		return;
	}
	std::cout << root->getData() << " ";
	preOrder(root->getLeftNode());
	preOrder(root->getRightNode());
}

template <typename T>
void BinarySearchTree<T>::postOrder(Node<T> *root){
	if(root == nullptr){
		return;
	}
	postOrder(root->getLeftNode());
	postOrder(root->getRightNode());
	std::cout << root->getData() << " ";
}

template <typename T>
T BinarySearchTree<T>::getMax(){
	if(this->root->getRightNode() == nullptr){
		return this->root->getData();
	}
	return max_elem(this->root);
}

template <typename T>
T BinarySearchTree<T>::max_elem(Node<T> *node){
	if(node->getRightNode() == nullptr){
		return node->getData();
	}

	return max_elem(node->getRightNode());
}

template <typename T>
T BinarySearchTree<T>::getMin(){
	if(this->root->getLeftNode() == nullptr){
		return this->root->getData();
	}
	return min_elem(this->root);
}

template <typename T>
T BinarySearchTree<T>::min_elem(Node<T> *node){
	if(node->getLeftNode() == nullptr){
		return node->getData();
	}
	
	return min_elem(node->getLeftNode());
}

template <typename T>
bool BinarySearchTree<T>::find(T data){
	return binarySearch(this->root, data);
}

template <typename T>
bool BinarySearchTree<T>::binarySearch(Node<T> *root, T data){
	if(root == nullptr){
		return false;
	}

	if(data < root->getData()){
		return binarySearch(root->getLeftNode(), data);
	}
	else if(data > root->getData()){
		return binarySearch(root->getRightNode(), data);
	}
	else{
		return root->getData() == data;
	}
}

template <typename T>
int BinarySearchTree<T>::height(){
	return height(this->root);
}

template <typename T>
int BinarySearchTree<T>::height(Node<T> *node){
	if(node == nullptr){
		return 0;
	}

	return std::max(height(node->getLeftNode()), height(node->getRightNode())) + 1;
}

template <typename T>
int BinarySearchTree<T>::size(){
	return size(this->root);
}

template <typename T>
int BinarySearchTree<T>::size(Node<T> *node){
	if(node == nullptr){
		return 0;
	}
	return size(node->getLeftNode()) + size(node->getRightNode()) + 1;
}

template <typename T>
bool BinarySearchTree<T>::compareTo(I_Tree<T> *anotherTree) {
	return equals(this->root, anotherTree->getRoot());
}

template <typename T>
bool BinarySearchTree<T>::equals(Node<T> *firstRoot, Node<T> *secondRoot){
	if(firstRoot == nullptr || secondRoot == nullptr){
		return firstRoot == secondRoot;
	}
	if(firstRoot->getData() != secondRoot->getData()){
		return false;
	}

	return equals(firstRoot->getLeftNode(), secondRoot->getLeftNode()) &&
			equals(firstRoot->getRightNode(), secondRoot->getRightNode());
}