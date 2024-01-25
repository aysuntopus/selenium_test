package testcases.tests;

import org.testng.annotations.Test;
import testcases.pages.DeletePage;
import testcases.resources.Retry;

public class DeleteAccount extends BaseTest {	
	private DeletePage deletePage;
	
	public DeleteAccount() {
		deletePage = new DeletePage();
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void deleteAccount() throws InterruptedException {		
		click(getDeleteButton());
		closeChild();
		assertVisible(deletePage.getSuccessMessage(), "account delete is not seen");
		click(deletePage.getDeleteContinueButton());
	}
}
