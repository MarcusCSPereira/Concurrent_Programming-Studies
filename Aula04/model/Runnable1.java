package model;

public class Runnable1 implements Runnable {

    private ClasseA objA;
    private ClasseB objB;
    
    public Runnable1(ClasseA objA, ClasseB objB){
        this.objA = objA;
        this.objB = objB;
    }
    
    public void run() {
        objA.m1(objB); //O lock do objA fica com a Thread1
    }
}