package testcases.tests;

import org.testng.annotations.Test;
import testcases.pages.DeletePage;

public class DeleteAccount extends BaseTest {	
	private DeletePage deletePage;
	
	public DeleteAccount() {
		deletePage = new DeletePage();
	}
	
	@Test
	public void deleteAccount() throws InterruptedException {		
		click(getDeleteButton());
		closeChild();
		assertVisible(deletePage.getSuccessMessage(), "account delete is not seen");
		click(deletePage.getDeleteContinueButton());
	}
}
