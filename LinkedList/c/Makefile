COMPILER = gcc 
FLAG = -Wall

list: main.o LinkedList.o
	$(COMPILER) $(FLAG) main.c LinkedList.c -o list
	@rm *.o	

main.o: main.c LinkedList.h LinkedList.c
	$(COMPILER) $(FLAG) main.c -c

LinkedList.o: LinkedList.h LinkedList.c
	$(COMPILER) $(FLAG) LinkedList.c -c

clean:
	rm *.o list

run:
	./list