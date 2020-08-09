#ifndef __I_TREE_H__
#define __I_TREE_H__

#include "Node.h"

template <typename T>
class I_Tree {
	public:
		virtual Node<T>* getRoot() = 0;

		virtual void insert(T data) = 0;
		virtual void remove(T data) = 0;
		virtual void traversal() = 0;
		virtual T getMax() = 0;
		virtual T getMin() = 0;
	
		// Tree Algorithms
		// virtual T getKSmallest(int k) = 0;
		// virtual T LCA(T oneValue, T otherValue) = 0;
		virtual int height() = 0; // maxDepth of a tree
		virtual int size() = 0;   // number of nodes
		virtual bool compareTo(I_Tree<T> *anotherTree) = 0; // implement operator== overload
		// virtual bool isSymmetric(I_Tree<T> anotherTree) = 0;
		// virtual bool hasPathSum(int sum) = 0;
		// virtual bool isBst() = 0;

		// Search - it will be a binary search
		virtual bool find(T data) = 0; 
};

#endif //__I_TREE_H__