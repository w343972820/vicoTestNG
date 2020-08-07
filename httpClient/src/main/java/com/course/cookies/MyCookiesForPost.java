package com.course.cookies;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPost() throws IOException {
        //测试地址
        String testUrl=this.url+this.bundle.getString("postCookies.uri");
        //声明一个Client对象,用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法,这个方法就是post方法
        HttpPost post=new HttpPost(testUrl);
        //添加参数
        JSONObject json=new JSONObject();
        json.put("name","wuhansan");
        json.put("age","20");
        //设置请求头信息header
        post.setHeader("content-type","application/json");
        //将参数信息添加进方法中
        StringEntity entity=new StringEntity(json.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取结果
        result=EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //处理json结果
        JSONObject resultJson=JSONObject.parseObject(result);
        String success = resultJson.get("huhansan").toString();
        String status = resultJson.get("status").toString();
        //判断返回结果
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);
    }



}
