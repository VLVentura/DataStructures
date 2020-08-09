class Node:
    def __init__(self, data=None, next_node=None):
        self._data = data
        self._next_node = next_node
    
    @property
    def data(self):
        return self._data
    

    @data.setter
    def data(self, data):
        self._data = data
    

    @property
    def next_node(self):
        return self._next_node
    
    
    @next_node.setter
    def next_node(self, node):
        self._next_node = node