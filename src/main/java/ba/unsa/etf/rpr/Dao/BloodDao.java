package ba.unsa.etf.rpr.Dao;

import ba.unsa.etf.rpr.Domain.Blood;
import ba.unsa.etf.rpr.Domain.Hospital;
import ba.unsa.etf.rpr.Exceptions.BloodException;

import java.util.List;

/**
 * DAO interface for Blood domain bean
 * @author Azra Žunić
 * version 1.0
 */
public interface BloodDao extends Dao<Blood> {

    /**
     * methods: getAll, searchByBagNumber, searchByHospital
     * @return lists
     */
public  List<Blood> searchByBagNumber(int BloodBagNumber) throws BloodException;
    public List<Blood> getAll() throws BloodException;

    public List<Blood> searchByHospital(Hospital hospital_id) throws BloodException;
}
