package tarena.day09_ooad;

public class TestInterface{
    public static void main(String[]args){
		IDImpl idImpl = new IDImpl();
		System.out.println(idImpl instanceof IDImpl);
		System.out.println(idImpl instanceof ID);
		System.out.println(idImpl instanceof IC);
		System.out.println(idImpl instanceof IB);
		System.out.println(idImpl instanceof IA);
		ID id = idImpl;
		IC ic = id;
		IB ib = id;
		IA ia = id;
		
		ia.m1();
		ia.m2();
		//ia.m3();
		ib.m1();
		ib.m2();
		ib.m3();
		ic.m4();
		id.m1();
		id.m2();
		id.m3();
		id.m4();
		id.m5();
    }
}

abstract class AbstractClass{
	int i = 10;
	public abstract void m1();
	public abstract void m2();
}
abstract class AbstractClassChild extends AbstractClass{
	public void other(){}
	public void m1(){}
}

interface IA{
	int i = 10;
	public abstract void m1();
	void m2();
	//public void m3(){}
	//public IA(){}
}

interface IB extends IA{
	void m3();
}

interface IC{
	void m4();
}

interface ID extends IB,IC{
	void m5();
}

class IAImpl extends Object implements IA{//һ����ʵ��һ���ӿ�
	public void m1(){}
	public void m2(){}
}

class IBImpl implements IB{
	public void m1(){}
	public void m2(){}
	public void m3(){}
}

class IDImpl extends Object implements ID{
	public void m1(){}
	public void m2(){}
	public void m3(){}
	public void m4(){}
	public void m5(){}
}

class IBICImpl implements IB, IC{
	public void m1(){}
	public void m2(){}
	public void m3(){}
	public void m4(){}
}

class ClassA extends AbstractClass implements IA,IC{
	public void m1(){}
	public void m2(){}
	public void m4(){}
}
abstract class IDAbstractImpl implements ID{
	public void m1(){}
}
