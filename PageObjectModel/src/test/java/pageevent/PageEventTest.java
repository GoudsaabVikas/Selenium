package pageevent;

import org.testng.annotations.Test;

import base_test.Basetest;
import utils.Elementfetch;


public class PageEventTest extends Basetest{
	Elementfetch INk= new Elementfetch();
	PageEvents I = new PageEvents();
  @Test
  public void f() {
	 I.young(logger);
	 I.woung(logger);
  }
}
