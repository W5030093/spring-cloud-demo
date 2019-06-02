package com.cloud.dauly.clouddaily.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yasenagat on 16/7/12.
 */
public class GlobalLog {

    public static Logger System = LoggerFactory.getLogger("System");
    public static Logger Error = LoggerFactory.getLogger("Error");
    public static Logger Biz = LoggerFactory.getLogger("Biz");
    public static Logger DB = LoggerFactory.getLogger("DB");
    public static Logger Status = LoggerFactory.getLogger("Status");
    public static Logger Cache = LoggerFactory.getLogger("Cache");
}
