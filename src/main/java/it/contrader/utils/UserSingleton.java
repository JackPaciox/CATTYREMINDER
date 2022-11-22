package it.contrader.utils;

import it.contrader.service.LoginService;

public class UserSingleton {

    private int id;

    private int superAdminId;
    private String userType;
    private String username;
    private String password;
    private boolean isFilterSearchActive = false;

    private int centerId;
    private boolean logged = false;

    private boolean admin = false;

    private boolean superadmin = false;

    public boolean isSuperadmin() {
        return superadmin;
    }

    public void setSuperadmin(boolean superadmin) {
        this.superadmin = superadmin;
    }

    public boolean isFilterSearchActive() {
        return isFilterSearchActive;
    }

    public void setFilterSearchActive(boolean filterSearchActive) {
        isFilterSearchActive = filterSearchActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void resetSuperAdminId() {
        this.setId(this.superAdminId);
    }
    private static UserSingleton userSingleton = null ;

    private UserSingleton() {
    }

    public static UserSingleton getInstance(){
        if (userSingleton == null) {
            userSingleton = new UserSingleton();
        }
        return userSingleton;
    }

    public static void initSingleton () {
        userSingleton = null;
    }
}