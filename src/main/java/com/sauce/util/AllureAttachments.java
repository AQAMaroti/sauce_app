package com.sauce.util;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

public final class AllureAttachments {
    private AllureAttachments() {
    //
    }

    public static void attachments(WebDriver driver, String name){
        if(driver==null) return;
        byte[] bytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment(name, new ByteArrayInputStream(bytes));
    }

    @Attachment(value="{name}",type="text/plain" )
    public static byte[] addText(String name, String content){
        return content == null ? new byte[0] : content.getBytes(StandardCharsets.UTF_8);
    }



}
