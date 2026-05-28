public class Contact implements Comparable {
    private String name;
    private String telNum;
    private String email;

    public Contact(String name, String telNum, String email) {
        this.name = name;
        this.telNum = telNum;
        this.email = email;
    }

    public Contact(String name) {
        this.name = name;
        this.telNum = null;
        this.email = null;
    }

    public String getName() {
        return name;
    }

    public String getTelNum() {
        return telNum;
    }

    public String getEmail() {
        return email;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Name: " + name + "\nTel #: " + telNum + "\nEmail: " + email + "\n\n";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Contact) {
            Contact c = (Contact) obj;
            return this.name.equals(c.name);
        }
        return false;
    }

    public int compareTo(Object obj) {
        Contact c = (Contact) obj;
        return this.name.compareTo(c.name);
    }

}
