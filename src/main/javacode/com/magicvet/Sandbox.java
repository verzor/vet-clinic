package main.javacode.com.magicvet;

import main.javacode.com.magicvet.component.comparator.DogSizeComparator;
import main.javacode.com.magicvet.model.Dog;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.XL),
                new Dog(Dog.XS)
        };
        Arrays.sort(dogs, new DogSizeComparator());
        for (Dog dog : dogs){
            System.out.println(dog.getSize());
        }
    }
}
