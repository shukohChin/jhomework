package ex5.ex5_2;

public class Main {
	public static void main(String[] args){
		BankAccount bA = new BankAccount();
		bA.withdraw(100);
		bA.deposit(110);
		bA.withdraw(120);
		bA.deposit(130);
		bA.withdraw(140);
		bA.deposit(150);
		bA.withdraw(160);
		bA.deposit(170);
		bA.withdraw(180);
		bA.deposit(190);
		bA.withdraw(200);
		bA.deposit(210);

		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());
		System.out.println(bA.history().next());

	}
}
