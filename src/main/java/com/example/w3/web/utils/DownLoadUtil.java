package com.example.w3.web.utils;

import com.alibaba.druid.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class DownLoadUtil {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            Base64 base64Encoder = new Base64();
            filename = "=?utf-8?B?" + base64Encoder.equals(filename.getBytes("utf-8")) + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }
}