#ifndef __LINKED_LIST_H__
#define __LINKED_LIST_H__

#include "I_List.h"
#include "Node.h"

template<typename T>
class LinkedList: public I_List<T>{
    private:
        Node<T> *root;
        int sizeOfList;
        
        void remove(T data, Node<T> *previousNode, Node<T> *actualNode);
        void traverseList(Node<T> *node);

    public:
        LinkedList();
        LinkedList(T data);
        virtual ~LinkedList();

        virtual void insert(T data) override;
        virtual void remove(T data) override;
        virtual void traverseList() override;
        virtual int size() override;
        virtual bool empty() override;

        T middle();
        void reverse();
};

#include "LinkedList.cpp"

#endif // __LINKED_LIST_H__