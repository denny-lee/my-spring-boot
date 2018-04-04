package com.lee.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : Liw
 * @description :
 * @date : 2018/3/9 17:27
 */
public class DateJsonDeserializer extends JsonDeserializer<Date> {
    public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException,JsonProcessingException
    {
        try
        {
            if (jsonParser.getText().length() == 10) {

                return format2.parse(jsonParser.getText());
            } else {
                return format.parse(jsonParser.getText());

            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
