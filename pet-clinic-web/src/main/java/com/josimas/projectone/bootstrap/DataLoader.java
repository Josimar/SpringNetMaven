package com.josimas.projectone.bootstrap;

import com.josimas.projectone.model.Role;
import com.josimas.projectone.model.User;
import com.josimas.projectone.owner.Owner;
import com.josimas.projectone.owner.PetType;
import com.josimas.projectone.repository.RoleRepository;
import com.josimas.projectone.repository.UserRepository;
import com.josimas.projectone.services.OwnerService;
import com.josimas.projectone.services.PetTypeService;
import com.josimas.projectone.services.VetService;
import com.josimas.projectone.vet.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("josimar@gmail.com", passwordEncoder.encode("mar1976"), "Josimar", "Silva", true, "josimarb");
        user.setRoles(List.of(adminRole));
        userRepository.save(user);

        user = new User("josimas@gmail.com", passwordEncoder.encode("mar1976"), "Josimar", "Silva", true, "josimas");
        user.setRoles(List.of(userRole));
        userRepository.save(user);

        System.out.println(" ");
        System.out.println("********** Auto Load **********");

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Josimar");
        owner1.setLastName("Silva");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Josimas");
        owner2.setLastName("Batista");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Josis");
        vet1.setLastName("Silva");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Josi");
        vet2.setLastName("Batista");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
