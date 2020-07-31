JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	State.java \
	Instruction.java \
	TuringMachine.java \
	TestTM.java 

MAIN = TestTM

default: runtm copy perm

classes: $(CLASSES:.java=.class)

runtm: classes

copy:
	cp ~/Documents/CS3052/runtm ~/Documents/CS3052/src

clean:
	$(RM) *.class

perm:
	chmod a+x runtm