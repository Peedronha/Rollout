import org.example.RolloutValidator;
import org.example.controller.StoreController;
import org.example.model.Store;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class RolloutTest {


    private final StoreController storeController;
    private final Store store;

    private final RolloutValidator rolloutValidator = new RolloutValidator();

    public RolloutTest() {
        this.store = new Store("São Paulo", "Sorocaba", "15", "SRP 11609 SOROCABA");;
        this.storeController = new StoreController();
    }


    @Test
    public void modelValidation(){
        assertNull(storeController.addStore(store));
    }

    @Test
    public void testGeneralValidation() {
        // Mock data
        String state = "Sao Paulo";
        String city = "Sao Paulo";
        String ddd = "11";
        String cnl = "123";

        // Assuming you have a RolloutValidator class with a validateGeneral method
        boolean result = RolloutValidator.validateGeneral(state, city, ddd, cnl);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetRolloutByState() {
        // Mock data
        String state = "Rio de Janeiro";

        // Assuming you have a RolloutValidator class with a getRolloutByState method
        boolean result = RolloutValidator.getRolloutByState(state);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetRolloutByCity() {
        // Mock data
        String city = "Belo Horizonte";

        // Assuming you have a RolloutValidator class with a getRolloutByCity method
        boolean result = RolloutValidator.getRolloutByCity(city);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetRolloutByDDD() {
        // Mock data
        String ddd = "21";

        // Assuming you have a RolloutValidator class with a getRolloutByDDD method
        boolean result = RolloutValidator.getRolloutByDDD(ddd);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testGetRolloutByCNL() {
        // Mock data
        String cnl = "456";

        // Assuming you have a RolloutValidator class with a getRolloutByCNL method
        boolean result = RolloutValidator.getRolloutByCNL(cnl);

        // Assert
        assertTrue(result);
    }
}