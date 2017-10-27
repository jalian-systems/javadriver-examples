package com.jaliansystems.ensemble.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ensemble.EnsembleApp;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchType;
import net.sourceforge.marathon.runtime.api.ClassPathHelper;

public class EnsembleCommandLineTest {

    public static void main(String[] args) {
        JavaProfile profile = new JavaProfile(LaunchMode.COMMAND_LINE);
        profile.setLaunchType(LaunchType.FX_APPLICATION);
        File f = new File(new File(ClassPathHelper.getClassPath(EnsembleApp.class)).getParentFile(), "ensemble.bat");
        profile.setCommand(f.getAbsolutePath());
        JavaDriver driver = new JavaDriver(profile);

        WebElement findElement = driver.findElement(By.cssSelector("button[text = 'FXML Login Demo']"));
        findElement.click();

        WebElement userNameField = driver.findElement(By.cssSelector("text-field[id = 'textField1']"));
        userNameField.sendKeys("demo");

        WebElement passwordField = driver.findElement(By.cssSelector("password-field[id = 'passwordField1']"));
        passwordField.sendKeys("demo");

        WebElement loginButton = driver.findElement(By.cssSelector("button[text = 'Login']"));
        loginButton.click();

        driver.quit();
    }

}
