package myprojects.automation.assignment3.tests;

import myprojects.automation.assignment3.BaseScript;
import myprojects.automation.assignment3.GeneralActions;
import myprojects.automation.assignment3.PageElementAction;

public class CreateCategoryTest extends BaseScript {

    public static void main(String[] args) {
        String categoryName = "Stuff";
        GeneralActions.login("webinar.test@gmail.com", "Xcg7299bnSmMuRLp9ITw");
        GeneralActions.createCategory(categoryName);
        PageElementAction.set("[name = \"categoryFilter_name\"]", categoryName);
        PageElementAction.click("[name = \"submitFilter\"]");
        PageElementAction.verifyElementWithTextPresent("tbody tr:nth-of-type(1) td:nth-of-type(3)", categoryName);
        GeneralActions.logout();
    }
}
