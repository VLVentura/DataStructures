#!/usr/bin/env python3.8
import os 
import sys

class Run:

    def __init__(self, algo, lang):
        self.algo, self.algoCommand = self.wichAlgorithm(algo)
        self.lang, self.langCommand = self.wichLanguage(lang)
        
        self.path = self.algo + self.lang
        self.command, self.exec = self.instructions(self.lang)
    
    def __call__(self):
        os.chdir(self.path)
        os.system(self.command)
        os.system(self.exec)

    def instructions(self, lang):
        if lang in ['c', 'cpp']:
            return (self.langCommand + self.algoCommand, './{}'.format(self.algoCommand))
        elif lang in ['python', 'js']:
            return ('chmod 755 main.{}'.format(self.langCommand), './main.{}'.format(self.langCommand))
        elif lang == 'java':
            return ('javac *.java', 'java Program')
        else:
            print('Data structure not implemented in this language')

    def wichAlgorithm(self, algo):
        if algo == '-list':
            return ('./LinkedList/', 'list')
        elif algo == '-stack':
            return ('./Stack/', 'stack')
        elif algo == '-queue':
            return ('./Queue/', 'queue')
        elif algo == '-bst':
            return ('./BinarySearchTrees/', 'bst')
        elif algo == '-avl':
            return ('./AVLTrees/', 'avl')
        elif algo == '-rbt':
            return ('./RedBlackTrees/', 'rbt')
        elif algo == '-splay':
            return ('./SplayTrees/', 'splay')
        elif algo == '-pqueue':
            return ('./PriorityQueue/', 'pqueue')
        elif algo == '-hasht':
            return ('./HashTable/', 'hasht')
        elif algo == '-lru':
            return ('./LRUCache/', 'lru')
        elif algo == '-fenwick':
            return ('./FenwickTrees/', 'fenwick')
        elif algo == '-disjointset':
            return ('./UnionFindDisjointSet/', 'disjointset')

    def wichLanguage(self, lang):
        if lang == '-java':
            return ('java', 'javac')
        elif lang == '-c++':
            return ('cpp', 'make ')
        elif lang == '-python':
            return ('python', 'py')
        elif lang == '-c':
            return ('c', 'make ')
        elif lang == '-js':
            return ('js', 'js')
        else:
            print('Data structure not implemented in this language')

if __name__ == '__main__':
    args = sys.argv
    Run(args[1], args[2])()