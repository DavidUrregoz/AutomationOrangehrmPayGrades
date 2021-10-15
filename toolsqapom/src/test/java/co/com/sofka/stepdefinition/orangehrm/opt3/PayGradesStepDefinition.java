package co.com.sofka.stepdefinition.orangehrm.opt3;

import co.com.sofka.model.orangehrmpaygrades.OrangehrmLoginModel;
import co.com.sofka.model.orangehrmpaygrades.OrangehrmPayGradesModel;
import co.com.sofka.page.orangehrmpaygrades.OrangehrmPayGrades;
import co.com.sofka.page.orangehrmpaygrades.OrangehtmLogin;
import co.com.sofka.stepdefinition.setup.WebUI;

import co.com.sofka.util.Divisas;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.util.Grade.*;
import static co.com.sofka.util.Divisas.*;

import static co.com.sofka.util.Seconds.TEN_SECONDS;

public class PayGradesStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(PayGradesStepDefinition.class);

    private OrangehrmLoginModel orangehrmLoginModel;
    private OrangehrmPayGradesModel orangehrmPayGradesModel;
    private OrangehtmLogin orangehtmLogin;
    private OrangehrmPayGrades orangehrmPayGrades;
    private static final String ASSERTION_EXCEPTION_MESSAGE = "Los valores suministrados no son los esperados.";


    @Given("el empleado administrativo se encuentra logueado en la web de OrangeHRM")
    public void elEmpleadoAdministrativoSeEncuentraLogueadoEnLaWebDeOrangeHRM() {
        try{
            generalSetUp();
            dataCorrectConfiguration();
            orangehtmLogin = new OrangehtmLogin(driver,orangehrmLoginModel,TEN_SECONDS.getValue());
            orangehtmLogin.llenarLogin();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @When("el empleado administrativo se encuentre en la seccion de Job Pay Grades y modifique los grados de pago ya establecidos.")
    public void elEmpleadoAdministrativoSeEncuentreEnLaSeccionDeJobPayGradesYModifiqueLosGradosDePagoYaEstablecidos() {
        try {
            dataCorrectConfiguration2();
            orangehrmPayGrades = new OrangehrmPayGrades(driver,orangehrmPayGradesModel,TEN_SECONDS.getValue());

            orangehrmPayGrades.desplegarPayGrades();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    @Then("el sistema debe guardar exitosamente los cambios anteriormente realizados.")
    public void elSistemaDebeGuardarExitosamenteLosCambiosAnteriormenteRealizados() {
        try {
            Assertions.assertFalse(
                    orangehrmPayGrades.isSpamMessage(),
                    ASSERTION_EXCEPTION_MESSAGE
            );
            Assertions.assertTrue(
                orangehrmPayGrades.isAddDone(orangehrmPayGradesModel.getMoneda()),
                ASSERTION_EXCEPTION_MESSAGE
            );
            quitDriver();
        } catch (Exception exception){
            quitDriver();
            LOGGER.error(exception.getMessage(), exception);
            Assertions.fail(exception.getMessage());
        }
    }

    private void dataCorrectConfiguration(){
        orangehrmLoginModel = new OrangehrmLoginModel();
        orangehrmLoginModel.setUser("Admin");
        orangehrmLoginModel.setPassword("admin123");

    }

    private void dataCorrectConfiguration2(){
        orangehrmPayGradesModel = new OrangehrmPayGradesModel();
        orangehrmPayGradesModel.setGrado(GRADO2);
        orangehrmPayGradesModel.setMoneda(CAD);
        orangehrmPayGradesModel.setSalarioMinimo("100000");
        orangehrmPayGradesModel.setSalarioMaximo("150000");

    }

}
