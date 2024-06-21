package main.javacode.com.magicvet.component;

import static main.javacode.com.magicvet.component.Autentificator.auth;

public class ApplicationRunner {

    private final EntityRegister register = new EntityRegister();

    public void run() {
        if (auth()) {
            register.registerClients();
        }
    }


}