CPP = g++
CPPFLAGS = -O2 -Wall -Wextra -c -g --std=c++11
LDFLAGS =
LIBS = -lGL -lglut -lGLU

DEPS = $(wildcard *.hpp)
SOURCES = $(wildcard *.cpp)
OBJECTS = $(SOURCES:.cpp=.o)
EXECUTABLE = n2

.PHONY: all clean

all: $(SOURCES) $(EXECUTABLE)

$(EXECUTABLE): $(OBJECTS)
	$(CPP) $(LDFLAGS) $(LIBS) $(OBJECTS) -o $@

.cpp.o: $(DEPS)
	$(CPP) $(CPPFLAGS) $< -o $@

clean:
	rm $(EXECUTABLE) *.o
