package scripts.reply_message_page_scenarios.functional_scenarios;

import java.io.IOException;

import org.testng.annotations.Test;

import generic.Excel;
import generic.OpenClose;
import pom.ReplyMessagePage;

public class AS_7421_OpenReplyMessagePageUsingUrl extends OpenClose {

	@Test
	public void testOpenReplyMessagePageUsingUrl() throws IOException {
		String expectedTitle = (String) Excel.getData("ReplyMessagePage", 1, 0);

		driver.get(URL_REPLY_MESSAGE_BASE + "000000000000000000000000");

		ReplyMessagePage page = new ReplyMessagePage(driver);
		page.verifyReplyMessagePageTitle(expectedTitle);
	}
}
