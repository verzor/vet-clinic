package main.javacode.com.magicvet.component;

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
                System.out.println("Adding a new pet.");

                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");

                System.out.println(client);
            }
        }
    }

}