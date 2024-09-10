package stepDefinition;

import PageObject.GolfCoursesPage;
import PageObject.WebElementPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GolfCourses {
    WebDriver driver;
    GolfCoursesPage golfCourse;

    public GolfCourses(){
        driver = Hooks.driver;
        golfCourse = new GolfCoursesPage(driver);
    }
    @And("Click on GolfCourse")
    public void clickOnGolfCourse() {
        golfCourse.clickOnGolfCourses();
    }

    @Then("Verify navigate to GolfCoursePage successful")
    public void verifyNavigateToGolfCoursePageSuccessful() {
        assert(golfCourse.getTitlePage().contains("Golf Courses"));
    }

    @When("Input GolfCourses name {string}")
    public void inputGolfCoursesName(String name) {
        golfCourse.inputGolfCoursesName(name);
    }

    @And("Click on search button")
    public void clickOnSearchButton() {
        golfCourse.clickSearchButton();
    }

    @Then("Verify result list contain name {string}")
    public void verifyResultListContain(String name) {
        String[] result = golfCourse.handleTableResultName();

        for (int i = 0; i < result.length; i++) {
//            Assert.assertEquals(expectedResult[i], result[i]);
            System.out.println(result[i]);
            Assert.assertTrue(golfCourse.arrayContainsString(result, name ));
        }
    }

    @When("Select country {string} at selected button")
    public void selectCountryAtSelectedButton(String country) {
        golfCourse.selectCountry(country);
    }

    @And("Click on Filter button")
    public void clickOnFilterButton() {
        golfCourse.clickFilterButton();
    }

    @Then("Verify result list contain country {string}")
    public void verifyResultListContainCountry(String country) {
        String[] result = golfCourse.handleTableResultCountry();

        for (int i = 0; i < result.length; i++) {
//            Assert.assertEquals(expectedResult[i], result[i]);
            System.out.println(result[i]);
            Assert.assertTrue(golfCourse.arrayContainsString(result, country ));
        }
    }
}
