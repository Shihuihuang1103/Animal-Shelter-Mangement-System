package animalShelter;

public class Animal {
    private int petID;
    private String name;
    private String breed;
    private String gender;
    private int age;
    private String description;

    public Animal(int petID, String name, String breed, String gender, int age, String description) {
        this.petID = petID;
        this.name = name;
        this.breed = breed;
        this.gender = gender;
        this.age = age;
        this.description = description;
    }

    public int getPetID() {
        return petID;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "petID=" + petID +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                '}';
    }
}
