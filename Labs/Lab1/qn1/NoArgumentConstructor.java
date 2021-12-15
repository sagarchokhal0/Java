//no-argument Constructor
 class NoArgumentConstructor{
	int value;
	public NoArgumentConstructor(){
		value=80;
     System.out.println("NoArgumentConstructor is called");
	}
	public static void main(String[] args) {
		NoArgumentConstructor obj= new NoArgumentConstructor();
		System.out.println("the value is:"+ obj.value);
	}
}