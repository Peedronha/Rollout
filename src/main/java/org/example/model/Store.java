package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Store {
    private String estado;

    private String cidade;

    private String DDD;

    private String cnl;

    public Store(String estado, String cidade, String DDD, String cnl) {
        this.estado = estado;
        this.cidade = cidade;
        this.DDD = DDD;
        this.cnl = cnl;
    }

    public Store() {

    }
}
