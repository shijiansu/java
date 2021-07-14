package tarena.day11_inner_class;

enum Operation{
   ADD{
	public double calculate(double d1, double d2){
		return d1+d2;
	}
   },
   SUB{
	public double calculate(double d1, double d2){
		return d1-d2;
	}
   },
   MUL{
	public double calculate(double d1, double d2){
		return d1*d2;
	}
   },
   DIV{
	public double calculate(double d1, double d2){
		return d1/d2;
	}
   };
   public abstract double calculate(double d1, double d2);
}
public class TestOperation{
	public static void main(String[]args){
		double x = 8;
		double y = 2;
		Operation[] os = Operation.values();
		for(int i=0; i<os.length; i++){
			System.out.println(os[i].name()+":"+os[i].calculate(x, y));
		}
	}
}