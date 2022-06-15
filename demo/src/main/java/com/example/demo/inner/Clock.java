package com.example.demo.inner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Clock {
    private boolean beep;

    public class TimePrinter implements ActionListener{
        private String name;
//        private static String sex;     error
//        private static final String sex;  error
        private static final String sex = "";

        @Override
        public void actionPerformed(ActionEvent e) {
            if (beep){
                System.out.println(beep);
            }
        }

    }
}
class Test{
    public static void main(String[] args) {
        Clock clock = new Clock();
        Clock.TimePrinter timePrinter = clock.new TimePrinter();
    }
}