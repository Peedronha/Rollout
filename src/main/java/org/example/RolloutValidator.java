package org.example;

import java.util.*;

public class RolloutValidator {

    private static Map<String, String> rolloutCnlTable = new HashMap<>();
    private static Map<String, String> rolloutDDDTable = new HashMap<>();
    private static Map<String, String> rolloutCityTable = new HashMap<>();
    private static Map<String, String> rolloutStateTable = new HashMap<>();

    private Collection<RollOut> rollOuts = new ArrayList<>();

    public RolloutValidator() {
        rolloutCnlTable.put( "ALAM 11010 ALAMBARI","ALAMBARI");
        rolloutCnlTable.put("ANG 11028 ANGATUBA","ANGATUBA");
        rolloutCnlTable.put("ARD 11038 ARACOIABA DA SERRA", "ARACOIABA DA SERRA");

        rolloutDDDTable.put( "15","ALAM");
        rolloutDDDTable.put("15","ANG");
        rolloutDDDTable.put("15","ARD");

        rolloutCityTable.put("ALAMBARI", "SP");
        rolloutCityTable.put("ANGATUBA", "SP");
        rolloutCityTable.put("ARACOIABA DA SERRA", "SP");

        rolloutStateTable.put("SP", "ALAM");
        rolloutStateTable.put("SP", "ANG");
        rolloutStateTable.put("SP", "ARD");

        rollOuts.add(new RollOut("SP", "ALAMBARI", "15", "ALAM 11010 ALAMBARI"));
        rollOuts.add(new RollOut("SP", "ANGATUBA", "15", "ANG 11028 ANGATUBA"));
        rollOuts.add(new RollOut("SP", "ARACOIABA DA SERRA", "15", "ARD 11038 ARACOIABA DA SERRA"));
    }


    public static boolean validateGeneral(String state, String city, String ddd, String cnl) {
        boolean stateValid = validateAndApplyRollout(state, rolloutStateTable, "State");
        boolean cityValid = validateAndApplyRollout(city, rolloutCityTable, "City");
        boolean dddValid = validateAndApplyRollout(ddd, rolloutDDDTable, "DDD");
        boolean cnlValid = validateAndApplyRollout(cnl, rolloutCnlTable, "CNL");

        if (stateValid && cityValid && dddValid && cnlValid) {
            System.out.println("Rollout changes applied successfully.");
            return true;
        }
        if(stateValid && cnlValid){
            System.out.println("Rollout changes for state and CNL applied successfully.");
            return true;
        }
        if (cityValid && dddValid){
                System.out.println("Rollout changes for city and DDD applied successfully.");
                return true;
        }
        else {
            System.out.println("No rollout changes applied.");
            return false;
        }
    }

    private static boolean validateAndApplyRollout(String parameter, Map<String, String> rolloutTable, String parameterName) {
        if (rolloutTable.containsKey(parameter)) {
            System.out.println(parameterName + "-specific rollout changes applied for: " + parameter);
            return true;
        } else {
            System.out.println("No " + parameterName + "-specific rollout changes for: " + parameter);
            return false;
        }
    }

    public Collection<RollOut> getRollOuts() {
        return rollOuts;
    }

    public static boolean getRolloutByDDD(String ddd, String state) {
        return rolloutDDDTable.containsKey(ddd) && rolloutDDDTable.get(ddd).equals(state);
    }

    public static boolean getRolloutByCity(String city, String state) {
        return rolloutCityTable.containsKey(city) && rolloutCityTable.get(city).equals(state);
    }

    public static boolean getRolloutByState(String state, String cnl) {
        return rolloutStateTable.containsKey(state) && rolloutStateTable.get(state).equals(cnl);
    }

    public List<RollOut> getRolloutByState(String state) {
        List<RollOut> list = new ArrayList<>();

        if(rolloutStateTable.containsKey(state)) {
           for (RollOut rollOut: rollOuts){
               if (rollOut.getState().equals(state))
                   list.add(rollOut);
           }
        }
        return list;
    }

    public RollOut getRolloutByCity(String city) {
        if(rolloutCityTable.containsKey(city)) {
            for (RollOut rollOut: rollOuts){
                if (rollOut.getCity().equals(city))
                    return rollOut;
            }
        }
        return null;
    }

    public List<RollOut> getRolloutByDDD(String ddd) {
        List<RollOut> list = new ArrayList<>();

        if(rolloutDDDTable.containsKey(ddd)) {
            for (RollOut rollOut: rollOuts){
                if (rollOut.getDdd().equals(ddd))
                    list.add(rollOut);
            }
        }
        return list;
    }

    public RollOut getRolloutByCNL(String cnl) {
        if(rolloutCnlTable.containsKey(cnl)) {
            for (RollOut rollOut: rollOuts){
                if (rollOut.getCnl().equals(cnl))
                    return rollOut;
            }
        }
        return null;
    }
}
