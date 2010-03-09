/*
 * Copyright 2007 Tailrank, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.spinn3r.api;

import static com.spinn3r.api.XMLUtils.getElementByTagName;

import java.io.FileNotFoundException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.spinn3r.api.protobuf.ContentApi;

/*
 * BUG: This class is UGLY as it really is not much like a base client
 *      but we still derive form it. Once Base client is cleand up and
 *      is functional it may be that we can clean this up.
 */

/**
 * API client that implements Spinn3r's source registration API.
 */
public class SourceClient extends LegacyWrapperClient<Source> {

    /**
     * Register a new weblog within Spinn3r.
     * 
     * @throws Exception when registration fails.
     * @deprecated use SourceRegisterClient.  This method will be supported
     * until Aug 1, 2008 at which point it will be removed.
     */
    public void register( String link ) throws Exception {

        SourceRegisterClient client = new SourceRegisterClient();
        SourceRegisterConfig config = new SourceRegisterConfig();

        config.setVendor(  super.getConfig().getVendor() );
        config.setVersion( super.getConfig().getVersion() );

        client.setConfig( config );

        client.register( link );

    }



    protected BaseResult parseItem( ContentApi.Entry current ) throws Exception {
        // BUG: how come this api dose not implment any parcres?
        throw new UnimplementedException ("protobuf support not implmented for this client");
    }


    /**
     * Check on the status of a weblog within Spinn3r.
     *
     * @throws FileNotFoundException when the weblog was not found in our index.
     */
    public Source status( String link ) throws Exception {

        try {

            StringBuffer params = new StringBuffer();

            Config.addParam( params, "link", link );
            Config.addParam( params, "vendor",  config.getVendor() );
            Config.addParam( params, "version", config.getVersion() );

            String resource = String.format( "http://%s/rss/source.status?%s", config.getHost(), params );

            Document doc = doXmlFetch( resource, config );

            Element root = (Element)doc.getFirstChild();

            Element channel = getElementByTagName( root, "channel" );

            Source source = new Source( channel );

            return source;

        } catch ( FileNotFoundException e ) {
            return null;
        }
        
    }


    public static void main( String[] args ) throws Exception {

        SourceClient client = new SourceClient();

        Config<Source> config = new SourceConfig();
        config.setVendor( "XXXX" );
                
        client.setConfig( config );

        String method     = args[0];
        String resource   = args[1];

        System.out.printf( "%s for %s\n", method, resource );

        if ( method.equals( "register" ) ) {

            client.register( resource );

        } else if ( method.equals( "status" ) ) {

            Source source = client.status( resource );

            if ( source == null ) {
                System.out.printf( "Not found\n" );
                return;
            }

            SourceListClient.printf( source );

        }
            
    }
    
}