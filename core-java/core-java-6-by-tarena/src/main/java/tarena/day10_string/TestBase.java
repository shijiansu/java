package tarena.day10_string;

class Base{
	public Base(){}
	public Base(int i, int j){}
}

class Test extends Base{
    public Test(int i){
		super();
	}
    public Test(int i, int j){
		super(i, j);
    }
}