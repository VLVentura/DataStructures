COMPILER = g++ -std=c++11 -O2
FLAG = -Wall

queue: main.cpp Queue.h Queue.cpp Node.h Node.cpp
	$(COMPILER) $(FLAG) main.cpp Queue.h -o queue	

clean:
	rm queue

run:
	./queue