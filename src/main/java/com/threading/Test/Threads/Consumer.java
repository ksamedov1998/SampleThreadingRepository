package com.threading.Test.Threads;

import com.threading.Test.Domains.Number;
import com.threading.Test.Repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingDeque;

public class Consumer implements Runnable {
    private BlockingDeque<Number> deque;

    private WebRepository webRepository;

    public Consumer() {
    }

    public Consumer(BlockingDeque<Number> deque,WebRepository webRepository) {
        this.webRepository=webRepository;
        this.deque = deque;
    }

    @Override
    public void run() {

        while (true){
            Number number=new Number();
            try {
                number=deque.takeFirst();
                webRepository.updateNumber(number);
                System.out.println(number.toString()+ " status has been change to registered");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
