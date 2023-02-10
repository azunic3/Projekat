package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Domain.Blood;
import ba.unsa.etf.rpr.Exceptions.BloodException;

import java.util.List;
/**
 * Business Logic Layer for table Blood
 * @author Azra Žunić
 */
public class BloodManager {
    /**
     * method used for validation blood type
     * used in tests
     * @param name
     * @throws BloodException
     */
    public void validateBloodType(String name) throws BloodException{
        if (name == null || name.length() > 3 || name.length() < 2){
            throw new BloodException("Blood type must contain between 2 and 3 characters");
        }
    }
    /**
     * standard method getAll defined in DaoFactory
     * @throws BloodException
     */
    public List<Blood> getAll() throws BloodException{
        return DaoFactory.bloodDao().getAll();
    }

    /**
     * add method implemented in business logic
     * @param b, type Blood
     * @throws BloodException
     */
    public Blood add(Blood b) throws BloodException {
        if (b.getId() != 0){
            throw new BloodException("Can't add information with ID. ID is autogenerated");
        }
        validateBloodType(b.getBloodGroup());
        try{
            return DaoFactory.bloodDao().add(b);
        }catch (BloodException e){
            if (e.getMessage().contains("UQ_BloodBagNumber")){
                throw new BloodException("Information with the same blood bag number exists");
            }
            throw e;
        }
    }

    /**
     * update method, one of basic methods (crud)
     * @param b
     * @throws BloodException
     */
    public Blood update(Blood b) throws BloodException{
        validateBloodType(b.getBloodGroup());
        return DaoFactory.bloodDao().update(b);
    }

    /**
     * delete method
     * @param fk_hospital_id
     * @throws BloodException
     */
    public void delete(int fk_hospital_id) throws BloodException{
        try{
            DaoFactory.bloodDao().delete(fk_hospital_id);
        }catch (BloodException e){
            if (e.getMessage().contains("FOREIGN KEY")){
                throw new BloodException("Cannot delete hospital which is related to blood. First delete related rows from hospital.");
            }
            throw e;
        }

    }

    public Blood getById(int id) throws BloodException {
        return DaoFactory.bloodDao().getById(id);
    }

    /**
     * search method implemented in BloodDaoSqlImpl
     * @param group
     * @throws BloodException
     */
    public Blood searchByBloodGroup(String group) throws BloodException{
        return DaoFactory.bloodDao().searchByBloodGroup(group);
    }
}
