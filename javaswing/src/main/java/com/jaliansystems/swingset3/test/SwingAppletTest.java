package com.jaliansystems.swingset3.test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sun.swingset3.SwingSet3;

import net.sourceforge.marathon.javadriver.ClassPathHelper;
import net.sourceforge.marathon.javadriver.JavaDriver;
import net.sourceforge.marathon.javadriver.JavaProfile;
import net.sourceforge.marathon.javadriver.JavaProfile.LaunchMode;

public class SwingAppletTest {

    public static void main(String[] args) {
        JavaProfile profile = new JavaProfile(LaunchMode.JAVA_APPLET);
        File f = new File(new File(ClassPathHelper.getClassPath(SwingSet3.class)).getParentFile(), "applet.html");
        profile.setAppletURL(f.getAbsolutePath());
        JavaDriver driver = new JavaDriver(profile);

        WebElement tf = driver.findElement(By.cssSelector("text-field"));
        tf.sendKeys("cat");

        driver.quit();
    }
}
