package test.main.utils;

import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataRepository {

    Properties properties;

    public DataRepository() {

        try {
            String file = System.getProperty("user.dir")+"/src/test/resources/objectRepository/android/androidObjects.properties";
            FileInputStream locator = new FileInputStream(file);
            properties = new Properties();
            properties.load(locator);
        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
            e.getCause();
        }

    }

    public String getData(String ElementName) throws Exception {
        // Read value using the logical name as Key
        String data = properties.getProperty(ElementName);
        return data;
    }

    public By getLocator(String ElementName) throws Exception {
        // Read value using the logical name as Key
        String locator = properties.getProperty(ElementName);
        System.out.println("Locator---"+ locator);
        // Split the value which contains locator type and locator value
        String locatorType = locator.split("=")[0];
        System.out.println("locatorType---"+ locatorType);
        String locatorValue = locator.split("=")[1];
        // Return a instance of By class based on type of locator
        if (locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if (locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if ((locatorType.toLowerCase().equals("classname"))
                || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("tagname"))
                || (locatorType.toLowerCase().equals("tag")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("linktext"))
                || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if (locatorType.toLowerCase().equals("partiallinktext"))
            return By.partialLinkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("cssselector"))
                || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if (locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else
            throw new Exception("Locator type '" + locatorType
                    + "' not defined!!");
    }

}