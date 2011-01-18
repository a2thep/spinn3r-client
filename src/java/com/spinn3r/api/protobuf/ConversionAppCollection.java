package com.spinn3r.api.protobuf;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.spinn3r.io.utils.EncodingException;

class ConversionAppCollection implements ConversionApp {

	private final ConversionApp[] apps;
	ConversionAppCollection(ConversionApp ... apps)
	{
		this.apps = apps;
	}
	
	@Override
	public void go() throws IOException, ParserConfigurationException,
			FactoryConfigurationError, ParseException, EncodingException,
			TransformerException {
		
		for(int i = 0; i < apps.length; i++)
			apps[i].go();
	}

}
