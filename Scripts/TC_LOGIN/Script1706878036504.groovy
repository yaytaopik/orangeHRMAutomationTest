import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('')

WebUI.delay(3)

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/input_username'), Username)

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/p_Password  admin123'))

//WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/Page_OrangeHRM/input_password'), Password)

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))

//findTestObject('Object Repository/Page_OrangeHRM/span_Required_username')

//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_OrangeHRM/span_Required_username'), 3)

WebUI.delay(3)


if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_OrangeHRM/h6_Entering_Dashboard_acceptance'),FailureHandling.CONTINUE_ON_FAILURE)) {
	KeywordUtil.markPassed("Success!")
	WebUI.delay(3)
	WebUI.takeFullPageScreenshot()
	WebUI.delay(3)
	WebUI.closeBrowser()
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_OrangeHRM/span_Required_password'),FailureHandling.CONTINUE_ON_FAILURE)) {
	KeywordUtil.markFailed("Failed, password is required!")
	WebUI.delay(3)
	WebUI.takeFullPageScreenshot()
	WebUI.delay(3)
	WebUI.closeBrowser()
} else if (WebUI.verifyElementVisible(findTestObject('Object Repository/Page_OrangeHRM/span_Required_username'),FailureHandling.CONTINUE_ON_FAILURE)) {
	KeywordUtil.markFailed("Failed, username required!")
	WebUI.delay(3)
	WebUI.takeFullPageScreenshot()
	WebUI.delay(3)
	WebUI.closeBrowser()
}
	
