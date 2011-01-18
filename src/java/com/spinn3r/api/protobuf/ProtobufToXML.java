package com.spinn3r.api.protobuf;

import java.io.IOException;
import java.text.ParseException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import com.spinn3r.io.utils.EncodingException;

/**
 * Class converts our protobuf output format into the rss output
 * format. 
 * 
 * The output is the same as the XML returned by the RSS versions
 * of the same API calls (ignoring order) with the following exceptions:
 * 
 * <ol>
 * <li> The protobuf output format originally did not include irankings. 
 * <li> The protobuf output format did not originally include a description 
 * of the channel
 * <li> The RSS output pubDate is actually the date found. therefore, the pubDates
 * will not match.  
 * </ol>
 * 
 * @author jwu
 *
 */
public class ProtobufToXML 
{
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, FactoryConfigurationError, ParseException, EncodingException, TransformerException
	{
		if(args.length == 2)
			ProtobufToXMLAppFactory.getInstance(args[0], args[1]).go();
		else if(args.length == 1)
			ProtobufToXMLAppFactory.getInstance(args[0]).go();
		else
		{
			System.err.println("Usage: java " + ProtobufToXML.class.getCanonicalName() +
					" args\n" +
					" Arguments may be in one of three forms:\n" +
					" protobufFileName\n" +
					" protobufFileName xmlFileName\n" +
					" directory\n\n");
		}
		
	}
}
