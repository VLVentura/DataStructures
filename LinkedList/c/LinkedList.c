#include <stdio.h>
#include <stdlib.h>
#include "LinkedList.h"

static int sizeOfList = 0;

Node* createList(Node *root){
    return NULL;
}

Node* insert(Node *root, int data){
    Node *newNode = (Node *) malloc(sizeof(Node));
    newNode->data = data;

    ++sizeOfList;
    if(root == NULL){
        newNode->nextNode = NULL;
    }
    else{
        newNode->nextNode = root;
    }

    root = newNode;
    return root;
}

Node* insideRemove(int data, Node *previousNode, Node *actualNode){
    if(actualNode == NULL){
        return actualNode;
    }

    if(actualNode->data == data){
        Node *temp = actualNode;
        previousNode->nextNode = actualNode->nextNode;
        actualNode = actualNode->nextNode;
        free(temp);
    }
    else{
        actualNode = insideRemove(data, actualNode, actualNode->nextNode);
    }

    return previousNode;
}

Node* removeNode(Node *root, int data){
    if(root == NULL){
        return root;
    }

    --sizeOfList;
    if(root->data == data){
        Node *temp = root;
        root = root->nextNode;
        free(temp);
    }
    else{
       root = insideRemove(data, root, root->nextNode);
    }

    return root;
}

void traverseList(Node *root){
    if(root == NULL){
        printf("NULL\n");
        return;
    }
    printf("%d -> ", root->data);
    traverseList(root->nextNode);
}

int sizeList(){
    return sizeOfList;
}

int emptyList(){
    return sizeOfList == 0;
}

int middle(Node *root){
    Node *faster = root;
    Node *slower = root;

    while(faster->nextNode != NULL && faster->nextNode->nextNode != NULL){
        faster = faster->nextNode->nextNode;
        slower = slower->nextNode;
    }

    return slower->data;
}

Node* reverse(Node *root){
    Node *previousNode = NULL;
    Node *nextNode = NULL;
    Node *currentNode = root;

    while(currentNode != NULL){
        nextNode = currentNode->nextNode;
        currentNode->nextNode = previousNode;

        previousNode = currentNode;
        currentNode = nextNode;
    }

    root = previousNode;
    return root;
}