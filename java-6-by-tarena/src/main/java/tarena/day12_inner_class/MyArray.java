package tarena.day12_inner_class;

public class MyArray{
	private Object[] is = new Object[3];
	private int size = 0;
	public int size(){
		return size;
	}
	private void expend(){
		Object[] other = new Object[is.length*2];
		for(int i=0; i<size; i++){
			other[i] = is[i];
		}
		is = other;
	}
	public void add(Object x){
		//如果空间不够，扩容
		if(size>=is.length){
			expend();
		}
		//把客户的数据放到该放的位置
		is[size] = x;
		size++;
	}
	public void delete(int index){
		if(index>=size||index<0){
			return;
		}
		for(int i=index; i<size-1; i++){
			is[i] = is[i+1];
		}
		size--;
	}
	public void set(int index, Object x){
		if(index>=size||index<0){
			return;
		}
		is[index] = x;
	}
	public Object get(int index){
		return is[index];
	}
	public void insert(int index, Object x){
		if(size>=is.length){
			expend();
		}
		for(int i=size;i>index; i--){
			is[i] = is[i-1];
		}
		is[index] = x;
		size++;
	}
	public void print(){
		for(int i=0; i<size; i++){
			System.out.print(is[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[]args){
		MyArray ma = new MyArray();
		ma.add(new Integer(1));
		ma.add(2);
		ma.add(3);
		for(int i=0; i<ma.size; i++){
			System.out.println(ma.get(i));
		}
	}
}