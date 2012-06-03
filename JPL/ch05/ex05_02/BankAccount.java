package ch05.ex05_02;

public class BankAccount {
	private long number;	//口座番号
	private long balance;	//現在の残高
	private Action lastAct;	//最後に行われた処理
	private History history = new History();

	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			return number + ": " + act + "\t" + amount;
		}
	}

	public class History {
		private int currentIndex = -1;
		private int index = 0;
		private Action[] act = new Action[10];

		public Action next() {
			if (currentIndex++ < act.length - 1)
				return act[currentIndex];
			else
				return null;
		}

		public void add(Action act) {
			if (index < 10)
				this.act[index] = act;
			else {
				for (int i = 0; i < this.act.length - 1; i++) {
					this.act[i] = this.act[i + 1];
				}
				this.act[this.act.length - 1] = act;
			}
			index++;
		}

//		public String toString() {
//			String str = null;
//			for(int i = 0; i < this.act.length; i++) {
//				str += act[i];
//			}
//			return str;
//		}
	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		this.history.add(lastAct);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		this.history.add(lastAct);
	}

	public void transfer(BankAccount other, long amount) {
		other.withdraw(amount);
		deposit(amount);
		lastAct = this.new Action("transfer", amount);
		other.lastAct = other.new Action("transfer", amount);
	}

	public History history() {
		return this.history;
	}
}
