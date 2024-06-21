package main.javacode.com.magicvet.component;

import main.javacode.com.magicvet.Main;
import main.javacode.com.magicvet.model.Client;
import main.javacode.com.magicvet.model.Pet;
import main.javacode.com.magicvet.service.ClientService;
import main.javacode.com.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void registerClients(){
        List<Client> clients = new ArrayList<>();
        String message = "Do you want to register new client? (y/n)";
        do {
           Client client = addClient();
           if (client != null){
               clients.add(client);
           }
        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientByLocation = groupClients(clients);
        printClients(clientByLocation);


    }

    private void printClients(Map<Client.Location, List<Client>> clientByLocation) {
        for(Map.Entry<Client.Location, List<Client>> clients : clientByLocation.entrySet()){
            String content = "\nLocation: " + clients.getKey()
                            + "\nClients (" + clients.getValue().size() + ")"
                            + "\n\t " + clients.getValue();

            System.out.println(content);
        }
    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdesa = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for (Client client : clients){
            switch (client.getLocation()){
                case Kyiv -> fromKyiv.add(client);
                case Lviv -> fromLviv.add(client);
                case Odesa -> fromOdesa.add(client);
                case UNKNOWN -> fromOdesa.add(client);
            }
        }
        Map<Client.Location, List<Client>> clientByLocation = new HashMap<>();
        clientByLocation.put(Client.Location.Kyiv, fromKyiv);
        clientByLocation.put(Client.Location.Lviv, fromLviv);
        clientByLocation.put(Client.Location.Odesa, fromOdesa);
        clientByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientByLocation;
    }

    private Client addClient(){
        Client client = clientService.registerNewClient();

        if (client != null) {
            registerPets(client);
            System.out.println(client);
        }
        return client;
    }
    private void registerPets(Client client){
        String message ="Do you want to add more pets? (y/n)";
        do {
            addPet(client);
        } while (verifyRepeating(message));
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

    private boolean verifyRepeating(String message){
        System.out.println(message);
        String answear  = Main.SCANNER.nextLine();
        if("y".equals(answear)){
            return true;
        } else if ("n".equals(answear)){
            return false;
        } else {
            System.out.println("Try again");
            return verifyRepeating(message);
        }
    }
}
