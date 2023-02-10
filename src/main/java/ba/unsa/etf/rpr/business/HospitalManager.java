package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Hospital;
import ba.unsa.etf.rpr.Exceptions.BloodException;
import java.util.List;
/**
 * Business Logic Layer for Hospitals
 * @author Azra Žunić
 */

public class HospitalManager {
    /**
     * validation of hospitals name, used for tests
     * @param name
     * @throws BloodException
     */
    public void validateHospitalName(String name) throws BloodException{
        if (name == null || name.length() > 20 || name.length() < 4){
            throw new BloodException("Name must contain between 4 and 20 characters");
        }
    }

    /**
     *
     * @param b
     * @return
     * @throws BloodException
     */
    public Hospital add(Hospital b) throws BloodException {
        if (b.getId() != 0){
            throw new BloodException("Can't add hospital with ID. ID is autogenerated");
        }
        validateHospitalName(b.getName());

        try{
            return DaoFactory.hospitalDao().add(b);
        }catch (BloodException e){
            if (e.getMessage().contains("UQ_Name")){
                throw new BloodException("Hospital with the same name exists");
            }
            throw e;
        }
    }

    /**
     *
     * @return
     * @throws BloodException
     */
    public List<Hospital> getAll() throws BloodException {
        return DaoFactory.hospitalDao().getAll();
    }

    /**
     * delete method
     * @param id
     * @throws BloodException
     */
    public void delete(int id) throws BloodException{
        DaoFactory.hospitalDao().delete(id);
    }

    /**
     * @param Hospital_id
     * @throws BloodException
     */
    public Hospital getById(int Hospital_id) throws BloodException{
        return DaoFactory.hospitalDao().getById(Hospital_id);
    }


    /**
     * searching by name
     * @param name
     * @return information about hospital named as a parameter
     * @throws BloodException
     */
    public Hospital searchByName(String name) throws BloodException {
        return DaoFactory.hospitalDao().searchByName(name);
    }

}
