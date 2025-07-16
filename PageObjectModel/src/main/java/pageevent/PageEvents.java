package pageevent;


import pageobject.Pageobject;
import utils.Elementfetch;

public class PageEvents {
    Elementfetch k = new Elementfetch();
   
    public void young() {
        k.getWebElement("xpath", Pageobject.Login).click();
    }
    public void woung() {
        k.getWebElement("xpath", Pageobject.EnterPhone).sendKeys("6300164367");
     
    }
    public void king() {
    	k.getWebElement("xpath", Pageobject.requestotp).click();
    }
}
