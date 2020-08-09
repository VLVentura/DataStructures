#include "Stack.h"

template <typename T>
void Stack<T>::push(T data){
    ++this->stackSize;

    Node<T> *newNode = new Node<T>(data);
    newNode->setNextNode(root);
    root = newNode;
}

template <typename T>
T Stack<T>::pop(){
    T dataToReturn = this->root->getData();

    Node<T> *temp = this->root;
    this->root = this->root->getNextNode();
    delete temp;

    --this->stackSize;
    return dataToReturn;
}

template <typename T>
T Stack<T>::top(){
    return this->root->getData();
}

template <typename T>
bool Stack<T>::empty(){
    return this->stackSize == 0;
}

template <typename T>
int Stack<T>::size(){
    return this->stackSize;
}