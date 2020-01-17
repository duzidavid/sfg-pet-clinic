package cz.duzi.sfgpetclinic.bootstrap;

import cz.duzi.sfgpetclinic.model.Owner;
import cz.duzi.sfgpetclinic.model.PetType;
import cz.duzi.sfgpetclinic.model.Vet;
import cz.duzi.sfgpetclinic.services.OwnerService;
import cz.duzi.sfgpetclinic.services.PetTypeService;
import cz.duzi.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("dog");
        final PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        final PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glennane");

        ownerService.save(owner2);

        System.out.println("Loaded owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Dawid");
        vet2.setLastName("Duzi");

        vetService.save(vet2);

        System.out.println("Loaded Vets......");


    }
}
