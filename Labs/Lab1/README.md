**Q1 **Write a program to demonstrate all three types of constructors in java

//no-argument constructor
 class constructor{
	int value;
	public constructor(){
		value=80;
     System.out.println("constructor is called");
	}
	public static void main(String[] args) {
		constructor obj= new constructor();
		System.out.println("the value is:"+ obj.value);
	}
}
//default constructor
class default_constructor{
 
 int a;
 boolean b;

	public static void main(String[] args) {
	
		default_constructor obj=new default_constructor();
		System.out.println(" the value of a is:"+obj.a);

		System.out.println(" the value of b is:"+obj.b);
	}
}
//parametrized constructor
class argument_constructor{
	public argument_constructor(String name){
		String value=name;
		System.out.println(value + " is your name.");
	}
	public static void main(String[] args) {
		argument_constructor obj=new argument_constructor("shuvham");
	}
}



**#Write a program to implement stack using array 
''' public class Stack { private E[] arr = null; private int CAP; private int top = -1; private int size = 0;**
@SuppressWarnings("unchecked")
public Stack(int cap) {
	this.CAP = cap;
	this.arr = (E[]) new Object[cap];
}

public E pop() {
	if(this.size == 0){
		return null;
	}

	this.size--;
	E result = this.arr[top];
	this.arr[top] = null;//prevent memory leaking
	this.top--;

	return result;
}

public boolean push(E e) {
	if (isFull())
		return false;

	this.size++;
	this.arr[++top] = e;

	return true;
}

public boolean isFull() {
	if (this.size == this.CAP)
		return false;
	return true;
}

public String toString() {
	if(this.size==0){
		return null;
	}

	StringBuilder sb = new StringBuilder();
	for(int i=0; i<this.size; i++){
		sb.append(this.arr[i] + ", ");
	}

	sb.setLength(sb.length()-2);
	return sb.toString();	
}

public static void main(String[] args) {

	Stack<String> stack = new Stack<String>(11);
	stack.push("hello");
	stack.push("world");

	System.out.println(stack);

	stack.pop();
	System.out.println(stack);

	stack.pop();
	System.out.println(stack);
}**


**Write a program to implement uses of Abstract Class .****
abstract class abstract_class{
	public abstract void myfun1();
	public void myfun2(){
		System.out.println("this is my second function");
	}
} 
class childClass extends abstract_class{
   
   public void myfun1(){
    	System.out.println("this class is inheriting the abstract class");
    }

	
}
 class output{
 	public static void main(String[] args) {
 		childClass obj=new childClass();
 		obj.myfun1();
 		obj.myfun2();
 	}
 }
