package com.threading.Test.Threads;

import com.threading.Test.Domains.Number;
import com.threading.Test.Repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {
    private BlockingDeque<Number> deque;

    private final WebRepository webRepository;

    public Producer(BlockingDeque<Number> deque, WebRepository webRepository) {
        this.deque = deque;
        this.webRepository = webRepository;
    }



    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            Number number=new Number();
            Random random= new Random();
            number.setNumber(String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            number.setStatus(0);
            try {
                webRepository.save(number);
                deque.putLast(number);
                System.out.println(number.toString()+ " status has been added to database");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
