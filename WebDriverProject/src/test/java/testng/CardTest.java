package testng;

import org.testng.annotations.Test;

public class CardTest extends BaseClass  {

@Test(groups= {"sanity"})
public void TC01_CreditCardTest()
{
	System.out.println("Inside credit card test");
}

}
