package main.javacode.com.magicvet.component;

import main.javacode.com.magicvet.Main;
import main.javacode.com.magicvet.model.Client;
import main.javacode.com.magicvet.model.Pet;
import main.javacode.com.magicvet.service.ClientService;
import main.javacode.com.magicvet.service.PetService;

import static main.javacode.com.magicvet.component.Autentificator.auth;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (auth()) {
            Client client = clientService.registerNewClient();

            if (client != null) {
                registerPets(client);
                System.out.println(client);
            }
        }
    }

            private void registerPets(Client client){
                boolean continueAddPets = true;
                while (continueAddPets){
                    addPet(client);

                    System.out.print("Do you want to add more pets? (y/n)");
                    String answear = Main.SCANNER.nextLine();
                    if("n".equals(answear)){
                        continueAddPets = false;
                    }


                }
            }

            private void addPet(Client client){
                System.out.println("Adding a new pet.");

                Pet pet = petService.registerNewPet();

                if(pet != null) {
                    client.addPet(pet);
                    pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                    System.out.println("Pet has been added.");
                }
            }
}