from node import Node

class Queue:

    __queueSize = 0

    def __init__(self, data=None):
        self.__firstNode = Node(data)
        self.__lastNode = Node(data)

        if data != None:
            self.__queueSize += 1


    @property
    def firstNode(self):
        return self.__firstNode
    

    @firstNode.setter
    def firstNode(self, node):
        self.__firstNode = node
    

    @property
    def lastNode(self):
        return self.__lastNode
    

    @lastNode.setter
    def lastNode(self, node):
        self.__lastNode = node 
    

    def __len__(self):
        return self.__queueSize
    

    def push_back(self, data):
        self.__queueSize += 1

        previousLastNode = self.lastNode
        self.lastNode = Node(data)

        if self.firstNode.data == None:
            self.firstNode = self.lastNode
            previousLastNode = None
        else:
            previousLastNode.nextNode = self.lastNode
    
    
    def pop_front(self):
        if self.firstNode.data == None:
            return
    
        dataToReturn = self.firstNode.data

        temp = self.firstNode
        self.firstNode = self.firstNode.nextNode
        temp = None

        self.__queueSize -= 1
        return dataToReturn

    def empty(self):
        return self.__queueSize == 0
    

    def front(self):
        return self.firstNode.data
