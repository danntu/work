/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DMyrzaka
 */
import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element; 

public class HTMLParser {
     public static void enableSSLSocket() throws KeyManagementException, NoSuchAlgorithmException {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
 
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, new X509TrustManager[]{new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }
 
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }
 
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        }}, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
    }
     
    public static void main(String args[]) throws IOException,NoSuchAlgorithmException, KeyManagementException{
       /*        
        System.setProperty("proxySet", "true");
        System.setProperty("http.proxyHost", "172.20.20.220");
        System.setProperty("http.proxyPort", "8080"); 
        */
       
        enableSSLSocket();
        
        Document doc =  Jsoup.connect("http://neerc.ifmo.ru/archive/2003/kazakhstan/standings.html").get();
        Element table = doc.select("table[border=0]").first();
        Iterator<Element> universitet = table.select("td[class=party]").iterator();
        Iterator<Element> rank = table.select("td[class=rank]").iterator();
        String univer[] = new String[5];
        String solve[]  = new String[5];
        String rating[] = new String[5];
        
        for (int i=0;i<5;i++){
            univer[i]=universitet.next().text();
           
            rating[i]=rank.next().text();
            System.out.println(univer[i]+";"+rating[i]);
        }    
        //System.out.println(
       // +" "+doc.select("td[class=rank]").iterator().next().text());
        
        
    }
}
