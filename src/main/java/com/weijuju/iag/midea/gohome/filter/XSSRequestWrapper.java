package com.weijuju.iag.midea.gohome.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.regex.Pattern;

public class XSSRequestWrapper extends HttpServletRequestWrapper {  
  
    public XSSRequestWrapper(HttpServletRequest servletRequest) {  
        super(servletRequest);  
    }  
  
    @Override  
    public String[] getParameterValues(String parameter) {  
        String[] values = super.getParameterValues(parameter);  
  
        if (values == null) {  
            return null;  
        }  
  
        int count = values.length;  
        String[] encodedValues = new String[count];  
        for (int i = 0; i < count; i++) {  
            encodedValues[i] = filterXSS(values[i]);  
        }  
  
        return encodedValues;  
    }  
  
    @Override  
    public String getParameter(String parameter) {  
        String value = super.getParameter(parameter);  
        return filterXSS(value);  
    }  
  
    @Override  
    public String getHeader(String name) {  
        String value = super.getHeader(name);  
        return filterXSS(value);  
    }  
  
    private String filterXSS(String value) {  
    	if (value != null) {  
            // NOTE: It's highly recommended to use the ESAPI library and uncomment the following line to  
            // avoid encoded attacks.  
            // value = ESAPI.encoder().canonicalize(value);  
  
            // Avoid null characters  
            value = value.replaceAll("", "");  
  
            // Avoid anything between script tags  
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid anything in a src='...' type of expression  
//            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
//            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Remove any lonesome </script> tag  
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Remove any lonesome <script ...> tag  
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid eval(...) expressions  
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid expression(...) expressions  
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid javascript:... expressions  
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid vbscript:... expressions  
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);  
            value = scriptPattern.matcher(value).replaceAll("");  
  
            // Avoid onload= expressions  
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
            
            // Avoid onerror = expressions  
            scriptPattern = Pattern.compile("onerror(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
            
            // Avoid onfinish = expressions  
            scriptPattern = Pattern.compile("onfinish(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
            
            // Avoid onclick = expressions  
            scriptPattern = Pattern.compile("onclick(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
            
            // Avoid onfocus = expressions  
            scriptPattern = Pattern.compile("onfocus(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
            
            // Avoid onblur = expressions  
            scriptPattern = Pattern.compile("onblur(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);  
            value = scriptPattern.matcher(value).replaceAll("");  
        }  
        return value;  
    }   
}  