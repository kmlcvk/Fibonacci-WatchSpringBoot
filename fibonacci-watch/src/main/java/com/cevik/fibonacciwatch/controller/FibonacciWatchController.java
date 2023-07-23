package com.cevik.fibonacciwatch.controller;

import com.cevik.fibonacciwatch.service.FibonacciWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clock")
public class FibonacciWatchController {

    @Autowired
    FibonacciWatchService fService;

    @GetMapping("/now")
    ResponseEntity<?> getNow() {
        return ResponseEntity.ok(fService.getCurrentTime());
    }
    @GetMapping("/manual")
    ResponseEntity<?> getClock(@RequestParam("hour") int hour,
                               @RequestParam("minutes") int minutes) {
        return ResponseEntity.ok(fService.getRequestedTime(hour,minutes));
    }
}
