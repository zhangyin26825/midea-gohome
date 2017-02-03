package com.weijuju.iag.midea.gohome.util;/**
 * Created by zhangyin on 2016/12/19.
 */

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @author zhangyin
 * @create 2016-12-19
 */
public class UUIDGenerator {

    public static String uuid(){
        return DigestUtils.md5Hex(UUID.randomUUID().toString().getBytes()).substring(2,18);
    }
}
