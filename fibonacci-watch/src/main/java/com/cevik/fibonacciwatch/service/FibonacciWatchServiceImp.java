package com.cevik.fibonacciwatch.service;

import com.cevik.fibonacciwatch.model.FibonacciWatch;
import com.cevik.fibonacciwatch.util.FibonacciWatchCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FibonacciWatchServiceImp implements FibonacciWatchService{

    @Autowired
    FibonacciWatchCalculator fCalculator;
    @Override
    public FibonacciWatch getCurrentTime() {
        int hours = LocalDateTime.now().getHour();
        hours=hours%12;
        int minutes = LocalDateTime.now().getMinute();
        System.out.println("hour " + hours + "minutes: " + minutes);
        return fCalculator.getFibonacciWatch(hours,minutes);
    }

    @Override
    public FibonacciWatch getRequestedTime(int hours, int minutes) {
        //FibonacciWatch fibonacciWatch = new FibonacciWatch();
        //fibonacciWatch = fCalculator.getFibonacciWatch(hours,minutes);
        return fCalculator.getFibonacciWatch(hours,minutes);
    }
}
