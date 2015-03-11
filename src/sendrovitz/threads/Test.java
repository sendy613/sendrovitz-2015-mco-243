package sendrovitz.threads;

public class Test {
	private Thread1 thread1;
	private Thread1 thread2;
	private Thread1 thread3;

	public Test() {
		this.thread1 = new Thread1(
				"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU6XZWWAyOYyGjyBV_rRr0rr-fysUY0qySwwMEwI9u7AWM83i-zw",
				"file1.png");
		this.thread2 = new Thread1(
				"http://th02.deviantart.net/fs70/PRE/f/2010/171/4/0/Paint_Splash_PNG_by_AbsurdWordPreferred.png",
				"file2.png");
		this.thread3 = new Thread1(
				"https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRu69Yv3r5FgGYl278TxLBaMdzcLCfRcZc_Hq0SvfH5-PFCFY9acA",
				"file3.png");
	}

	public static void main(String args[]) {
		Test test = new Test();
		test.thread1.start();
		test.thread2.start();
		test.thread3.start();
		System.out.println("DONE");
	}
}
