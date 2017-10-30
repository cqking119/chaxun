package test;

/**
 * Created by Malu on 2017-10-19.
 * 实际上这个程序的目的就是新建两个线程，threadA，threadB，新建了一个锁，使用synchronized获取到了这个锁（private static final 只有一个锁），线程A用完了线程2用。
 * synchronized关键字就是用来检查锁的 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


public class ThreadLock {
    /**
     * 拿来加锁的对象
     */
    private static final Object WAIT_OBJECT = new Object();

    /**
     * 日志，如果您没有log4j，请使用System.out
     */
    private static final Log LOGGER = LogFactory.getLog(ThreadLock.class);

    /**
     * 偷懒，我把异常全部抛出了。正式系统不要这么搞哦！！
     * @param args
     * @throws Exception
     */
    @Test
    public  void main() throws Exception {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                // 检查'对象锁'状态。
                synchronized (ThreadLock.WAIT_OBJECT) {
                    ThreadLock.LOGGER.info("做了一些事情。。。。");
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                // 检查'对象锁'状态。
                synchronized (ThreadLock.WAIT_OBJECT) {
                    ThreadLock.LOGGER.info("做了另一些事情。。。。");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
