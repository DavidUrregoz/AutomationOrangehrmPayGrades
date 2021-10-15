package co.com.sofka.model.orangehrmpaygrades;

import co.com.sofka.util.Divisas;
import co.com.sofka.util.Grade;
import org.python.antlr.ast.Str;

public class OrangehrmPayGradesModel {
    private Grade grado;
    private Divisas moneda;
    private String salarioMinimo;
    private String salarioMaximo;

    public String getGrado() {
        return grado.getValue();
    }

    public void setGrado(Grade grado) {
        this.grado = grado;
    }

    public String getMoneda() {
        return moneda.getValue();
    }

    public void setMoneda(Divisas moneda) {
        this.moneda = moneda;
    }

    public String getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(String salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public String getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(String salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }
}
