package com.jaliansystems.swingset3.test;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.swingset3.SwingSet3;

import net.sourceforge.marathon.javadriver.ClassPathHelper;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;

public class Swingset3CommandLineTest {

    public static void main(String[] args) {
        JavaProfile profile = new JavaProfile(LaunchMode.COMMAND_LINE);
        File f = new File(new File(ClassPathHelper.getClassPath(SwingSet3.class)).getParentFile(), "swingset3.bat");
        profile.setCommand(f.getAbsolutePath());
        JavaDriver driver = new JavaDriver(profile);

        List<WebElement> buttons = driver.findElements(By.cssSelector("toggle-button"));
        buttons.get(3).click();
        buttons.get(0).click();

        driver.quit();
    }

}
