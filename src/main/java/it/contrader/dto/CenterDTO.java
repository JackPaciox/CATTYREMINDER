package it.contrader.dto;

public class CenterDTO implements DTO {

    private int id;

    private String centername;

    private String centeraddress;

    private String centercity;

    private String centerprovince;

    private int user_id;

    public CenterDTO() {

    }

    public CenterDTO (int user_id, String centername, String centeraddress, String centercity, String centerprovince) {
        this.user_id = user_id;
        this.centername = centername;
        this.centeraddress = centeraddress;
        this.centercity = centercity;
        this.centerprovince = centerprovince;
    }

    public CenterDTO (int id, int user_id, String centername, String centeraddress, String centercity, String centerprovince) {
        this.id = id;
        this.centername = centername;
        this.centeraddress = centeraddress;
        this.centercity = centercity;
        this.centerprovince = centerprovince;
        //da modificare in center_id anche su db.
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    @Override
    public String toString() {
        return  id + "\t"  + centername +"\t\t" +   centeraddress + "\t\t" + centercity + "\t\t" + centerprovince;
    }


}
