package com.josimas.projectone.bootstrap;

import com.josimas.projectone.owner.Owner;
import com.josimas.projectone.services.OwnerService;
import com.josimas.projectone.services.VetService;
import com.josimas.projectone.vet.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService){
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(" ");
        System.out.println("********** Auto Load **********");

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Josimar");
        owner1.setLastName("Silva");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Josimas");
        owner1.setLastName("Batista");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Josis");
        vet1.setLastName("Silva");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Josi");
        vet1.setLastName("Batista");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
