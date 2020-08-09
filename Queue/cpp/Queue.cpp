#include "Queue.h"

template <typename T>
Queue<T>::Queue()
    : firstNode{nullptr}, lastNode{nullptr}, queueSize{0}{
}

template <typename T>
void Queue<T>::push_back(T data){
    ++this->queueSize;

    Node<T> *previousLastNode = lastNode;
    lastNode = new Node<T>(data);

    if(this->firstNode == nullptr){
        this->firstNode = this->lastNode;
    }
    else{
        previousLastNode->setNextNode(lastNode);
    }
}

template <typename T>
T Queue<T>::pop_front(){
    T dataToPop = this->firstNode->getData();

    Node<T> *temp = this->firstNode;
    this->firstNode = this->firstNode->getNextNode();
    delete temp;

    --this->queueSize;
    return dataToPop;
}

template <typename T>
T Queue<T>::front(){
    return this->firstNode->getData();
}

template <typename T>
bool Queue<T>::empty(){
    return this->queueSize == 0;
}

template <typename T>
int Queue<T>::size(){
    return this->queueSize;
}