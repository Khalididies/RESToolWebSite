package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenShot {
    WebDriver driver;
    public TakeScreenShot(WebDriver driver) {
        this.driver = driver;
    }
    public void takeScreenShot(String filePath) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot)this.driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

        File DestFile=new File(filePath);

        //Copy file at destination

        FileUtils.copyFile(SrcFile, DestFile);

    }
}
