#include <iostream>
#include "LinkedList.h"

template <typename T>
LinkedList<T>::LinkedList()
    : sizeOfList{0}, root{nullptr} {
}

template <typename T>
LinkedList<T>::LinkedList(T data){
    this->sizeOfList = 1;

    Node<T> *newNode = new Node<T>(data);
    this->root = newNode;

    delete newNode;
}


template <typename T>
LinkedList<T>::~LinkedList(){
}

template <typename T>
void LinkedList<T>::insert(T data){
    ++this->sizeOfList;
    Node<T> *newNode = new Node<T>(data);

    if(this->root == nullptr){
        this->root = newNode;    
    }
    else{
        newNode->setNextNode(this->root);
        this->root = newNode;
    }
}

template <typename T>
void LinkedList<T>::remove(T data){
    if(this->root == nullptr){
        return;
    }

    --this->sizeOfList;
    if(this->root->getData() == data){
        this->root = this->root->getNextNode();
    }
    else{
        remove(data, this->root, this->root->getNextNode());
    }
}

template <typename T>
void LinkedList<T>::remove(T data, Node<T> *previousNode, Node<T> *actualNode){
    if(actualNode == nullptr){
        return;
    }
    if(actualNode->getData() == data){
        previousNode->setNextNode(actualNode->getNextNode());
        delete actualNode;
    }
    else{
        remove(data, actualNode, actualNode->getNextNode());
    }
}

template <typename T>
void LinkedList<T>::traverseList(){
    traverseList(this->root);
}

template <typename T>
void LinkedList<T>::traverseList(Node<T> *node){
    if(node == nullptr){
        std::cout << "NULL";
        return;
    }
    std::cout << node->getData() << " -> ";
    traverseList(node->getNextNode());
}

template <typename T>
int LinkedList<T>::size(){
    return this->sizeOfList;
}

template <typename T>
bool LinkedList<T>::empty(){
    if(this->root == nullptr){
        return true;
    }
    return false;
}

template <typename T>
T LinkedList<T>::middle(){
    Node<T> *faster = root;
    Node<T> *slower = root;

    while(faster->getNextNode() != nullptr && faster->getNextNode()->getNextNode() != nullptr){
        faster = faster->getNextNode()->getNextNode();
        slower = slower->getNextNode();
    }

    return slower->getData();
}

template <typename T>
void LinkedList<T>::reverse(){
    Node<T> *nextNode = nullptr;
    Node<T> *previousNode = nullptr;
    Node<T> *currentNode = this->root;

    while(currentNode != nullptr){
        nextNode = currentNode->getNextNode();
        currentNode->setNextNode(previousNode);

        previousNode = currentNode;
        currentNode = nextNode;
    }

    this->root = previousNode;
}
