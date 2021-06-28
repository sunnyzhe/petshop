package com.evgesha.petshop.animal.dog;

public class Shpitz extends Dog {
    private int paws = 4;

    public int getPaws() {
        return paws;
    }

    public void setPaws(int newPaws) {
        if(newPaws >= 1 && newPaws <= 4) {
            paws = newPaws;
        } else {
            System.out.println("Ti durak, verni lapi");
        }
    }

    public void eat(String korm) {
        System.out.println("I'm " + name + "and eating the " + korm);
    }

    @Override
    public void cureAnimal() {
        System.out.println("Меня лечат НЕ очень качественно");
    }

    @Override
    public void cureDog() {
        System.out.println("Меня лечат качественно");
    }

    @Override
    public String toString() {
        return "{" +
                "paws=" + paws +
                ", name='" + name + '\'' +
                '}';
    }
}
