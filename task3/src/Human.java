public class Human {
    @Save
    private int age;
    @Save
    private String name;
    @Save
    private String surname;
    private String address;

    public Human() {
    }

    public Human(int age, String name, String surname, String address) {
        this.age = age;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
