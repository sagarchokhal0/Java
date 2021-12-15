//parametrized constructor
class Parametrized{
	public Parametrized(String name){
		String value=name;
		System.out.println(value + " is your name.");
	}
	public static void main(String[] args) {
		Parametrized obj=new Parametrized("shuvham");
	}
}
