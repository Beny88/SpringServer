package com.tomson.dto;

/**
 * Data Transfer object
 */
public class UpdateAddressDto {
    private Long id;

    private String ulica;
    private String nrUlicy;
    private String postCode;
    private String miasto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrUlicy() {
        return nrUlicy;
    }

    public void setNrUlicy(String nrUlicy) {
        this.nrUlicy = nrUlicy;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
}
