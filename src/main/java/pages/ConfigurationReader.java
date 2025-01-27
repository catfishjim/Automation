package pages;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
/*
to read and load the configuration data only one time.After the first call,
we get the ConfigurationReader instance/object via getInstance() method.
 */
public class ConfigurationReader {
    /*
    below variables were constant variable and fetching value from config.properties file.
     */
    public static final String propertyTimeOutInSeconds = "timeout.seconds";
    public static final String driverOption = null != System.getProperty("browser") ?
            System.getProperty("browser") : "chrome";
    public static final boolean headless = Boolean.parseBoolean(System.getProperty("headless"));
    public static final String propertyBaseUrlAdmin = "base.url.admin";
    public static final String propertyBaseUrlMarketing = "base.url.marketing";
    public static final String propertyBaseUrlClient = "base.url.client";
    public static final String propertyAdminUserName = "hugo.admin.username";
    public static final String propertyAdminPassword = "hugo.admin.password";
    public static final String propertyCandidatePassword = "hugo.candidate.password";
    public static final String publicURLVerifyProfile = "hugo.url.verify.profile";
    public static final String propertyReceiverAddress = "receivers.address";
    public static final String eventUtilityIP = "hugo.event.utility.ip";
    public static final String chromeDriverPath = "hugo.chrome.driver.path";
    private static final String propertyFilePath = "config.properties";
    private static final String environment = null != System.getProperty("testEnvironment") ?
            System.getProperty("testEnvironment") : "";
    private static ConfigurationReader instance = null;
    private Properties properties;  // Properties class represents a persistent set of properties


    //constructor to read property filepath through buffer reader object
    private ConfigurationReader() {
        BufferedReader bufferedReader;
        System.out.println(propertyFilePath);
        try {
            bufferedReader = new BufferedReader(new FileReader(propertyFilePath));
            populateProperties(bufferedReader);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            throw new RuntimeException(String.format("Configuration Properties not found at %s.", propertyFilePath));
        }
    }
    //Create a Singleton instance. We need only one instance of Configuration Reader.
    public static ConfigurationReader getInstance() {
        if (null == instance) {
            instance = new ConfigurationReader();
        }

        return instance;
    }
    //Get all configuration data and assign to related fields.
    private void populateProperties(BufferedReader bufferedReader) {
        properties = new Properties();
        try {
            properties.load(bufferedReader);
            bufferedReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String getEnvironmentVariable(String environmentVariableKey) {
        return System.getenv(environmentVariableKey);
    }
    //getProperty Method to get details from environment variable
    public String getProperty(String propertyKey) {
        String envPropertyKey = environment.isEmpty() ? propertyKey : environment + "." + propertyKey;
        String propertyValue = properties.getProperty(envPropertyKey);

        if (StringUtils.isEmpty(propertyValue)) {
            System.out.printf("'%s' is not defined in %s, will try non-environment specific property.%n",
                    envPropertyKey, propertyFilePath);
            propertyValue = properties.getProperty(propertyKey);
            if (StringUtils.isEmpty(propertyValue)) {
                throw new RuntimeException(String.format("'%s' not defined in %s", envPropertyKey, propertyFilePath));
            }
        }

        return propertyValue;
    }

    public int getIntProperty(String propertyKey) {
        String propertyValue = getProperty(propertyKey);

        return Integer.parseInt(propertyValue);
    }

    public boolean getBooleanProperty(String propertyKey) {
        String propertyValue = getProperty(propertyKey);
        return null == propertyKey ? false : Boolean.parseBoolean(propertyValue);
    }

    public String getAdminURL() {
        if (!environment.equals("") && !environment.equals("qa")){
            return getProperty(propertyBaseUrlAdmin);
        }
        else{
            return getEnvironmentVariable(getProperty(propertyBaseUrlAdmin));
        }
    }

    public String getPublicURL() {
        if (!environment.equals("") && !environment.equals("qa")){
            return getProperty(propertyBaseUrlMarketing);
        }
        else{
            return getEnvironmentVariable(getProperty(propertyBaseUrlMarketing));
        }
    }

    public String getClientURL() {
        //hardcoded from config.properties
        System.out.println(getProperty(propertyBaseUrlClient));
        return getProperty(propertyBaseUrlClient);
    }

    public String getAdminUsername() {
        if (!environment.equals("") && !environment.equals("qa")){
            return getProperty(propertyAdminUserName);
        }
        else{
            return getEnvironmentVariable(getProperty(propertyAdminUserName));
        }
    }

    public String getAdminPassword() {
        if (!environment.equals("") && !environment.equals("qa")){
            return getProperty(propertyAdminPassword);
        }
        else{
            return getEnvironmentVariable(getProperty(propertyAdminPassword));
        }
    }

    public String getCandidatePassword() {
        return getEnvironmentVariable(getProperty(propertyCandidatePassword));
    }

    public String getEventUtilityIP() {
        // Hardcoded in config.properties, event utility to be made for dev and uat
        return getProperty(eventUtilityIP);
    }

    public String getPublicURLVerifyProfile() {
        return getEnvironmentVariable(getProperty(publicURLVerifyProfile));
    }

    public String getChromeDriverPath() {
        return getEnvironmentVariable(getProperty(chromeDriverPath));
    }

    public String getReceiverAddress() {
        return getProperty(propertyReceiverAddress);
    }

}