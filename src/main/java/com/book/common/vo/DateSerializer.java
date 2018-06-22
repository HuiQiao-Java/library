package com.book.common.vo;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateSerializer extends JsonSerializer<Date> {

	 @Override
	 public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializers)
	   throws IOException, JsonProcessingException {
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  String dateStr = sdf.format(date);
	  jsonGenerator.writeString(dateStr);
	 }

	}
