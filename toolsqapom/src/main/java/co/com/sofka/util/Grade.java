package co.com.sofka.util;

public enum Grade {
    GRADO1("1"),
    GRADO2("2"),
    GRADO3("3"),
    GRADO4("4"),
    GRADO5("5");

    private final String value;

    Grade(String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}

