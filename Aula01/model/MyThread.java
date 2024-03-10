package model;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Thread: " + this.getId() + " is running");
        
    }
}