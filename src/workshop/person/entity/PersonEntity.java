package workshop.person.entity;

public class PersonEntity {
    private String name;
    private String ssn;
    private String address;
    private String phone;
    private String gender;

    // Default Constructor
    public PersonEntity() {
    }

    // Constructor with parameters using setters
    public PersonEntity(String name, String ssn, String address, String phone) {
        setName(name);
        setSSN(ssn);
        setAddress(address);
        setPhone(phone);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSSN() {
        return ssn;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
        if (ssn != null && ssn.length() >= 7) {
            char genderChar = ssn.charAt(6);
            if (genderChar == '1' || genderChar == '3') {
                this.gender = "³²";
            } else if (genderChar == '2' || genderChar == '4') {
                this.gender = "¿©";
            }
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
