package main.javacode.com.magicvet.component;

import static main.javacode.com.magicvet.Main.SCANNER;

public class Autentificator {
    private static String PASSWORD = "d";
    static boolean auth(){
        boolean accepted = false;
        for( int i = 0; i <3; i++){
            System.out.println("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)){
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password");
            }
        }
        System.out.println(accepted ? "Welcome to the Magic Vet" : "Application has be blocked");

        return accepted;
    }
}
