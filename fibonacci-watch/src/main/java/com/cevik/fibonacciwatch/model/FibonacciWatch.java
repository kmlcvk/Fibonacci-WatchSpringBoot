package com.cevik.fibonacciwatch.model;

import com.cevik.fibonacciwatch.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FibonacciWatch {

    private int hours;
    private int minutes;
    private List<Color> colors;
}
