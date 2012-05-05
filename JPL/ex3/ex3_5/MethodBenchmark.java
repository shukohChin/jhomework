package ex3.ex3_5;

public class MethodBenchmark extends Benchmark{
	int loop;
	void benchmark(){
		for(int i = 0; i < loop; i++){

		}
	}

	public static void main(String[] args){
		int count = Integer.parseInt(args[0]);
		MethodBenchmark m = new MethodBenchmark();
		m.loop = Integer.parseInt(args[1]);
		long time = m.repeat(count);
		System.out.println(m.loop + " count " + count + " methods in " + time + "nanoseconds");
	}
}
