package model;
/**
 * Nurses treat patients.
 */
public class CareGiver extends Person {
    private long cgid;
    private String phonenumber;

    /**
     * constructs a Nurse from the given params.
     * @param firstName
     * @param surname
     * @param phonenummber
     */
    public CareGiver(String firstName, String surname, String phonenummber) {
        super(firstName, surname);
        this.phonenumber = phonenummber;
    }

    /**
     * constructs a Nurse from the given params.
     * @param firstName
     * @param surname
     * @param phonenummber
     */
    public CareGiver(long cgid, String firstName, String surname, String phonenummber) {
        super(firstName, surname);
        this.cgid = cgid;
        this.phonenumber = phonenummber;
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
     * @return string-representation of the nurse
     */
    public String toString() {
        return "Pfleger" + "\nMNID: " + this.getCgid() +
                "\nFirstname: " + this.getFirstName() +
                "\nSurname: " + this.getSurname() +
                "\nTelefonnumer: " + this.getPhonenumber() +
                "\n";
    }
}
