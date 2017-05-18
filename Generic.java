package ConvertDate;

import java.text.DateFormat;
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;

public class Generic { 
private static final String cdmFormatSimple = "dd.MM.yyyy HH:mm:ss"; 
private static final String xmlFormatSimple = "dd-MM-yyyy HH:mm:ss"; 
private static final String cdmFormat = "dd.MM.yyyy HH:mm:ss"; 
private static final String xsdDateTimeFormat = "yyyy-MM-dd HH:mm:ss"; 

public Generic() { 
} 

public String mapDateFromXSDToCDM(String str) throws Exception { 
if (str == null || "".equals(str.trim())) return null; 
try { 
String format = xsdDateTimeFormat; 
return new SimpleDateFormat(cdmFormatSimple).format(convertToDate(str, format)); 
} catch(Exception err) { 
throw new Exception("Ошибка при конвертации значения '"+str+"': "+err.getMessage()); 
} 
} 

private final static Date convertToDate(Object value, String format) throws ParseException { 
if (format == null || format.trim().isEmpty()) { 
throw new IllegalArgumentException("Argument format is null or empty"); 
} 
if (value == null) { 
return null; 
} 

String strValue = value.toString(); 
if (strValue.isEmpty()) { 
return null; 
} 

SimpleDateFormat formatter = new SimpleDateFormat(format); 
Date date = formatter.parse(strValue); 

return date; 
} 
public static void main(String args[]) throws Exception{
 Generic g = new Generic();
 
  System.out.println(g.mapDateFromXSDToCDM("2015-03-17 10:04:03"));
}


    public static String addDateDuration(String date, String duration) throws DatatypeConfigurationException {
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        Duration dx = dtf.newDuration(duration);
        XMLGregorianCalendar dtx = dtf.newXMLGregorianCalendar(date);
        
        dtx.add(dx);
        
        return dtx.toXMLFormat();
    }

    public static String addStrangeDateDurationTOOracle(String date, String duration) throws DatatypeConfigurationException, ParseException {
        DatatypeFactory dtf = DatatypeFactory.newInstance();
        GregorianCalendar dt = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat(cdmFormatSimple);
        DateFormat dfx = new SimpleDateFormat(xsdDateTimeFormat);
        Duration dx = dtf.newDuration(duration);
        
        dt.setTime(dfx.parse(date));
        XMLGregorianCalendar dtx = dtf.newXMLGregorianCalendar( dt );
        dtx.add(dx);
        
        return df.format(dtx.toGregorianCalendar().getTime());
    }
    
}


