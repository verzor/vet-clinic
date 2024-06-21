package main.javacode.com.magicvet.model;

public class Dog extends Pet{


    private Size size;
    public Dog(){}

    @Override
    public String toString() {
        return "Pet {"
                + "Type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", size = " + getSize()
                + ", owner: " + getOwnerName()
                + ", registration time:" + getRegistrationDate().format(FORMATTER)
                + "}";
    }
    public Dog(Size size){
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public enum Size{
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);

        private final int value;

        Size(int value){
            this.value = value;
        }

        public static Size fromString (String value){
            for(Size size : values()){
                if (size.toString().equals(value)){
                    return size;
                }
            }
            System.out.println("Unable to parse value '"+ value + ".Used default:" + UNKNOWN);

            return UNKNOWN;
        }
        public int getValue(){
            return value;
        }
    }
}
