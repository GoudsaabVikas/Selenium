package pageevent;



import pageobject.Ubuyob;
import utils.Elementfetch;

public class UbuyE {
	 Elementfetch k = new Elementfetch();
	

	    public void Ubuybtn() {
	    k.getWebElement("xpath", Ubuyob.brands).click();
	    }


	    
	    public void Click() {
	   k.getWebElement("xpath", Ubuyob.clicke).click();
	   	
	   	
	   }

		public void Boat() {
			   k.getWebElement("xpath", Ubuyob.Boat).click();
			   	
			
		}
		public void King() {
			   k.getWebElement("xpath", Ubuyob.k).click();
			   	
			
		}


	}

