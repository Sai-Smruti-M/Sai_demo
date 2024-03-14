//Q7. Consider a scenario where you are tasked with developing a simple banking application 
//using Java, employing the concept of polymorphism. Your application should consist of three 
//classes: Account, SavingsAccount, and CurrentAccount. The Account class serves as the 
//base class with private attributes for account number and balance, along with abstract methods 
//for deposit and withdrawal. The SavingsAccount class, a subclass of Account, should include 
//an additional attribute for interest rate and override the deposit method to calculate interest, as 
//well as override the withdrawal method to ensure a sufficient balance. Similarly, the 
//CurrentAccount class, also a subclass of Account, should incorporate an overdraft limit 
//attribute and override the withdrawal method to check the overdraft limit. Implement the 
//classes as described, ensuring proper encapsulation and abstraction. Finally, create a 
//BankingApplication class (Main) to demonstrate the polymorphic behavior by creating 
//instances of both SavingsAccount and CurrentAccount, testing deposit and withdrawal 
//operations, and displaying account details.


public class as1q7
{

	public static void main(String[] args) 
	{
		Account a1=new SavingsAccount("42210929384",2000.1f,1.5f);
		Account a2=new CurrentAccount("52636477475",30000.0f,2000f);
		System.out.println("\nDemo for Savings account..");
		System.out.println(a1);
		a1.deposit(500);
		a1.withdrawal(2000);
		a1.withdrawal(1000);
		System.out.println("\nDemo for current account..");
		System.out.println(a2);
		a2.deposit(500);
		a2.withdrawal(30000);
		a2.withdrawal(1000);
		a2.withdrawal(1000);
		a2.withdrawal(1000);

	}

}

abstract class Account
{
	private String accno;
	private float bal;
	
	public Account(String accno, float bal) 
	{
		this.accno=accno;
		this.bal=bal;
		
	}
	abstract public void deposit(float amt);
	abstract public void withdrawal(float amt);
	public String getAccno() {
		return accno;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Account No.: " + accno + ", Bal=" + bal;
	}
	
	
}

class SavingsAccount extends Account
{
	private float ir;
	 public SavingsAccount(String accNo, float bal, float ir) {
	        super(accNo, bal);
	        this.ir = ir;
	    }

	@Override
	public void deposit(float amt) 
	{
		setBal(getBal()+(ir/100)*amt+amt);
		System.out.println("Rs. "+amt +" deposited, Balance: "+getBal());
		
	}

	@Override
	public void withdrawal(float amt) 
	{
		if(getBal()>=amt )
		{
			setBal(getBal()-amt);
			System.out.println("Rs. "+amt+" is deducted. Balance: Rs."+getBal());
		}
		else
		{
			System.out.println("Rs."+amt+" cannot be withdrawn. Insufficient Balance");
		}
		
	}

	@Override
	public String toString() {
		return "Savings Account :-\n"+ super.toString() + ", Interest rate: "+ir;
	}
	
	
}

class CurrentAccount extends Account
{

	private float overdraftLimit;
	public CurrentAccount(String accno, float bal,float overdraftLimit) 
	{
		super(accno, bal);
		this.overdraftLimit=overdraftLimit;
		
	}
	@Override
	public void deposit(float amt) 
	{
		setBal(getBal()+amt);
		System.out.println("Rs. "+amt +" deposited, Balance: "+getBal());
		
	}
	@Override
	public void withdrawal(float amt) 
	{
		if(getBal()-amt >= -overdraftLimit)
		{
			setBal(getBal()-amt);
			System.out.println("Rs. "+amt+" is deducted. Balance: "+getBal());
		}
		else
		{
			System.out.println("Rs."+amt+" cannot be withdrawn. Overdraft Limit Exceeded.");
		}
		
	}
	@Override
	public String toString() {
		return "Current Account:-\n"+ super.toString() + ", Overdraft Limit: "+overdraftLimit;
	}
	
	
}