package com.threading.Test.Threads;

import com.threading.Test.Domains.Number;
import com.threading.Test.Repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Component
public class ThreadStarter {
    private Consumer consumer;
    private Producer producer;

    @Autowired
    private WebRepository webRepository;

    private BlockingDeque<Number> deque= new LinkedBlockingDeque<>(1000);

    @PostConstruct
    public void start(){
        new Thread(new Consumer(deque,webRepository),"consumer").start();
        new Thread(new Producer(deque,webRepository),"producer").start();
    }

    public ThreadStarter() {
    }
    
}
