#ifndef __BST_H__
#define __BST_H__

#include "I_Tree.h"
#include "Node.h"

template <typename T>
class BinarySearchTree: public I_Tree<T> {
	private:
		Node<T> *root;

		// You shouldn't use this method in the main.cpp, i haven't implemented this method in a abstract 
		// class because this would made the things a little bit complex, and this code is just for 
		// understand the basics concepts about BST's
		Node<T>* getRoot(); 

		Node<T>* insert(Node<T> *node, T data);
		Node<T>* remove(Node<T> *node, T data);
		T max_elem(Node<T> *node);
		T min_elem(Node<T> *node);

		int size(Node<T> *node);
		int height(Node<T> *node);
		bool equals(Node<T> *firstRoot, Node<T> *secondRoot);
		// ** Traversals Types ** -> Uncomment what type of traversal you want in "traversal()" method
		// 1) BFS
		// void levelOrder(Node<T> *root);

		// // 2) DFS
		void inOrder(Node<T> *root);
		void preOrder(Node<T> *root);
		void postOrder(Node<T> *root);
		
		bool binarySearch(Node<T> *root, T data);

	public:
		BinarySearchTree();
		
		virtual void insert(T data) override;
		virtual void remove(T data) override;
		virtual void traversal() override;
		virtual T getMax() override;
		virtual T getMin() override;

		virtual int height() override; // maxDepth of a tree
		virtual int size() override;   // number of nodes
		virtual bool compareTo(I_Tree<T> *anotherTree) override; // implement operator== overload

		virtual bool find(T data) override; 
};

#include "BinarySearchTree.cpp"

#endif // __BST_H__