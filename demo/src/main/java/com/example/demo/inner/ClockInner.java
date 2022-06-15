package com.example.demo.inner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockInner {

    public void start(int interval,boolean beep){
        var timePrinter = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                if (beep){
                    System.out.println("1111");
                }
            }
        };
        Timer timer = new Timer(interval, timePrinter);
        ActionListener[] actionListeners = timer.getListeners(ActionListener.class);
        timer.start();
    }
}
