package com.test.http;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;

import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by ThinkPad on 2016/5/4.
 */
public class HttpUtils {
  //  static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static String httpGet(String url){
        //get请求返回结果

        CloseableHttpResponse response=null;
        String strResult=null;
        try {
            CloseableHttpClient client = HttpClients.createDefault();
            //发送get请求
            HttpGet request = new HttpGet(url);
            response= client.execute(request);
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 200) {
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
              //  LOGGER.info(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
            //    LOGGER.info("get请求提交失败:" + url);
            }
        } catch (IOException e) {
          //  LOGGER.info("get请求提交失败:" + url);
        }
        return strResult;
    }


    public static String httpsGet(String url) throws Exception{
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[] {new TrustAnyTrustManager()}, new SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new HostnameVerifier() {
            public boolean verify(String paramString, SSLSession paramSSLSession) {
                return true;
            }
        });
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
        CloseableHttpResponse response=null;
        String strResult=null;
        try {
           // CloseableHttpClient client = HttpClients.createDefault();
            //发送get请求
            HttpGet request = new HttpGet(url);
            response= httpclient.execute(request);
          //  System.out.println("response.getStatusLine().getStatusCode():"+response.getStatusLine().getStatusCode());
            /**请求发送成功，并得到响应**/
            if (response.getStatusLine().getStatusCode() == 200) {
                /**读取服务器返回过来的json字符串数据**/
                strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                //  LOGGER.info(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                //    LOGGER.info("get请求提交失败:" + url);
            }
        } catch (IOException e) {
            //  LOGGER.info("get请求提交失败:" + url);
        }
        return strResult;
    }
    public  static  void main(String[] argss){

       System.out.println( HttpUtils.httpGet("http://localhost:8080/mnis/nur/patientGlance/getPateintBedList?deptCode=5042"));
    }
    private static class TrustAnyTrustManager implements X509TrustManager {

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[] {};
        }
    }
}
