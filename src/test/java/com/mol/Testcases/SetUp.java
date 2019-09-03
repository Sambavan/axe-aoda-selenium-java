package com.mol.Testcases;

import com.mol.Pages.*;
import org.testng.annotations.BeforeMethod;


public class SetUp extends BaseTest {
    SearchButtonPage searchButtonPage;


    @BeforeMethod(alwaysRun = true)
    void SelfSetup(){
        searchButtonPage = new SearchButtonPage(driver);

    }
}
