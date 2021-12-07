Garbage Collection is the process of reclaiming the runtime unused memory by destroying the unused objects.

In languages like C and C++, the programmer is responsible for both the creation and destruction of objects. Sometimes, the programmer may forget to destroy useless objects, and the memory allocated to them is not released. The used memory of the system keeps on growing and eventually there is no memory left in the system to allocate. Such applications suffer from "memory leaks".

After a certain point, sufficient memory is not available for creation of new objects, and the entire program terminates abnormally due to OutOfMemoryErrors.

You can use methods like free() in C, and delete() in C++ to perform Garbage Collection. In Java, garbage collection happens automatically during the lifetime of a program. This eliminates the need to de-allocate memory and therefore avoids memory leaks.

Java Garbage Collection is the process by which Java programs perform automatic memory management. Java programs compile into bytecode that can be run on a Java Virtual Machine (JVM).

When Java programs run on the JVM, objects are created on the heap, which is a portion of memory dedicated to the program.

Over the lifetime of a Java application, new objects are created and released. Eventually, some objects are no longer needed. You can say that at any point in time, the heap memory consists of two types of objects:

Live - these objects are being used and referenced from somewhere else
Dead - these objects are no longer used or referenced from anywhere
The garbage collector finds these unused objects and deletes them to free up memory.

How to Dereference an Object in Java
The main objective of Garbage Collection is to free heap memory by destroying the objects that don’t contain a reference. When there are no references to an object, it is assumed to be dead and no longer needed. So the memory occupied by the object can be reclaimed.

There are various ways in which the references to an object can be released to make it a candidate for Garbage Collection. Some of them are:

By making a reference null
Student student = new Student();
student = null;
By assigning a reference to another
Student studentOne = new Student();
Student studentTwo = new Student();
studentOne = studentTwo; // now the first object referred by studentOne is available for garbage collection
By using an anonymous object
register(new Student());
How does Garbage Collection Work in Java?
Java garbage collection is an automatic process. The programmer does not need to explicitly mark objects to be deleted.

The garbage collection implementation lives in the JVM. Each JVM can implement its own version of garbage collection. However, it should meet the standard JVM specification of working with the objects present in the heap memory, marking or identifying the unreachable objects, and destroying them with compaction.

What are Garbage Collection Roots in Java?
Garbage collectors work on the concept of Garbage Collection Roots (GC Roots) to identify live and dead objects.

Examples of such Garbage Collection roots are:

Classes loaded by system class loader (not custom class loaders)
Live threads
Local variables and parameters of the currently executing methods
Local variables and parameters of JNI methods
Global JNI reference
Objects used as a monitor for synchronization
Objects held from garbage collection by JVM for its purposes
The garbage collector traverses the whole object graph in memory, starting from those Garbage Collection Roots and following references from the roots to other objects.


Phases of Garbage Collection in Java
A standard Garbage Collection implementation involves three phases:

Mark objects as alive
In this step, the GC identifies all the live objects in memory by traversing the object graph.

When GC visits an object, it marks it as accessible and thus alive. Every object the garbage collector visits is marked as alive. All the objects which are not reachable from GC Roots are garbage and considered as candidates for garbage collection.


Sweep dead objects
After marking phase, we have the memory space which is occupied by live (visited) and dead (unvisited) objects. The sweep phase releases the memory fragments which contain these dead objects.


Compact remaining objects in memory
The dead objects that were removed during the sweep phase may not necessarily be next to each other. Thus, you can end up having fragmented memory space.

Memory can be compacted after the garbage collector deletes the dead objects, so that the remaining objects are in a contiguous block at the start of the heap.

The compaction process makes it easier to allocate memory to new objects sequentially.


What is Generational Garbage Collection in Java?
Java Garbage Collectors implement a generational garbage collection strategy that categorizes objects by age.

