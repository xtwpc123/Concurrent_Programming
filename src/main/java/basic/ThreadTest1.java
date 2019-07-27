package basic;

/**
 * @author: Mr.wang
 * @date: 2019/7/27 10:41
 * @description:
 */
public class ThreadTest1 {

    // 创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {

                try {
                    // 获取resourceA共享资源的监视器锁
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");

                        // 获取resourceB共享资源的监视器锁
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");

                            // 线程A阻塞，并释放获取到的resourceA的锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try {
                    // 休眠1s
                    Thread.sleep(1000);

                    // 获取resourceA共享资源的监视器锁

                }
            }
        })

    }
}
