package model;

public class ClasseA {

    public synchronized void m1(ClasseB objB) {
        try {
            String nome = Thread.currentThread().getName();
            System.out.println(nome + ": executando m1() da ClasseA: Obtém o Lock de objA");
            Thread.sleep(500);
            System.out.println(nome + ": tenta executar m2() da ClasseB: tenta obter o Lock de objB");
            objB.m2();
        } catch (Exception e) {
        }
    }

    public synchronized void m2() {
        try {
            String nome = Thread.currentThread().getName();
            System.out.println(nome + ": executando m2() da ClasseA");
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
}