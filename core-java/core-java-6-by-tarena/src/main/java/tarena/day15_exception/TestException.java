package tarena.day15_exception;

import java.io.IOException;
import java.util.Random;

public class TestException {
	public static void sleep() throws InterruptedException {
		Random r = new Random();
		if (r.nextBoolean()) {
			throw new InterruptedException();
		}
	}

	public static void other() throws RuntimeException {
		Random r = new Random();
		if (r.nextBoolean()) {
			throw new RuntimeException("这是一个不检查异常");
		}
	}
	
	@SuppressWarnings("unused")
	public static void m(){
		Random r = new Random();
		try{
			//.....申请一些资源
			sleep();
			System.out.println("正常代码");
			
		}catch(InterruptedException e){
			System.out.println("处理sleep异常");
		}finally{
			System.out.println("资源正在回收...");
		}
	}
	
	public static void m1()throws IOException, InterruptedException{
		Random r = new Random();
		int i = r.nextInt(2);
		if(i==0){
			throw new IOException();
		}else if(i==1){
			throw new InterruptedException();
		}
	}

	public static void main(String[] args) {
		try {
			sleep();
			System.out.println("程序正常执行");
		} catch (InterruptedException e) {
			System.out.println("异常被抛出，正在处理中。。。");
		}
		try {
			other();
			System.out.println("*********");
		} catch (RuntimeException e) {
			System.out.println("另一个不检查异常被抛出");
		}
		System.out.println("程序执行结束");
		System.out.println("========================");
		m();
		try{
			m1();
		}catch(IOException e){
			System.out.println("IOException");
		}catch(InterruptedException e){
			System.out.println("InterruptedException");
		}
	}
}
