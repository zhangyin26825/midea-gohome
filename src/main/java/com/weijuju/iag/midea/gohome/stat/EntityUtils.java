package com.weijuju.iag.midea.gohome.stat;

/**
 * Created by zhangyin on 2016/8/11.
 */


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.*;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * <br>CreateDate : 14-12-22 上午11:51
 *
 * @author zhangyin
 * @version 1.1
 */
public class EntityUtils {

    static {
        ConvertUtils.register(new LongConverter(null), Long.class);
        ConvertUtils.register(new ByteConverter(null), Byte.class);
        ConvertUtils.register(new IntegerConverter(null), Integer.class);
        ConvertUtils.register(new DoubleConverter(null), Double.class);
        ConvertUtils.register(new ShortConverter(null), Short.class);
        ConvertUtils.register(new FloatConverter(null), Float.class);
        ConvertUtils.register(new DateConverter(), java.util.Date.class);
    }
    public static DateFormat df=new SimpleDateFormat("yyyy-MM-dd");

    public static Map<String, String> objectToHash(Object obj) {
        try {
            Map<String, String> map =new HashMap();
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                if (!property.getName().equals("class")) {
                    if (property.getReadMethod().invoke(obj) != null) {
                        Object value = property.getReadMethod().invoke(obj);
                        if(value instanceof  java.util.Date) {
                            map.put(property.getName(), "" + df.format((java.util.Date)value));
                        }else{
                            map.put(property.getName(), "" + value);
                        }
                    }
                }
            }
            return map;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void hashToObject(Map<?, ?> map, Object obj) {
        try {
            BeanUtils.populate(obj, (Map) map);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T hashToObject(Map<?, ?> map, Class c) {
        if (map==null||map.isEmpty()) {
            return null;
        }
        try {
            Object obj = c.newInstance();
            hashToObject(map, obj);
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
