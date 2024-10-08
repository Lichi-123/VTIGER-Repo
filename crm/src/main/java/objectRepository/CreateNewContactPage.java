package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateNewContactPage {
	
	WebDriver driver;

	public void NewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



@FindBy(name= "lastname")
private WebElement lastname;

@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
private WebElement newOrgInContact;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement save;

@FindBy(name = "support_start_date")
private WebElement startDate;

@FindBy(name = "support_end_date")
private WebElement endDate;

@FindBy(name = "search_text")
private WebElement searchBar;

@FindBy(name = "search")
private WebElement searchBtn;

    @FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
private WebElement orgIncontact;
    
    


   
    public void setDriver(WebDriver driver) {
    	this.driver = driver;
    }

    public void setLastname(WebElement lastname) {
    	this.lastname = lastname;
    }

    public void setNewOrgInContact(WebElement newOrgInContact) {
    	this.newOrgInContact = newOrgInContact;
    }

    public void setSave(WebElement save) {
    	this.save = save;
    }

    public void setStartDate(WebElement startDate) {
    	this.startDate = startDate;
    }

    public void setEndDate(WebElement endDate) {
    	this.endDate = endDate;
    }

    public void setSearchBar(WebElement searchBar) {
    	this.searchBar = searchBar;
    }

    public void setSearchBtn(WebElement searchBtn) {
    	this.searchBtn = searchBtn;
    }

    public void setOrgIncontact(WebElement orgIncontact) {
    	this.orgIncontact = orgIncontact;
    }
    
    }