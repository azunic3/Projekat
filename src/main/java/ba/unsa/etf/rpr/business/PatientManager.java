package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Blood;
import ba.unsa.etf.rpr.Domain.Patient;
import ba.unsa.etf.rpr.Exceptions.BloodException;
import java.util.List;
/**
 * Business Logic Layer for management of Patients
 * @author Azra Žunić
 */
public class PatientManager {
    /**
     * method used for tests
     * @param name
     * @throws BloodException
     */
    public void validatePatientsName(String name) throws BloodException{
        if (name == null || name.length() > 30 || name.length() < 3){
            throw new BloodException("Name must contain between 3 and 30 characters");
        }
    }

    /**
     * validation method used for tests
     * @param gen
     * @throws BloodException
     */
    public static void validateGender(String gen) throws BloodException{
        if(gen==null || gen.length()>1 || gen!="F" || gen!="M")
            throw new BloodException("Incorrect gender option!");
    }

    /**
     * add method
     * @param b
     * @return
     * @throws BloodException
     */
    public Patient add(Patient b) throws BloodException {
        if (b.getId() != 0){
            throw new BloodException("Can't add patient with ID. ID is autogenerated");
        }
        validatePatientsName(b.getFull_Name());

        try{
            return DaoFactory.patientDao().add(b);
        }catch (BloodException e){
            if (e.getMessage().contains("UQ_Full_Name")){
                throw new BloodException("Patient with the same name already exists");
            }
            throw e;
        }
    }
    /**
     *
     * @param text
     * @return
     * @throws BloodException
     */
    public  List<Patient> searchPatients(String text) throws BloodException {
    return (DaoFactory.patientDao().searchByFullName(text));
    }
    public  Patient searchPatientsByName(String text) throws BloodException {
        return (DaoFactory.patientDao().searchByPatientsName(text));
    }

    /**
     *
     * @return
     * @throws BloodException
     */
    public List<Patient> getAll() throws BloodException {
            return DaoFactory.patientDao().getAll();
        }

    /**
     *
     * @param id
     * @throws BloodException
     */
    public static void delete(int id) throws BloodException{
        DaoFactory.patientDao().delete(id);
    }

    /**
     *
     * @param Patient_id
     * @return
     * @throws BloodException
     */
        public Patient getById(int Patient_id) throws BloodException{
            return DaoFactory.patientDao().getById(Patient_id);
        }

    /**
     *
     * @param q
     * @throws BloodException
     */
        public void update(Patient q) throws BloodException{
            DaoFactory.patientDao().update(q);
        }

    /**
     *
     * @param group
     * @return
     * @throws BloodException
     */
    public List<Patient> searchByBloodGroup(Blood group) throws BloodException{
        return DaoFactory.patientDao().searchByBloodGroup(group);
    }

}
