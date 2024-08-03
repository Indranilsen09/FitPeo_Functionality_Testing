package helpers;

import java.io.InputStream;
import java.util.Properties;

public class ReadProperties
{
    static InputStream fis;
    static Properties property=null;
    static String url = null;

    private static Properties readProperty(String filename)
    {
        Properties prop = new Properties();
        try{
            String filepath = "/"+filename;
            fis = ReadProperties.class.getResourceAsStream(filepath);
            if(fis!=null){
                prop.load(fis);
            }
        }catch(Exception e){
            System.out.println("Failed to load properties: "+ e.getLocalizedMessage());
        }
        return prop;
    }
    public static String getProperty(String key)
    {
        try{
            property =readProperty("env.properties");
            url = property.getProperty(key);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  url;
    }
}
