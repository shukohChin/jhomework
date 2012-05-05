package ex3.ex3_2;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	{
		printMask(4);
	}

	public X(){
		fullMask = xMask;
		printMask(5);
	}

	public int mask(int orig){
		return (orig & fullMask);
	}

	public void printMask(int step){
		System.out.printf("%d\t%x\t%x\t%x\t\n", step, xMask, 0, fullMask);
	}
}
