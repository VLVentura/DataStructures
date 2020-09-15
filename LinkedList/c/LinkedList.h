#ifndef __LINKED_LIST_H__
#define __LINKED_LIST_H__

struct node{
    int data;
    struct node *nextNode;
};

typedef struct node Node;

Node* createList();
Node* insertAtBegin(Node *root, int data);
Node* insertAtEnd(Node *root, int data);
Node* removeNode(Node *root, int data);
void traverse(Node *root);
int size();
int isEmpty();

int middle(Node *root);
Node* reverse(Node *root);

#endif // __LINKED_LIST_H__