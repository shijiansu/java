package tarena.day15_exception;

import java.io.FileOutputStream;

public class TestFinally {
	public static int m(){
		try{
			return 10;
		}finally{
			System.out.println("finally");
			//return 20;//最好不要
		}
	}
	public static void main(String[] args) {
		int r = m();
		System.out.println(r);
		FileOutputStream fos = null;
		try {
			 fos = new FileOutputStream("1.txt");
		} catch (Exception e) {
			System.out.println("处理异常");
		}finally{
			try{fos.close();}catch(Exception e){}
		}

		
	}
}
