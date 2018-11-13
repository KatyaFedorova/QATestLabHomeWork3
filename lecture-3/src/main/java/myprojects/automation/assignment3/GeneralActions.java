package myprojects.automation.assignment3;

import myprojects.automation.assignment3.utils.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralActions extends PageElementAction {

    public static void login(String login, String password) {
        openUrl(Properties.getBaseAdminUrl());
        set("[name = \"email\"]", login);
        set("[name = \"passwd\"]", password);
        click("[name = \"submitLogin\"]");
    }

    public static void createCategory(String categoryName) {
        hover("[id = \"subtab-AdminCatalog\"]");
        click(".submenu.outOfBounds [id = \"subtab-AdminCategories\"]");
        click(".process-icon-new");
        set("[name = \"name_1\"]", categoryName);
        click("process-icon-save");
        verifyElementWithTextPresent(".alert.alert-success:not(.hide)", "Создано");
    }

    public static void logout() {
        click(".employee_avatar_small");
        click("[id = \"header_logout\"]");
    }

}
