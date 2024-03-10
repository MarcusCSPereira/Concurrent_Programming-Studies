package model;

public class ClasseB {

    public synchronized void m1(ClasseA objA) {
        try {
            String nome = Thread.currentThread().getName();
            System.out.println(nome + ": executando m1() da ClasseB: Obtém o Lock de objB");
            Thread.sleep(500);
            System.out.println(nome + ": tenta executar m2() da ClasseA: tenta obter o Lock de objA");
            objA.m2();
        } catch (Exception e) {
        }
    }

    public synchronized void m2() {
        try {
            String nome = Thread.currentThread().getName();
            System.out.println(nome + ": executando m2() da ClasseB");
            Thread.sleep(500);
        } catch (Exception e) {
        }
    }
}