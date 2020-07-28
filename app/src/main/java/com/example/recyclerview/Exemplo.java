package com.example.recyclerview;

import java.io.Serializable;

public class Exemplo implements Serializable {

    private Long id;
    private String nomeExeplo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeExeplo() {
        return nomeExeplo;
    }

    public void setNomeExeplo(String nomeExeplo) {
        this.nomeExeplo = nomeExeplo;
    }
}
