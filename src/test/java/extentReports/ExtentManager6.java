package extentReports;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import tests.BaseTest6;
import org.openqa.selenium.OutputType;
 
public class ExtentManager6 extends BaseTest6{
 
  //  private static ExtentReports extent;
    public static String screenshotName;
    public static ExtentSparkReporter sparkReporter;
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (null == extent) {
            createInstance();
        }
        return extent;
    }

    public static ExtentReports createInstance() {
     //   String fileName = getReportPath(REPORT_FILEPATH);
// initialize the HtmlReporter
     //   ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
      //  ExtentHtmlReporterConfiguration config = htmlReporter.config();
//sets theme,title,timestampformat etc for presentation of report
     //   config.setTestViewChartLocation(ChartLocation.BOTTOM);
     //   config.setChartVisibilityOnOpen(true);
     //   config.setTheme(Theme.STANDARD);
     //   config.setDocumentTitle(REPORT_FILE_NAME + ".html");
     //   config.setEncoding(StandardCharsets.UTF_8.toString());
     //   config.setReportName(REPORT_FILE_NAME + " :: " + ConfigurationReader.driverOption);
     //   config.setTimeStampFormat(TIME_STAMP_FORMAT);

// initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        // attach only HtmlReporter
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");


        return extent;
    }

        
     
    public static void captureScreenshot() {
         
        TakesScreenshot screenshot = (TakesScreenshot)driver;
           
        // Call method to capture screenshot
        File src = screenshot.getScreenshotAs(OutputType.FILE);
 
        try
        {
            Date d = new Date();
            screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";  
            FileUtils.copyFile(src,new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
            System.out.println("Successfully captured a screenshot");
       } catch (IOException e) {
           System.out.println("Exception while taking screenshot " + e.getMessage());
      }
    }

}
