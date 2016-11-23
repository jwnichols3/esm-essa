#
# Title:makefile
#
# Description:
#   'make' or 'make all' to create shared library
#   'make clean' to perform subdirectory cleanup.
#   'make ultraclean' to remove executables.
#

#
# Directories.
#
INCDIR = -I$(JDK_HOME)/include -I$(JDK_HOME)/include/linux

#
# Header Files.
#
STUB_H = jni_stub.h

#
# Libraries.
#
LIB_STUB = libEssaStub.so

#
# Configurations.
#
CMACS  = -DTRACE=1
CFLAGS = -Wall -c -fPIC $(INCDIR)

#
# Tools.
#
CC = gcc

#
# Object Files.
#
OBJS = jni_stub.o

#
# Finally, some work...
#
all: $(LIB_STUB)

$(LIB_STUB): $(OBJS)
	$(CC) -shared -Wl -o $(LIB_STUB) $(OBJS)

jni_stub.o: jni_stub.c $(STUB_H)
	$(CC) $(CFLAGS) $?

#
#  Cleanup this subdirectory.
#
clean:
	-rm -f *.o *.so *.BAK *.dvi *.log *.ps *.aux core *.gch

#
#  Nuke the results.
#
ultraclean:
	-rm -f $(LIB_STUB)
