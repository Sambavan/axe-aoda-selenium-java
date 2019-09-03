package com.mol.Testcases;

import com.deque.axe.AXE;
import com.mol.Pages.SearchButtonPage;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.rules.TestName;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SearchButtonTests extends BaseTest {

    SearchButtonPage searchButtonPage;
    public TestName testName = new TestName();


    private static final URL scriptUrl = AODATest.class.getResource("/axe.min.js");

    @BeforeMethod
    private void setUp() {
        searchButtonPage = new SearchButtonPage(driver);
    }

    @Test
    public void whenOnHomePage_SearchButtonsAreVisibleWithTheCorrectText() {
        Assert.assertEquals(searchButtonPage.getSearchButtonText(), "Google Search");
        Assert.assertEquals(searchButtonPage.getFeelingLuckyButtonText(), "I'm Feeling Lucky");
    }

    @Test
    public void testAccessibility() {

        JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();

        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            assertTrue("No violations found", true);
        } else {
            AXE.writeResults(testName.getMethodName(), responseJSON);
            assertTrue(AXE.report(violations), false);
        }
    }


}
