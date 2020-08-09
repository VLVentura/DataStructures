#include "Node.h"

template <typename T>
Node<T>::Node(T data){
	this->leftNode = nullptr;
	this->data = data;
	this->rightNode = nullptr;
}

template <typename T>
T Node<T>::getData(){
	return this->data;
}

template <typename T>
void Node<T>::setData(T data){
	this->data = data;
}

template <typename T>
Node<T>* Node<T>::getLeftNode(){
	return this->leftNode;
}

template <typename T>
void Node<T>::setLeftNode(Node<T> *node){
	this->leftNode = node;
}

template <typename T>
Node<T>* Node<T>::getRightNode(){
	return this->rightNode;
}

template <typename T>
void Node<T>::setRightNode(Node<T> *node){
	this->rightNode = node;
}