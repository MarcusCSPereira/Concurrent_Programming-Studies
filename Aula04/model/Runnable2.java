package model;

public class Runnable2 implements Runnable {

    private ClasseA objA;
    private ClasseB objB;
    
    public Runnable2(ClasseA objA, ClasseB objB){
        this.objA = objA;
        this.objB = objB;
    }
    
    public void run() {
        objB.m1(objA); //O lock do objB fica com a Thread2
    }
}