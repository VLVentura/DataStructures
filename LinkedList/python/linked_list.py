from node import Node

class LinkedList:
    
    _size_of_list = 0

    def __init__(self, data=None):
        self._root = Node()
        
        if data != None:
            self.insert(data)
    
    def __len__(self):
        return self._size_of_list

    @property
    def root(self):
        return self._root
    
    @root.setter
    def root(self, node):
        self._root = node

    def insert(self, data):
        self._size_of_list += 1

        new_node = Node(data)
        new_node.next_node = self.root
        self.root = new_node

    def remove(self, data):
        if self.root.data == None:
            return
        
        self._size_of_list -= 1
        if self.root.data == data:
            self.root = self.root.next_node
        else:
            LinkedList.__remove(data, self.root, self.root.next_node)

    @staticmethod
    def __remove(data, previous_node, actual_node):
        if actual_node.data == None:
            return
        if actual_node.data == data:
            previous_node.next_node = actual_node.next_node
        else:
            LinkedList.__remove(data, actual_node, actual_node.next_node)

    def traverse_list(self):
        it = self.root

        while it.next_node != None:
            print(it.data, end=' -> ')
            it = it.next_node
        print(it.next_node, end = '')

    def empty(self):
        if self.root.data == None:
            return True
        return False

    def middle(self):
        faster = self.root
        slower = self.root

        while faster.next_node.data != None and faster.next_node.next_node.data != None:
            faster = faster.next_node.next_node
            slower = slower.next_node

        return slower.data

    def reverse(self):
        previous_node = Node()
        after_node = Node()

        current_node = Node()
        current_node = self.root

        while current_node.data != None:
            after_node = current_node.next_node
            current_node.next_node = previous_node

            previous_node = current_node
            current_node = after_node

        self.root = previous_node

