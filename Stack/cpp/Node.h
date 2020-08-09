#ifndef __NODE_H__
#define __NODE_H__

template <typename T>
class Node {
    private:
        T data;
        Node<T> *nextNode;

    public:
        Node(T);

        T getData();
        void setData(T data);
        Node<T>* getNextNode();
        void setNextNode(Node<T> *nextNode);
};

#include "Node.cpp"

#endif // __NODE_H__