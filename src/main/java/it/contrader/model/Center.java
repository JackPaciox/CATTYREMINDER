package it.contrader.model;

import java.util.Objects;

/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Center {


    /**
     * Qui sotto definisco gli attributi di Center.
     */
    private int id;

    private int user_id;

    private String centername;

    private String centeraddress;

    private String centercity;

    private String centerprovince;
    /**
     * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Center
     */
    public Center() {

    }

    public Center(int user_id, String centername, String centeraddress, String centercity, String centerprovince) {
        this.user_id = user_id;
        this.centername = centername;
        this.centeraddress = centeraddress;
        this.centercity = centercity;
        this.centerprovince = centerprovince;
    }

    public Center(int id, int user_id, String centername, String centeraddress, String centercity, String centerprovince) {
        this.id = id;
        this.user_id = user_id;
        this.centername = centername;
        this.centeraddress = centeraddress;
        this.centercity = centercity;
        this.centerprovince = centerprovince;
    }

    /**
     * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Center
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCentername() {
        return centername;
    }

    public void setCentername(String centername) {
        this.centername = centername;
    }

    public String getCenteraddress() {
        return centeraddress;
    }

    public void setCenteraddress(String centeraddress) {
        this.centeraddress = centeraddress;
    }

    public String getCentercity() {
        return centercity;
    }

    public void setCentercity(String centercity) {
        this.centercity = centercity;
    }

    public String getCenterprovince() {
        return centerprovince;
    }

    public void setCenterprovince(String centerprovince) {
        this.centerprovince = centerprovince;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Center center = (Center) o;

        if (id != center.id) return false;
        if (user_id != center.user_id) return false;
        if (!Objects.equals(centername, center.centername)) return false;
        if (!Objects.equals(centeraddress, center.centeraddress))
            return false;
        if (!Objects.equals(centercity, center.centercity)) return false;
        return Objects.equals(centerprovince, center.centerprovince);
    }

}

