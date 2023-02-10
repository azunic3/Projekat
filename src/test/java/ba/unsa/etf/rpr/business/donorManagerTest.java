package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.Dao.DaoFactory;
import ba.unsa.etf.rpr.Dao.DonorDaoSQLImpl;
import ba.unsa.etf.rpr.Domain.Donor;
import ba.unsa.etf.rpr.Exceptions.BloodException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author Azra Žunić
 * version 1.0
 */
public class donorManagerTest {
    private DonorManager donorManager = new DonorManager();
    private Donor donor;

    /**
     * This method will be called before each test method
     */
    @BeforeEach
    public void initializeObjectsWeNeed(){
        donor = new Donor();
        donor.setId(50);
        donor.setFullName("Nađa Kovačević");
        donor.setPassword("nadjak");
        donor.setAlreadyDonated("YES");
    }
@Test
void validateName(){
        String name=null;
        assertThrows(BloodException.class, ()->donorManager.validateDonorsName(name));
}
    @Test
    void validatePassword(){
        String pass = "";
        assertThrows( BloodException.class, ()->donorManager.validatePassword(pass), "Password cannot be shorter than 6 signs nor longer than 20 signs!");
    }
    @Test
    void validateADonated(){
        String don="MEJBI";
        assertThrows(BloodException.class, ()->donorManager.validateADonated(don), "An answer must be either 'YES' or 'NO'");
    }
    @Test
    void testing () throws BloodException {
        Donor dd=new Donor();
        dd.setFullName("Lejla Jakupovic");
        assertEquals(dd.getFullName(),donorManager.searchByDonorsName("Lejla Jakupovic").getFullName(),"Something is wrong");
    }

    /**
     * mocking test for update
     * @throws BloodException
     */
    @Test
    void testUpdate() throws BloodException{
        MockedStatic<DaoFactory> daoFactoryMockedStatic = Mockito.mockStatic(DaoFactory.class);
        DonorDaoSQLImpl depDao = Mockito.mock(DonorDaoSQLImpl.class);
        daoFactoryMockedStatic.when(DaoFactory::donorDao).thenReturn(depDao);
        donor.setPhoneNumber(61258963);
        when(depDao.update(donor)).thenReturn(donor);
        donorManager.update(donor);
        Assertions.assertTrue(true);
        daoFactoryMockedStatic.close();
    }
    }
