package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.GenericMethods;

public class Application {
	
	
	@Test
	public void invalidLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelMay25\\TestData.xlsx", "Sheet2");
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
				case "openBrowser":
					Methods.openBrowser();
					break;
				case "maxBrowser":
					Methods.maximizeBrowserWindow();
					break;
				case "impWait":
					Methods.implementImplicitWait();
					break;
				case "navigateToAUT":
					Methods.navigateToAUT(data[i][6]);
					break;
				case "enterUserID":
					Methods.enterUserID(data[i][4],data[i][5], data[i][6]);
					break;
				case "enterPassword":
					Methods.enterPassword(data[i][4],data[i][5], data[i][6]);
					break;
				case "clickLogin":
					Methods.clickButton(data[i][4],data[i][5]);
					break;
				case "verifyErrMsg":
					String actualMsg = Methods.getErrorMsg(data[i][5]);
					String expectedMsg = data[i][6];
					Assert.assertEquals(actualMsg, expectedMsg);
					System.out.println("Validation for "+data[i][2]+" passed");
					break;
				case "closeApplication":
					Methods.closeApplication();
					break;
			}
		}
		
		
			
		
		
	}

}
