#include "Node.h"

template <typename T>
Node<T>::Node(T data){
    this->data = data;
    this->nextNode = nullptr;
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
Node<T>* Node<T>::getNextNode(){
    return this->nextNode;
}

template <typename T>
void Node<T>::setNextNode(Node<T> *nextNode){
    this->nextNode = nextNode;
}