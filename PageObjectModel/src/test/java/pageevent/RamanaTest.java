package pageevent;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import base_test.Basetest;
import utils.Elementfetch;

public class RamanaTest extends Basetest {
	Elementfetch INk= new Elementfetch();
	Ramana I = new Ramana();

  @Test
  public void LoginTest() {
  I.Login(logger);
  I.enterPhoneNumber(logger,"6300164367");
    
  }
}
