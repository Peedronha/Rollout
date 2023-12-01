package org.example.service;

import org.example.model.Store;

import java.util.HashMap;
import java.util.Map;

public class StoreService {
    private Map<String, String> rolloutTable = new HashMap<>();
    public StoreService() {
        rolloutTable.put("ALAMBARI", "ALAM 11010 ALAMBARI");
        rolloutTable.put("ANGATUBA", "ANG 11028 ANGATUBA");
        rolloutTable.put("ARACOIABA DA SERRA", "ARD 11038 ARACOIABA DA SERRA");
        rolloutTable.put("BOITUVA", "BTV 11109 BOITUVA");
        rolloutTable.put("CAMPINA DO MONTE ALEGRE", "CMAL 11710 CAMPINA DO MONTE ALEGRE");
        rolloutTable.put("CAPELA DO ALTO", "CLT 11146 CAPELA DO ALTO");
        rolloutTable.put("CERQUILHO", "CQO 11161 CERQUILHO");
        rolloutTable.put("CESARIO LANGE", "CEG 11162 CESARIO LANGE");
        rolloutTable.put("GUAREI", "GEI 11253 GUAREI");
        rolloutTable.put("IBIUNA", "IBN 11266 IBIUNA");
        rolloutTable.put("IPERO", "IEO 11280 IPERO");
        rolloutTable.put("ITAPETININGA", "IGA 11292 ITAPETININGA");
        rolloutTable.put("JUMIRIM", "JUMR 11912 JUMIRIM");
        rolloutTable.put("LARANJAL PAULISTA", "LJP 11335 LARANJAL PAULISTA");
        rolloutTable.put("PIEDADE", "PDD 11465 PIEDADE");
        rolloutTable.put("PILAR DO SUL", "PLL 11466 PILAR DO SUL");
        rolloutTable.put("PORANGABA", "PON 11496 PORANGABA");
        rolloutTable.put("PORTO FELIZ", "PRF 11497 PORTO FELIZ");
        rolloutTable.put("QUADRA", "QUDR 12280 QUADRA");
        rolloutTable.put("SALTO DE PIRAPORA", "SPR 11585 SALTO DE PIRAPORA");
        rolloutTable.put("SAO MIGUEL ARCANJO", "SGJ 11569 SAO MIGUEL ARCANJO");
        rolloutTable.put("SARAPUI", "SRP 11593 SARAPUI");
        rolloutTable.put("SOROCABA", "SOC 11609 SOROCABA");
        rolloutTable.put("TAPIRAI", "TIA 11651 TAPIRAI");
        rolloutTable.put("TATUI", "TTI 11660 TATUI");
        rolloutTable.put("TIETE", "TIE 11666 TIETE");
        rolloutTable.put("TORRE DE PEDRA", "TEPD 12276 TORRE DE PEDRA");
        rolloutTable.put("VOTORANTIM", "VOM 11885 VOTORANTIM");
    }
    public Map<String, String> validateGeneral(String state, String city, String ddd, String cnl) {
        Map<String, String> result = new HashMap<>();

        if (state != null && !getRolloutByState(state)) {
            state = null;
        }

        if (city != null && !getRolloutByCity(city)) {
            city = null;
        }

        if (ddd != null && !getRolloutByDDD(ddd)) {
            ddd = null;
        }

        if (cnl != null && !getRolloutByCNL(cnl)) {
            cnl = null;
        }
        result.put("state", state);
        result.put("city", city);
        result.put("ddd", ddd);
        result.put("cnl", cnl);

        return result;
    }

    public void saveStore(Store store) {
    }
    public boolean getRolloutByState(String state) {
        return rolloutTable.containsKey(state);
    }

    public boolean getRolloutByCity(String city) {
        return rolloutTable.containsKey(city);
    }

    public boolean getRolloutByDDD(String ddd) {
        return rolloutTable.containsKey(ddd);
    }

    public boolean getRolloutByCNL(String cnl) {
        return rolloutTable.containsKey(cnl);
    }
}
