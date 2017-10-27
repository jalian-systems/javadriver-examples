package com.jaliansystems.ensemble.test;

import java.io.File;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import ensemble.EnsembleApp;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchType;
import net.sourceforge.marathon.runtime.api.ClassPathHelper;

public class EnsembleWebstartTest {

    public static void main(String[] args) {
        JavaProfile profile = new JavaProfile(LaunchMode.JAVA_WEBSTART);
        profile.setLaunchType(LaunchType.FX_APPLICATION);
        File f = new File(new File(ClassPathHelper.getClassPath(EnsembleApp.class)).getParentFile(), "Ensemble.jnlp");
        profile.setJNLPFile(f);
        profile.setStartWindowTitle("Ensemble");
        profile.setJavaHome("C:\\Program Files\\Java\\jdk1.8.0_121");
        JavaDriver driver = new JavaDriver(profile);

        new WebDriverWait(driver, 100).until(new Function<WebDriver, Boolean>() {
            @Override public Boolean apply(WebDriver driver) {
                List<WebElement> buttons = driver.findElements(By.cssSelector("toggle-button"));
                return buttons.size() > 4;
            }
        });

        List<WebElement> findElements = driver.findElements(By.cssSelector("toggle-button"));
        for (WebElement webElement : findElements) {
            webElement.click();
        }

        driver.quit();
    }

}
