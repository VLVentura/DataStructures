#ifndef __STACK_H__
#define __STACK_H__

#include "Node.h"

template <typename T>
class Stack {
    private:
        Node<T> *root;
        int stackSize;

    public:
        void push(T data);
        T pop();
        T top();
        int size();
        bool empty();
};

#include "Stack.cpp"

#endif // __STACK_H__