package co.com.sofka.util;

public enum Divisas {
    AFN("Afghanistan Afghani"),
    ALL("Albanian Lek"),
    AOR("Angolan New Kwanza"),
    ARP("Argentina Pesos"),
    AUD("Australian Dollar"),
    USD("United States Dollar"),
    COP("Colombian Peso"),
    CAD("Canadian Dollar"),
    CLP("Chilean Peso"),
    CNY("Chinese Yuan Renminbi"),
    EUR("Euro");

    private final String value;

    Divisas(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }

}
