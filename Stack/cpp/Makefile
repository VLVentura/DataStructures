COMPILER = g++ -std=c++11 -O2
FLAG = -Wall

stack: main.cpp Stack.h Stack.cpp Node.h Node.cpp
	$(COMPILER) $(FLAG) main.cpp Stack.h -o stack	

clean:
	rm stack

run:
	./stack