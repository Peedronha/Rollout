import org.example.RollOut;
import org.example.RolloutValidator;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class RolloutTest {


    private final RollOut store;

    private final RolloutValidator rolloutValidator = new RolloutValidator();

    public RolloutTest() {
        this.store = new RollOut("São Paulo", "Sorocaba", "15", "SRP 11609 SOROCABA");;
    }

    @Test
    public void testValidateGeneral_AllFieldsInvalid() {

        String state = "Sao Paulo";
        String city = "Sao Paulo";
        String ddd = "11";
        String cnl = "123";

        boolean result = RolloutValidator.validateGeneral(state, city, ddd, cnl);

        assertFalse(result);
    }


    @Test
    public void testValidateGeneral_AllFieldsValid() {
        assertTrue(rolloutValidator.validateGeneral("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA"));
    }

    @Test
    public void testValidateGeneral_InvalidState() {
        assertFalse(rolloutValidator.validateGeneral("InvalidState", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA"));
    }

    @Test
    public void testValidateGeneral_InvalidCity() {
        assertFalse(rolloutValidator.validateGeneral("SP", "InvalidCity", "15", "ARD 11038 ARACOIABA DA SERRA"));
    }

    @Test
    public void testValidateGeneral_InvalidDDD() {
        assertFalse(rolloutValidator.validateGeneral("SP", "ARACOIABA DA SERRA", "InvalidDDD", "ARD 11038 ARACOIABA DA SERRA"));
    }

    @Test
    public void testValidateGeneral_InvalidCNL() {
        assertFalse(rolloutValidator.validateGeneral("SP", "ARACOIABA DA SERRA", "15", "InvalidCNL"));
    }

    @Test
    public void testValidateGeneral_StateAndCNLValid() {
        assertTrue(rolloutValidator.validateGeneral("SP", null, null, "ARD 11038 ARACOIABA DA SERRA"));
    }

    @Test
    public void testValidateGeneral_InvalidStateAndCNL() {
        assertFalse(rolloutValidator.validateGeneral("InvalidState", null, null, "InvalidCNL"));
    }

    @Test
    public void testValidateGeneral_CityAndDDDValid() {
        assertTrue(rolloutValidator.validateGeneral(null, "ARACOIABA DA SERRA", "15", null));
    }

    @Test
    public void testValidateGeneral_InvalidCityAndDDD() {
        assertFalse(rolloutValidator.validateGeneral(null, "InvalidCity", "InvalidDDD", null));
    }

    @Test
    public void testGetRolloutByState_ValidState() {
        RolloutValidator testValidator = new RolloutValidator();

        testValidator.getRollOuts().add(new RollOut("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA"));
        testValidator.getRollOuts().add(new RollOut("SP", "Sorocaba", "11", "SOC"));

        Collection<RollOut> expectedRollOuts = testValidator.getRollOuts();

        assertEquals(expectedRollOuts, testValidator.getRolloutByState("SP"));
    }

    @Test
    public void testGetRolloutByCity_InvalidCity() {

        RollOut testRollOut = new RollOut("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA");

        assertNotEquals(testRollOut, rolloutValidator.getRolloutByCity("InvalidCity"));
    }

    @Test
    public void testGetRolloutByDDD_ValidDDD() {
        RolloutValidator testValidator = new RolloutValidator();

        testValidator.getRollOuts().add(new RollOut("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA"));

        Collection<RollOut> expectedRollOuts = testValidator.getRollOuts();

        assertEquals(expectedRollOuts, rolloutValidator.getRolloutByDDD("15"));
    }

    @Test
    public void testGetRolloutByCNL_InvalidCNL() {

        RollOut testRollOut = new RollOut("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA");

        assertNotEquals(testRollOut, rolloutValidator.getRolloutByCNL("InvalidCnl"));
    }

}