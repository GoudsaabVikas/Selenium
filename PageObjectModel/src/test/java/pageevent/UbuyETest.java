package pageevent;

import org.testng.annotations.Test;

import base_test.Basetest;
import utils.Elementfetch;

public class UbuyETest extends Basetest{
	Elementfetch k = new Elementfetch();
	UbuyE a= new UbuyE();

  @Test
  public void UbuybtnTest() {
    a.Ubuybtn();
   
    a.Click();
    a.Boat();
   
  }
}
