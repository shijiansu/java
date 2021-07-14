package tarena.day10_string;

public class TestParameter{
    public static void main(String[]args){
		System.out.println(args.length);
		for(int i=0; i<args.length; i++){
			System.out.println(args[i]);
		}
		if(args.length==1){
			int i = Integer.parseInt(args[0]);
			System.out.println(i+100);
		}else{
			System.out.println("Usage:java TestParameter 100");
		}
    }
}