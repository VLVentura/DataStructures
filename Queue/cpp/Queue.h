#ifndef __QUEUE_H__
#define __QUEUE_H__

#include "Node.h"

template <typename T>
class Queue {
    private:
        Node<T> *firstNode;
        Node<T> *lastNode;
        int queueSize;
    
    public:
        Queue();

        void push_back(T data);
        T pop_front();
        T front();
        int size();
        bool empty();
};

#include "Queue.cpp"

#endif // __QUEUE_H__