/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codingen;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DMyrzaka
 */
public class SMSID {
    
    public String cutsmsid(String str){
        Pattern p = Pattern.compile("<sms_id>(\\d+)</sms_id>");
        Matcher m = p.matcher(str);
         String  codeGroup="";
        
        if(m.find()){
            codeGroup=m.group(1);      
                  
          }
        return codeGroup;
    }
   
    public String status(String str){
        Pattern p = Pattern.compile("<status>(\\w.*)</status>");
        Matcher m = p.matcher(str);
         String  codeGroup="";
        
        if(m.find()){
            codeGroup=m.group(1);      
                  
          }
        return codeGroup;
    }
     
    public String description(String str){
        Pattern p = Pattern.compile("<description>\\s*(.*)\\s*</description>");
        Matcher m = p.matcher(str);
         String  codeGroup="";
        
        if(m.find()){
            codeGroup=m.group(1);      
                  
          }
        return codeGroup;
    }
    
    public String result(String str){
        Pattern p = Pattern.compile("<result>(\\w.*)</result>");
        Matcher m = p.matcher(str);
         String  codeGroup="";
        
        if(m.find()){
            codeGroup=m.group(1);      
                  
          }
        return codeGroup;
    }
    
    public String sentdate(String str){
        Pattern p = Pattern.compile("<send_date>(\\w.*)</send_date>");
        Matcher m = p.matcher(str);
         String  codeGroup="";
        
        if(m.find()){
            codeGroup=m.group(1);      
                  
          }
        return codeGroup;
    }
    
    public Date condate(String str) {
          Date date =  new Date();
         return date;
     }
   
    public static void main(String args[]){
     SMSID s = new SMSID();
     System.out.println(s.sentdate("<send_date>2015-03-17 10:04:03</send_date>"));
     System.out.println(s.sentdate("<?xml version=\"1.0\"?><reply><submition_date>2016-04-11 06:00:03</submition_date><send_date>2016-04-11 06:00:07</send_date><last_status_change_date></last_status_change_date><status>Buffered SMSC</status><error></error><sms_id>34584417380</sms_id></reply>"));
    
}   

}
 

