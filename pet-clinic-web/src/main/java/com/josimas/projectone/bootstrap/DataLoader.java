package com.josimas.projectone.bootstrap;

import com.josimas.projectone.model.Role;
import com.josimas.projectone.model.User;
import com.josimas.projectone.owner.Owner;
import com.josimas.projectone.owner.Pet;
import com.josimas.projectone.owner.PetType;
import com.josimas.projectone.repository.RoleRepository;
import com.josimas.projectone.repository.UserRepository;
import com.josimas.projectone.services.*;
import com.josimas.projectone.vet.Speciality;
import com.josimas.projectone.vet.Vet;
import com.josimas.projectone.visit.Visit;
import com.josimas.recipe.domain.*;
import com.josimas.recipe.repositories.CategoryRepository;
import com.josimas.recipe.repositories.RecipeRepository;
import com.josimas.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    //private final CategoryService categoryService;
    //private final RecipeService recipeService;
    //private final UnitOfMeasureService unitOfMeasureService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;

        log.debug("Class DataLoader => Constructor Dataloader");
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
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

        // recipeRepository.saveAll(getRecipes());

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentisty = new Speciality();
        dentisty.setDescription("Dentisty");
        Speciality savedDentisty = specialtyService.save(dentisty);

        Owner owner1 = new Owner();
        owner1.setFirstName("Josimar");
        owner1.setLastName("Silva");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("+551121753500");

        // Owner.builder().address("Rua do Address").build();

        Pet josimarPet = new Pet();
        josimarPet.setPetType(savedDogPetType);
        josimarPet.setOwner(owner1);
        josimarPet.setBirthDate(LocalDate.now());
        josimarPet.setName("Maltês");
        owner1.getPets().add(josimarPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Josimas");
        owner2.setLastName("Batista");
        owner2.setAddress("987 Krington");
        owner2.setCity("Los Angeles");
        owner2.setTelephone("+551121753425");

        Pet josimasCat = new Pet();
        josimasCat.setName("Frajola");
        josimasCat.setOwner(owner2);
        josimasCat.setBirthDate(LocalDate.now());
        josimasCat.setPetType(savedCatPetType);
        owner2.getPets().add(josimasCat);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(josimasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Josis");
        vet1.setLastName("Silva");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Josi");
        vet2.setLastName("Batista");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }

    /*
    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Each)");
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Tablespoon)");
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Teaspoon)");
        }

        Optional<UnitOfMeasure> dashSpoonUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Dash)");
        }

        Optional<UnitOfMeasure> pintSpoonUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Pint)");
        }

        Optional<UnitOfMeasure> cupSpoonUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found (Cup)");
        }

        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();
        UnitOfMeasure dashSpoonUom = dashSpoonUomOptional.get();
        UnitOfMeasure pintSpoonUom = pintSpoonUomOptional.get();
        UnitOfMeasure cupSpoonUom = cupSpoonUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found (American)");
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category Not Found (Mexican)");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        Recipe guacRecipe = new Recipe();
        guacRecipe.setDirections("Perfect Guacamole");
        guacRecipe.setPrepTime(10);
        guacRecipe.setCookTime(2);
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setDirections("1 cut  avocado" +
                "\n" +
                "2 Mash" +
                "\n" +
                "3 Add salt" +
                "\n" +
                "4 Cover with plastic" +
                "\n" +
                "Read more: guacamole");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries.\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws");

        guacRecipe.setNotes(guacNotes);

        //very redundent - could add helper method, and make this simpler
        guacRecipe.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecipe.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tableSpoonUom));
        guacRecipe.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dashSpoonUom));
        guacRecipe.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), eachUom));

        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);

        //add to return list
        recipes.add(guacRecipe);

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");

        tacosRecipe.setNotes(tacoNotes);

        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), eachUom));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tableSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), eachUom));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cupSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), eachUom));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pintSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), eachUom));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), eachUom));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cupSpoonUom));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), eachUom));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);
        return recipes;
    }
    */
}
