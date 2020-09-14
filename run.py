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
        if lang in ['cpp', 'java']:
            return (self.langCommand + self.algoCommand, './{}'.format(self.algoCommand))
        elif lang in ['python', 'js']:
            return ('chmod 755 main.{}'.format(self.langCommand), './main.{}'.format(self.langCommand))
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

    def wichLanguage(self, lang):
        if lang == '-java':
            return 'java'
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