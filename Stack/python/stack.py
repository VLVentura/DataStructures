from node import Node

class Stack:

    __stackSize = 0

    def __init__(self, data=None):
        self.__root = Node(data)

        if data != None:
            self._stackSize += 1


    @property
    def root(self):
        return self.__root
    

    @root.setter
    def root(self, node):
        self.__root = node
    

    def __len__(self):
        return self.__stackSize
    

    def push(self, data):
        self.__stackSize += 1

        newNode = Node(data)
        newNode.nextNode = self.root
        self.root = newNode
    

    def pop(self):
        if self.__stackSize == 0:
            return
        
        dataToReturn = self.root.data

        temp = self.root
        self.root = self.root.nextNode
        temp = None

        self.__stackSize -= 1
        return dataToReturn

    

    def top(self):
        return self.root.data


    def empty(self):
        return self.__stackSize == 0
