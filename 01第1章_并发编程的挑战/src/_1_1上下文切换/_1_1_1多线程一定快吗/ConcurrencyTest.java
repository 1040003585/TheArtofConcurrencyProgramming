package _1_1上下文切换._1_1_1多线程一定快吗;

/**
 * ConcurrencyTest.java
 * 
 * @author admin
 * 
 */
public class ConcurrencyTest {

	private static final long count = 10000001;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("循环次数：" + count);
		concurrency();// 并发程序
		serial();// 单道程序
	}

	/**
	 * 
	 * 循环次数：10001 并发时间：0ms,b:10001 串行时间：0ms,a:10001,b:10001
	 * 
	 * 循环次数：100001 并发时间：0ms,b:100001 串行时间：0ms,a:100001,b:100001
	 * 
	 * 循环次数：1000001 并发时间：16ms,b:1000001 串行时间：15ms,a:1000001,b:1000001
	 * 
	 * 循环次数：10000001 并发时间：63ms,b:10000001 串行时间：94ms,a:10000001,b:10000001
	 * 
	 * 循环次数：100000001 并发时间：610ms,b:100000001 串行时间：937ms,a:100000001,b:100000001
	 * 
	 * !!!!!!因为线程有创建和上下文切换的开销
	 */
	/**
	 * 并发程序
	 * 
	 * @throws InterruptedException
	 */
	private static void concurrency() throws InterruptedException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		// 程序块A：
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int a = 0;
				for (long i = 0; i < count; i++) {
					a++;
					// System.out.println("a:" + a);//
				}
			}
		});
		thread.start();
		// thread.run();//run()启动新线程，只是在当前程序串行行执行run()中的代码!!!!!

		// 程序块B：
		int b = 0;
		for (long i = 0; i < count; i++) {
			b++;
			// System.out.println("b:" + b);//
		}
		long time = System.currentTimeMillis() - start;
		thread.join();// 阻塞线程
		System.out.println("并发时间：" + time + "ms," + "b:" + b);
	}

	/**
	 * 单道程序
	 */
	private static void serial() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		// 程序块A：
		int a = 0;
		for (long i = 0; i < count; i++) {
			a++;
		}
		// 程序块B：
		int b = 0;
		for (long i = 0; i < count; i++) {
			b++;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("串行时间：" + time + "ms,a:" + a + ",b:" + b);
	}
}
//hehe
