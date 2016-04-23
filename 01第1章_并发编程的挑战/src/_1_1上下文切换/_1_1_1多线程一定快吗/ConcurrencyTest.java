package _1_1�������л�._1_1_1���߳�һ������;

/**
 * ConcurrencyTest.java
 * 
 * @author admin
 * 
 */
public class ConcurrencyTest {

	private static final long count = 10000001;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("ѭ��������" + count);
		concurrency();// ��������
		serial();// ��������
	}

	/**
	 * 
	 * ѭ��������10001 ����ʱ�䣺0ms,b:10001 ����ʱ�䣺0ms,a:10001,b:10001
	 * 
	 * ѭ��������100001 ����ʱ�䣺0ms,b:100001 ����ʱ�䣺0ms,a:100001,b:100001
	 * 
	 * ѭ��������1000001 ����ʱ�䣺16ms,b:1000001 ����ʱ�䣺15ms,a:1000001,b:1000001
	 * 
	 * ѭ��������10000001 ����ʱ�䣺63ms,b:10000001 ����ʱ�䣺94ms,a:10000001,b:10000001
	 * 
	 * ѭ��������100000001 ����ʱ�䣺610ms,b:100000001 ����ʱ�䣺937ms,a:100000001,b:100000001
	 * 
	 * !!!!!!��Ϊ�߳��д������������л��Ŀ���
	 */
	/**
	 * ��������
	 * 
	 * @throws InterruptedException
	 */
	private static void concurrency() throws InterruptedException {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		// �����A��
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
		// thread.run();//run()�������̣߳�ֻ���ڵ�ǰ��������ִ��run()�еĴ���!!!!!

		// �����B��
		int b = 0;
		for (long i = 0; i < count; i++) {
			b++;
			// System.out.println("b:" + b);//
		}
		long time = System.currentTimeMillis() - start;
		thread.join();// �����߳�
		System.out.println("����ʱ�䣺" + time + "ms," + "b:" + b);
	}

	/**
	 * ��������
	 */
	private static void serial() {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		// �����A��
		int a = 0;
		for (long i = 0; i < count; i++) {
			a++;
		}
		// �����B��
		int b = 0;
		for (long i = 0; i < count; i++) {
			b++;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("����ʱ�䣺" + time + "ms,a:" + a + ",b:" + b);
	}
}
//hehe
