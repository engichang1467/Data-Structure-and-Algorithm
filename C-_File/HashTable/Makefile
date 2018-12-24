
output: main.o hash.o
	g++ -std=c++11 main.o hash.o -o output

main.o: main.cpp
	g++ -c main.cpp

hash.o: hash.cpp hash.h
	g++ -c hash.cpp

clean:
	rm *.o output