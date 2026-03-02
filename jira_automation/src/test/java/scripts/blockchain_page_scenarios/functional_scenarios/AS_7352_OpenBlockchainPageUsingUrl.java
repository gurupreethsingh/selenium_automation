package scripts.blockchain_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.BlockchainPage;

public class AS_7352_OpenBlockchainPageUsingUrl extends OpenClose {

	@Test
	public void testOpenBlockchainPageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("BlockchainPage", 1, 0);

		driver.get(URL_BLOCKCHAIN);

		BlockchainPage page = new BlockchainPage(driver);
		page.verifyBlockchainPageTitle(expectedTitle);
	}
}
