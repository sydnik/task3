package tests;

import forms.LeftMenuForm;
import framework.BaseTest;
import framework.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ElementsPage;
import pages.MainPage;
import pages.UploadAndDownload;

import java.io.File;

public class TestCase7FilesUploadAndDownload extends BaseTest {
    @Test
    public void test(){
        LoggerUtil.info(this.getClass(),"Start test");
        DriverUtil.openURL(ConfigUtil.getDataProperty("mainPageURL"));
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened());
        mainPage.openElements();
        new ElementsPage().isPageOpened();
        new LeftMenuForm().openUploadAndDownload();
        UploadAndDownload uploadAndDownload = new UploadAndDownload();
        File file = FilesUtil.getFile(ConfigUtil.getConfProperty("pathForDownload"),uploadAndDownload.getDownloadFileName());
        file.delete();
        uploadAndDownload.startDownload();
        Assert.assertTrue(WaitUtil.waitFileDownLoad(file));
        uploadAndDownload.startUpload(file.getAbsolutePath());
        Assert.assertTrue(uploadAndDownload.getUploadFileName().endsWith(file.getName()));
    }
}
