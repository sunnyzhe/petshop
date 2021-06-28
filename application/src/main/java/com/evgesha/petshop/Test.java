package com.evgesha.petshop;

import com.evgesha.petshop.animal.doctor.AnimalDoctor;
import com.evgesha.petshop.animal.doctor.DogDoctor;
import com.evgesha.petshop.animal.dog.Dog;
import com.evgesha.petshop.animal.dog.Shpitz;
import com.evgesha.petshop.animal.dog.SkottishTerrier;

public class Test {
    public static void main(String[] args) {
        System.out.println("here here");

        Shpitz pureshka = new Shpitz();
        pureshka.name = "Pureshka";
        pureshka.eat("kormushka");

        pureshka.setPaws(19);

        System.out.println(pureshka.getPaws());


        Dog ika = new SkottishTerrier();
        ika.name = "Ika";
        ika.eat("kura head");


        AnimalDoctor animalDoctor = new AnimalDoctor();
        animalDoctor.cure(pureshka);
        animalDoctor.cure(ika);

        DogDoctor dogDoctor = new DogDoctor();
        dogDoctor.cure(pureshka);
        dogDoctor.cure(ika);

    }
}
