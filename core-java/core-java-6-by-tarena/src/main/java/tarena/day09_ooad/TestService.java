package tarena.day09_ooad;

interface IDao{
    void add();
    void update(int i);
}
//======Programer A=========
class DaoImpl implements IDao{
   public void add(){
        System.out.println("存钱");
   }
   public void update(int i){
		System.out.println("更新账户"+i);
   }
}
//=========Programer B===========
class Service{
	private IDao dao;
	public void setDao(IDao dao){
		this.dao = dao;
	}
	public Service(){
		dao = DaoFactory.getDao();
	}
	public void transfer(){
		dao.update(100);
		dao.update(200);
	}
}

class DaoFactory{
	public static IDao getDao(){
		return new DaoImpl();
	}
}

public class TestService{
	public static void main(String[]args){
		Service s = new Service();
		//IDao dao = new DaoImpl();
		//s.setDao(dao);//依赖倒转
		s.transfer();
	}
}