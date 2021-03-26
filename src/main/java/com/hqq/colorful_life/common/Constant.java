package com.hqq.colorful_life.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * @author Qingqing.He
 * @date 2021/3/16 13:22
 */
@Component
public class Constant {
    public static final String MALL_USER = "mall_user";
    public static final String SALT = "csfFEW,LPLE3;';]";

    //上传图片地址
    public static String FILE_UPLOAD_DIR;

    @Value("${file.upload.dir}")
    public void setFileUploadDir(String fileUploadDir){
        FILE_UPLOAD_DIR = fileUploadDir;
    }
}
