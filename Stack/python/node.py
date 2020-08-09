class Node:
    def __init__(self, data=None, nextNode=None):
        self.__data = data
        self.__nextNode = nextNode
    

    @property
    def data(self):
        return self.__data
    

    @data.setter
    def data(self, data):
        self.__data = data
    

    @property
    def nextNode(self):
        return self.__nextNode
    

    @nextNode.setter
    def nextNode(self, nextNode):
        self.__nextNode = nextNode