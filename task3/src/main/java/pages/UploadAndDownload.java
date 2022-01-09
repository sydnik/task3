package pages;

import framework.BaseForm;
import framework.elements.Button;
import framework.elements.InputFile;
import framework.elements.Label;
import org.openqa.selenium.By;

public class UploadAndDownload extends BaseForm {
    private final Button DOWNLOAD_BUTTON  = new Button(By.id("downloadButton"),"downloadButton");
    private final InputFile UPLOAD_INPUT_FILE  = new InputFile(By.id("uploadFile"),"uploadFile");
    private final Label UPLOADED_FILE_PATH = new Label(By.id("uploadedFilePath"),"uploadedFilePath");
    public UploadAndDownload() {
        super(new Button(By.id("downloadButton"),"downloadButton"), "UploadAndDownload");
    }
    public void startDownload(){
        DOWNLOAD_BUTTON.click();
    }
    public void startUpload(String path){
        UPLOAD_INPUT_FILE.uploadFile(path);
    }
    public String getDownloadFileName(){
        return DOWNLOAD_BUTTON.getAttribute("download");
    }
    public String getUploadFileName(){
        return UPLOADED_FILE_PATH.getText();
    }
}
