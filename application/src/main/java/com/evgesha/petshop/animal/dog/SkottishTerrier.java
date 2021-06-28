package com.evgesha.petshop.animal.dog;

public class SkottishTerrier extends Dog {

    @Override
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
}
