package tarena.day10_string;

class FinalizeSample{
	public void finalize(){
		System.out.println("FinalizedSample对象被收集");
	}
}

public class TestFinalize{
    @SuppressWarnings("unused")
    public static void main(String[]args)throws Exception{
		FinalizeSample fs = new FinalizeSample();
		fs = null;
		System.gc();
		Thread.sleep(5000);
    }
}