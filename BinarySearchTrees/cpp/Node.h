#ifndef __NODE_H__
#define __NODE_H__

template <typename T>
class Node {
    private:
        T data;
        Node<T> *leftNode;
        Node<T> *rightNode;
    
    public:
        Node(T data);

        T getData();
        void setData(T data);
        Node<T>* getLeftNode();
        void setLeftNode(Node<T> *node);
        Node<T>* getRightNode();
        void setRightNode(Node<T> *node);
};

#include "Node.cpp"

#endif // __NODE_H__