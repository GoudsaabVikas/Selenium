package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base_test.Basetest;

public class Elementfetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase()) {
            case "XPATH":
                return Basetest.driver.findElement(By.xpath(identifierValue));
            case "CSS":
                return Basetest.driver.findElement(By.cssSelector(identifierValue));
            case "ID":
                return Basetest.driver.findElement(By.id(identifierValue));
            case "NAME":
                return Basetest.driver.findElement(By.name(identifierValue));
            case "TAGNAME":
                return Basetest.driver.findElement(By.tagName(identifierValue));
            case "LINKTEXT":
                return Basetest.driver.findElement(By.linkText(identifierValue));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + identifierType);
        }
    }

    public List<WebElement> getWebElements(String identifierType, String identifierValue) {
        switch (identifierType.toUpperCase()) {
            case "XPATH":
                return Basetest.driver.findElements(By.xpath(identifierValue));
            case "CSS":
                return Basetest.driver.findElements(By.cssSelector(identifierValue));
            case "ID":
                return Basetest.driver.findElements(By.id(identifierValue));
            case "NAME":
                return Basetest.driver.findElements(By.name(identifierValue));
            case "TAGNAME":
                return Basetest.driver.findElements(By.tagName(identifierValue));
            case "LINKTEXT":
                return Basetest.driver.findElements(By.linkText(identifierValue));
            default:
                throw new IllegalArgumentException("Invalid locator type: " + identifierType);
        }
    }

    public void checkBrokenLinks(String identifierType, String identifierValue) {
        List<WebElement> links = getWebElements(identifierType, identifierValue);
        int validLinks = 0;
        int invalidLinks = 0;

        if (links == null || links.isEmpty()) {
            System.out.println("No links found.");
            return;
        }

        for (WebElement link : links) {
            String url = link.getAttribute("href");

            if (url == null || url.isEmpty()) {
                System.out.println("Empty or null href found.");
                invalidLinks++;
                continue;
            }

            try {
                HttpURLConnection connection = (HttpURLConnection) (new URL(url).openConnection());
                connection.setRequestMethod("HEAD");
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);
                connection.connect();

                int responseCode = connection.getResponseCode();
                if (responseCode >= 400) {
                    System.out.println("Broken link: " + url + " -> " + responseCode);
                    invalidLinks++;
                } else {
                    System.out.println("Valid link: " + url + " -> " + responseCode);
                    validLinks++;
                }

            } catch (Exception e) {
                System.out.println("Exception for URL: " + url + " -> " + e.getMessage());
                invalidLinks++;
            }
        }

        System.out.println("Total Valid Links: " + validLinks);
        System.out.println("Total Invalid Links: " + invalidLinks);
    }
}
