package com.cevik.fibonacciwatch.service;

import com.cevik.fibonacciwatch.model.FibonacciWatch;

public interface FibonacciWatchService {
    FibonacciWatch getCurrentTime ();
    FibonacciWatch getRequestedTime (int hours, int minutes);
}
