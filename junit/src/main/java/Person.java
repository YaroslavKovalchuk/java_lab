import java.util.Objects;

public class Person {

    private String name;
    private String surname;
    private Adress adress;

    public Person(String name, String surname, Adress adress) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
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

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(adress, person.adress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, adress);
    }
}
