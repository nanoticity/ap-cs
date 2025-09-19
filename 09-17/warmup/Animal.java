public class Animal {
    
    private String animalType;
    private int age;

    public void setVariables(String type, int years) {
        animalType = type;
        age = years;
    }

    public void printInfo() {
        System.out.println("Animal type: " + animalType);
        System.out.println("Age: " + age + " years");
    }

}
