package test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SplitStrTest {
	public static void main(String[] args) {
		String resourceCode = "3.2.3.5.32.5";
		int index = resourceCode.lastIndexOf(".");
		System.out.println(resourceCode.substring(0, index));
		
		System.out.println(UUID.randomUUID());
		
		System.out.println("bf353e28-22a9-4322-a432-f637da516d70".length());
		handlerStr();
	}
	
	public static void handlerStr() {
//		0课程简介,1.Linux下RPM版MYSQL安装、启停,2.MySQL启动问题、配置文件、编码问题,3.MYSQL分层、存储引擎,4SQL解析过程、索引、B树,5.B树与索引,6.SQL优化准备,7.explain中的id、table,8.type级别详解,9.索引类型及逐步优化、key_len计算方法,10.ref、rows、usingFilesort,11.Extra字段,12优化示例,13.单表优化及总结,14.多表优化及避免索引失效原则1,15避免索引失效原则2,16常见优化方法及慢查询SQL排查,17慢查询阀值和mysqldumpslow工具,18模拟并通过profiles分析海量数据,19全局查询日志,20锁机制详解,21写锁示例与MyISAM模式特征,22表锁情况分析及行锁解析,23行锁的注意事项及使用情况分析,24查询行锁,25安装win版MySQL,26主从同步原理,27主从同步实战
		String str = "00happens-before简单概述,01重排序问题,02锁的内存语义,03volatile的内存语义,04final域内存语义,05线程的状态以及各状态之间的转换详解,06线程的初始化，中断以及其源码讲解,07多种创建线程的方式案例演示（一）带返回值的方式,08多种创建线程的方式案例演示（二）使用线程池,09Spring对并发的支持：Spring的异步任务,10使用jdk8提供的lambda进行并行计算,11了解多线程所带来的安全风险,12从线程的优先级看饥饿问题,13从Java字节码的角度看线程安全性问题,14synchronized保证线程安全的原理（理论层面）,15synchronized保证线程安全的原理（jvm层面）,16单例问题与线程安全性深入解析,17理解自旋锁，死锁与重入锁,18深入理解volatile原理与使用,19JDK5提供的原子类的操作以及实现原理,20Lock接口认识与使用,21手动实现一个可重入锁,22AbstractQueuedSynchronizer(AQS)详解,23使用AQS重写自己的锁,24重入锁原理与演示,25读写锁认识与原理,26细读ReentrantReadWriteLock源码,27ReentrantReadWriteLock锁降级详解,28线程安全性问题简单总结,29线程之间的通信之wait notify,30通过生产者消费者模型理解等待唤醒机制,31Condition的使用及原理解析,32使用Condition重写waitnotify案例并实现一个有界队列,33深入解析Condition源码,34实战：简易数据连接池,35线程之间通信之join应用与实现原理剖析,36ThreadLocal 使用及实现原理,37并发工具类CountDownLatch详解,38并发工具类CyclicBarrier 详解,39并发工具类Semaphore详解,40并发工具类Exchanger详解,41CountDownLatch,CyclicBarrier,Semaphore源码解析,42提前完成任务之FutureTask使用,43Future设计模式实现（实现类似于JDK提供的Future）,44Future源码解读,45ForkJoin框架详解,46同步容器与并发容器,47并发容器CopyOnWriteArrayList原理与使用,48并发容器ConcurrentLinkedQueue原理与使用,49Java中的阻塞队列原理与使用,50实战：简单实现消息队列,51并发容器ConcurrentHashMap原理与使用,52线程池的原理与使用,53Executor框架详解,54实战：简易web服务器（一）,55实战：简易web服务器（二）,56JDK8的新增原子操作类LongAddr原理与使用,57JDK8新增锁StampedLock详解,58重排序问题,59happens-before简单概述,60锁的内存语义,61volatile内存语义,62final域的内存语义,63实战：问题定位";
		String[] strArray = str.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < strArray.length; i++) {
			String tmpStr = strArray[i];
			tmpStr = tmpStr.substring(2);
			tmpStr = String.format("%02d", (i+1)) + tmpStr;
			list.add(tmpStr);
		}
		System.out.println(list);
	}
}
