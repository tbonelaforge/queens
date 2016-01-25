all: clean queens

queens: QueenBoardTest.class
	@echo "Writing shortcut script queens..."
	@echo '#! /bin/sh' > queens
	@echo 'java QueenBoardTest $$@' >> queens
	@chmod +x queens

QueenBoardTest.class: QueenBoardTest.java QueenBoard.class Options.class
	javac QueenBoardTest.java

QueenBoard.class: QueenBoard.java
	javac QueenBoard.java

Options.class: Options.java
	javac Options.java

.PHONY: clean

clean:
	rm -f queens
	rm -f *.class
