package com.course.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    //ResourceBundle读取配置文件
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeMethod
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中拼接测试的url
        String uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;
        //测试逻辑代码
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = " + name +" value=" +value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String testUrl=this.url+this.bundle.getString("getCookiesInfo.uri");
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpResponse respose = client.execute(get);
        //获取返回状态码
        int statusCode=respose.getStatusLine().getStatusCode();
        if (statusCode==200){
            String result = EntityUtils.toString(respose.getEntity(), "utf-8");
            System.out.println(result);
        }

    }
}
