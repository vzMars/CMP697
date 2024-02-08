public class Person {
    private String name;
    private int age;
    private String ssn;
    private String address;

    public Person() {
        this.name = "";
        this.age = 0;
        this.ssn = "";
        this.address = "";
    }

    public Person(String name, int age, String ssn, String address) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
