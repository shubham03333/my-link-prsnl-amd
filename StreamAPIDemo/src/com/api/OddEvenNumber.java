package com.api;

public class OddEvenNumber {

    private int number = 1;
    private final int MAX = 10;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 1) {
                System.out.println("odd: " + number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 == 0) {
                System.out.println("Even: " + number);
                number++;
                notify();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }


    }

        public static void main(String[] args) {
            OddEvenNumber number= new OddEvenNumber();
            Thread oddThread = new Thread(()->number.printOdd());
            Thread evenThread = new Thread(() ->number.printEven());

            oddThread.start();
            evenThread.start();
        }

}