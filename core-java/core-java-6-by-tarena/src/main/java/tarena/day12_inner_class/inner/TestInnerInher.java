package tarena.day12_inner_class.inner;

public class TestInnerInher {
}

class Outer{
	class Inner{
		public void show(){
			System.out.println("inner");
		}
	}
	static class StaticInner{
		
	}
}
class StaticInnerChild extends Outer.StaticInner{
	
}
class InnerChild extends Outer.Inner{
	public InnerChild(Outer outer){
		outer.super();
	}
}