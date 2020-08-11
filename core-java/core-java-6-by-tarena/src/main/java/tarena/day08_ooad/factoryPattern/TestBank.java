package tarena.day08_ooad.factoryPattern;

class Account{}
class SavingAccount extends Account{}
class CreditAccount extends Account{}
class LoanSavingAccount extends Account{}
class LoanCreditAccount extends Account{}
class AccountType{
	public static final int SAVING_ACCOUNT = 0;
	public static final int CREDIT_ACCOUNT = 1;
	public static final int LOAN_SAVING_ACCOUNT = 2;
	public static final int LOAN_CREDIT_ACCOUNT = 3;
}
class Bank{
   public Account open(int type){
	Account account = null;
	if(type==AccountType.SAVING_ACCOUNT){
		account = new SavingAccount();
	}else if(type==AccountType.CREDIT_ACCOUNT){
		account = new CreditAccount();
	}else if(type==AccountType.LOAN_SAVING_ACCOUNT){
		account = new LoanSavingAccount();
	}else if(type==AccountType.LOAN_CREDIT_ACCOUNT){
		account = new LoanCreditAccount();
	}
	return account;
   }
}
public class TestBank{
	public static void main(String[]args){
		Bank b = new Bank();
		b.open(AccountType.SAVING_ACCOUNT);
	}
}