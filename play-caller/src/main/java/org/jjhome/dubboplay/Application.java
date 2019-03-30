package org.jjhome.dubboplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class Application {

    @Bean
	public CountDownLatch closeLatch() {
    	return new CountDownLatch(1);
	}

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		System.out.println("Dubbo service started!");
		final CountDownLatch latch = ctx.getBean(CountDownLatch.class);
		Runtime.getRuntime().addShutdownHook(new Thread(latch::countDown));
		latch.await();
	}

}
