package tarena.day12_inner_class.inner;

public class TestInnerInterface {
	public static void main(String[] args) {
		Sample.IB ib = new IBImpl();
		ib.m();
	}
}
class Sample{
	/*private*/ interface IB{
		void m();
	}
	class Inner implements IB{
		public void m(){}
	}
	
}
class IBImpl implements Sample.IB{
	public void m(){}
}

interface ID{
	/*public static final */int i = 10;
	/*public static */class IDInner{}
}
class IDInnerChild extends ID.IDInner{}

interface IE{
	interface IF{}
}

