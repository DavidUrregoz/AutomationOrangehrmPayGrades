package co.com.sofka.page.orangehrmpaygrades;

import co.com.sofka.model.orangehrmpaygrades.OrangehrmPayGradesModel;
import co.com.sofka.page.common.CommonActionsOnPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;


public class OrangehrmPayGrades extends CommonActionsOnPages{
    private static final Logger LOGGER = Logger.getLogger(OrangehrmPayGrades.class);
    private OrangehrmPayGradesModel orangehrmPayGradesModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


//    @FindBy(id = "txtUsername")
//    @CacheLookup
//    private WebElement user;
//
//    @FindBy(id = "txtPassword")
//    @CacheLookup
//    private WebElement password;
//
//    @FindBy(id = "btnLogin")
//    @CacheLookup
//    private WebElement btnLogin;



    @FindBy(id= "menu_admin_viewAdminModule")
    @CacheLookup
    private WebElement adminMenu;

    @FindBy(id = "menu_admin_Job")
    @CacheLookup
    private WebElement subJob;

    @FindBy(id = "menu_admin_viewPayGrades")
    @CacheLookup
    private WebElement subPayGrades;

    private final By grade = By.xpath("//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]/a");

    @FindBy(id = "btnAddCurrency")
    @CacheLookup
    private WebElement btnAddCurrency;

    @FindBy(id = "payGradeCurrency_currencyName")
    @CacheLookup
    private WebElement moneda;

    @FindBy(id = "payGradeCurrency_minSalary")
    @CacheLookup
    private WebElement minSalary;

    @FindBy(id = "payGradeCurrency_maxSalary")
    @CacheLookup
    private WebElement maxSalary;


    @FindBy(id = "btnSaveCurrency")
    @CacheLookup
    private WebElement btnGuardar;
    //For Assertions test case.

    public boolean isAddDone(String divisa){
        List<WebElement> listaFilas = getResultTable("tblCurrencies");
        return validateDivisaFiltered(listaFilas,divisa);
    }



    public OrangehrmPayGrades(WebDriver driver, OrangehrmPayGradesModel orangehrmPayGradesModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.orangehrmPayGradesModel = orangehrmPayGradesModel;
    }
    public OrangehrmPayGrades(WebDriver driver, OrangehrmPayGradesModel orangehrmPayGradesModel, int secondsForExplicitWait) {
        super(driver, secondsForExplicitWait);
        pageFactoryInitElement(driver,this);
        if(orangehrmPayGradesModel == null)
            LOGGER.warn(MODEL_NULL_MESSAGE);
        this.orangehrmPayGradesModel= orangehrmPayGradesModel;
    }


    public void desplegarPayGrades()throws IOException{
        try{
            //scrollTo(adminMenu);
            withExplicitWaitClickOn(adminMenu);

            //scrollTo(subJob);
            withExplicitWaitClickOn(subJob);


            //scrollTo(subPayGrades);
            withExplicitWaitClickOn(subPayGrades);

            //scrollTo(grade);
            withExplicitWaitClickOn(grade);

            //scrollTo(btnAddCurrency);
            withExplicitWaitClickOn(btnAddCurrency);

            scrollTo(moneda);
            withExplicitWaitClear(moneda);
            withExplicitWaitTypeInto(moneda, orangehrmPayGradesModel.getMoneda());
            withExplicitWaitTypeInto(moneda, Keys.TAB);

            scrollTo(minSalary);
            withExplicitWaitClear(minSalary);
            withExplicitWaitTypeInto(minSalary, orangehrmPayGradesModel.getSalarioMinimo());
            withExplicitWaitTypeInto(moneda, Keys.TAB);

            scrollTo(maxSalary);
            withExplicitWaitClear(maxSalary);
            withExplicitWaitTypeInto(maxSalary, orangehrmPayGradesModel.getSalarioMaximo());
            withExplicitWaitTypeInto(maxSalary, Keys.TAB);

            //scrollTo(btnGuardar);
            withExplicitWaitClickOn(btnGuardar);

        } catch (Exception exception){
            LOGGER.warn(exception.getMessage());
        }
    }

    public List<WebElement> getResultTable(String idLista){
        WebElement table = findElement(By.id(idLista));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        return allRows;
    }

    public boolean validateDivisaFiltered(List<WebElement> allRows, String divisa){
        for (WebElement row : allRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int i = 0;
            for (WebElement cell : cells) {
                if(i==1 && cell.getText().equalsIgnoreCase(divisa)){
                    return true;
                }
                i++;
            }
        }
        return false;
    }






}
