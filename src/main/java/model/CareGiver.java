package model;
/**
 * Nurses treat patients.
 */
public class CareGiver extends Person {
    private long cgid;
    private String phonenumber;
    private String username;
    private String password;

    /**
     * constructs a Nurse from the given params.
     * @param firstName
     * @param surname
     * @param phonenummber
     * @param username
     * @param password
     */
    public CareGiver(String firstName, String surname, String phonenummber, String username, String password) {
        super(firstName, surname);
        this.phonenumber = phonenummber;
        this.username = username;
        this.password = password;
    }

    /**
     * constructs a Nurse from the given params.
     * @param firstName
     * @param surname
     * @param phonenummber
     * @param username
     * @param password
     */
    public CareGiver(long cgid, String firstName, String surname, String phonenummber, String username, String password) {
        super(firstName, surname);
        this.cgid = cgid;
        this.phonenumber = phonenummber;
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @return Nurse id
     */
    public long getCgid() {
        return cgid;
    }

    /**
     *
     * @return nurse phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     *
     * @param phonenumber new phone number
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     *
     * @return nurse Username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return nurse password
     */
    public String getPassword() {
        return password;
    }
    /**
     *
     * @return string-representation of the nurse
     */
    public String toString() {
        return "Pfleger" + "\nMNID: " + this.getCgid() +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nTelefonnumer: " + this.getPhonenumber() +
                "\nUsername: " + this.getUsername() +
                "\n";
    }
}
