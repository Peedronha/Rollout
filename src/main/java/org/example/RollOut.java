package org.example;

public class RollOut {

    private String state;
    private String city;
    private String ddd;
    private String cnl;

    public RollOut(String state, String city, String ddd, String cnl) {
        this.state = state;
        this.city = city;
        this.ddd = ddd;
        this.cnl = cnl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getCnl() {
        return cnl;
    }

    public void setCnl(String cnl) {
        this.cnl = cnl;
    }

    public static void main(String[] args) {
        // Example usage:
        RollOut rolloutInstance = new RollOut("Sao Paulo", "Sorocaba", "11", "SOC");

        // Accessing parameters using getters
        System.out.println("State: " + rolloutInstance.getState());
        System.out.println("City: " + rolloutInstance.getCity());
        System.out.println("DDD: " + rolloutInstance.getDdd());
        System.out.println("CNL: " + rolloutInstance.getCnl());
    }
}
