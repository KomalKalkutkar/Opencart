package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //Log4j
import org.apache.logging.log4j.Logger; //Log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass {

        public static WebDriver driver ;
        public Logger logger;//log4j
        public Properties p; //config.Properties

        @BeforeClass(groups={"Sanity","Regression","Master","DataDriven"})
        @Parameters({"os","browser"})
        public void setUp(String os,String br) throws IOException {

            //log4j
            logger = LogManager.getLogger(this.getClass()); //takes class name dynamically

            //loading config.properties file
            FileReader file = new FileReader("./src//main//resources//config.properties");
            p = new Properties();
            p.load(file);

            if(p.getProperty("execution_env").equalsIgnoreCase("Remote"))
            {
                DesiredCapabilities cap = new DesiredCapabilities();

                //os
                if(os.equalsIgnoreCase("mac"))
                {
                    cap.setPlatform(Platform.MAC);
                }
                else if (os.equalsIgnoreCase("windows"))
                {
                    cap.setPlatform(Platform.WIN11);
                }else
                {
                    System.out.println("No matching os");
                }


                //browser
                switch(br.toLowerCase())
                {
                    case "chrome" : cap.setBrowserName("chrome"); break;
                    case "Edge" : cap.setBrowserName("MicrosoftEdge"); break;
                    default : System.out.println("No Matching Browser ");

                }

                driver =new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
            }



            if (p.getProperty("execution_env").equalsIgnoreCase("local"))
            {


                switch (br.toLowerCase()) {
                    case "chrome":
                        driver = new ChromeDriver();
                        break;
                    case "edge":
                        driver = new EdgeDriver();
                        break;
                    case "firefox":
                        driver = new FirefoxDriver();
                        break;
                    default:
                        System.out.println("Invalid Browser");
                        return;
                }

                driver.manage().deleteAllCookies();
                driver.get(p.getProperty("appURL"));
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().window().maximize();
            }



        }
        @AfterClass(groups={"Sanity","Regression","Master","DataDriven"})
        public void tearDown()
        {
            driver.quit();
        }

        public String randomeString()
        {
            String generatedString = RandomStringUtils.randomAlphabetic(6);
            return generatedString;
        }

        public String randomeNumber()
        {
            String generatedNumber = RandomStringUtils.randomNumeric(10);
            return generatedNumber;
        }

        public String randomeALphaNumeric()
        {
            String genaratedString= RandomStringUtils.randomAlphabetic(3);
            String generatedNumber = RandomStringUtils.randomNumeric(2);
            return(genaratedString+"@"+generatedNumber);
        }


        public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir")+"/screenshots/" + tname + "_" + timeStamp + ".png";

        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

   /* public String captureScreen(String tname) {
        String targetFilePath = null;
        try {
            if (driver == null) {
                System.out.println("Driver is null. Screenshot not taken for: " + tname);
                return null;
            }

            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

            // Create screenshots directory if it doesn't exist
            String screenshotDir = System.getProperty("user.dir") + "\\screenshots\\";
            File dir = new File(screenshotDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            targetFilePath = screenshotDir + tname + "_" + timeStamp + ".png";
            File targetFile = new File(targetFilePath);

            // Use copy instead of renameTo for reliability
            Files.copy(sourceFile.toPath(), targetFile.toPath());

            System.out.println("Screenshot saved: " + targetFilePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to capture screenshot for: " + tname);
        }

        return targetFilePath;
    }*/




}
