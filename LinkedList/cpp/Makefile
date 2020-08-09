COMPILER = g++ -std=c++11 -O2
FLAG = -Wall

list: main.cpp I_List.h LinkedList.h LinkedList.cpp Node.h Node.cpp
	$(COMPILER) $(FLAG) main.cpp LinkedList.h -o list	

clean:
	rm list

run:
	./list