package ba.unsa.etf.rpr.Domain;
import ba.unsa.etf.rpr.Dao.HospitalDaoSQLImpl;

import java.util.Objects;
/**
 * bean for hospital
 * @author Azra Žunić
 * version 1.0
 */
public class Hospital extends HospitalDaoSQLImpl implements Idable{
    private static int Hospital_id;
    private String Name;
    private int QuantityOnHand;
    private String Adress;
    private int ContactNumber;
    private String description;

    public Hospital() {
    }

    public Hospital(int hospital_id, String name, String adress, int contactNumber, String description, int quantityOnHand) {
        Hospital_id = hospital_id;
        Name = name;
        QuantityOnHand = quantityOnHand;
        Adress = adress;
        ContactNumber = contactNumber;
        this.description = description;
    }



    public static int getHospital_id() {
        return Hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        Hospital_id = hospital_id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getAdress() {
        return Adress;
    }
    public void setAdress(String adress) {
        Adress = adress;
    }
    public int getContactNumber() {
        return ContactNumber;
    }
    public void setContactNumber(int contactNumber) {
        ContactNumber = contactNumber;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getQuantityOnHand() {
        return QuantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        QuantityOnHand = quantityOnHand;
    }
    @Override
    public String toString() {
        return "Hospital{" +
                "Hospital_id=" + Hospital_id +
                ", Name='" + Name + '\'' +
                ", QuantityOnHand" + QuantityOnHand + '\'' +
                ", Adress='" + Adress + '\'' +
                ", ContactNumber=" + ContactNumber +
                ", description='" + description +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return Hospital_id == hospital.Hospital_id && ContactNumber == hospital.ContactNumber && QuantityOnHand == hospital.QuantityOnHand && Objects.equals(Name, hospital.Name) && Objects.equals(Adress, hospital.Adress) && Objects.equals(description, hospital.description);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Hospital_id, Name, QuantityOnHand, Adress, ContactNumber, description);
    }


    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return Hospital_id;
    }
}
