package main.javacode.com.magicvet.service;

import main.javacode.com.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static main.javacode.com.magicvet.Main.SCANNER;

public class ClientService {
    private final static String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,}$";

    public Client registerNewClient() {
        Client client = null;


        System.out.println("Please provide client details");
        System.out.print("Email:");
        String email = SCANNER.nextLine();

        if(isEmailValid(email)){
            client = buildClient(email);
            System.out.println("New client: " + client.getFirstName() + client.getLastName() + "(" + client.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid");
        }
        return client;
    }


    static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);
        System.out.println("First name: ");
        client.setFirstName(SCANNER.nextLine());
        System.out.println("Last name: ");
        client.setLastName(SCANNER.nextLine());


        return  client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return  matcher.matches();
    }
}
