package com.spinn3r.api;


import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.GZIPInputStream;

import org.w3c.dom.Document;

public abstract class LegacyWrapperClient <ResultType extends BaseResult> extends BaseClient<ResultType> {

    public static int PARALLELISM        = 4;
    private static int RESULT_BUFFER_SIZE = 8;

    protected Config<ResultType>           config        = null;
    private   BaseClientResult<ResultType> result        = null;
    private   long                         sleepDuration = 0;

    private   ParallelFetchHelper<ResultType> parallelFetcher = null;
    
    private   final Collection<String>           restartURLS;
    private   final Queue<String>                restartURLSQueue;

    public LegacyWrapperClient () {
        this(Collections.<String>emptySet());
    }
    
    LegacyWrapperClient(Collection<String> restartURLS)
    {
    	this.restartURLS = restartURLS;
    	restartURLSQueue = new LinkedList<String>(restartURLS);
    	result = new BaseClientResult<ResultType> ( null );
    }

    public void fetch() throws IOException,
        ParseException,
        InterruptedException {
    	
        if ( parallelFetcher == null ) {
            parallelFetcher = new ParallelFetchHelper<ResultType> ( this, config, RESULT_BUFFER_SIZE, PARALLELISM );
            parallelFetcher.start();

        }

        long sleep_interval = 0;

        // we don't actually sleep hear as we already slept in the parallelFetcher.
        if ( result != null && ! result.getHasMoreResults() )
            sleep_interval = result.getConfig().getSleepInterval();

        setSleepDuration( sleep_interval );

        try {
            result = parallelFetcher.fetch();
            
            String nextURL = result.getNextRequestURL();
            if(!restartURLS.contains(nextURL))
            	restartURLSQueue.add(nextURL);
            
            // I that it's theoretically impossible for the queue to be out of items
            config.setNextRequestURL( restartURLSQueue.poll() );
        }

        catch ( Exception e ) {
            // we do this cause it the caller retries we need a clean pipe line
            parallelFetcher = null;

            //this is slightly ugly but prevents nested exceptions.
            if ( e instanceof IOException )
                throw (IOException)e;

            if ( e instanceof ParseException )
                throw (ParseException)e;

            if ( e instanceof InterruptedException )
                throw (InterruptedException)e;

            IOException ioe = new IOException();
            ioe.initCause( e );
            throw ioe;
        }

    }


    public Document doXmlFetch ( String resource, Config<ResultType> config ) throws IOException,
                                                      ParseException,
                                                      InterruptedException {
        return doXmlFetch( new GZIPInputStream(getConnection( resource ).getInputStream()), config );
    }
 
    // **** Getter and setters **************************************************



    /**
     * 
     * Get the value of <code>sleepDuration</code>.
     *
     */
    public long getSleepDuration() { 
        return sleepDuration;
    }

    /**
     * 
     * Set the value of <code>sleepDuration</code>.
     *
     */
    public void setSleepDuration( long value ) { 
        sleepDuration = value;
    }


    /**
     * 
     * Get the value of <code>config</code>.
     *
     */
    public Config<ResultType> getConfig() { 
        return this.config;
    }

    /**
     * 
     * Set the value of <code>config</code>.
     *
     */
    @Override
    public void setConfig( Config<ResultType> config ) {
        this.config = config;
        
        String firstURL = config.getFirstRequestURL();
        if(!this.restartURLS.contains(firstURL))
        	this.restartURLSQueue.add(firstURL);
        this.config.setFirstRequestURL(restartURLSQueue.poll());
    }

    // **** Proxy Getter and setters **************************************************

    /**
     * 
     * Get the last requested URL for debug and logging purposes.
     *
     */
    public String getLastRequestURL() { 
        return result.getLastRequestURL();
    }

    /**
     * 
     * Set the value of <code>lastRequestURL</code>.
     *
     */
    public void setLastRequestURL( String lastRequestURL ) { 
        result.setLastRequestURL( lastRequestURL );
    }

    /**
     * 
     * Get the value of <code>nextRequestURL</code>.
     *
     */
    public String getNextRequestURL() { 
        return result.getNextRequestURL();
    }

    /**
     * 
     * Set the value of <code>nextRequestURL</code>.
     *
     */
    public void setNextRequestURL( String next ) { 
        result.setNextRequestURL( next );
    }

     /**
      * 
      * Get the value of <code>result</code>.
      *
      */
     public List<ResultType> getResults() { 
         return result.getResults();
     }


    /**
     * 
     * Get the value of <code>callDuration</code>.
     *
     */
    public long getCallDuration() { 
        return result.getCallDuration();
    }

    /**
     * 
     * Set the value of <code>callDuration</code>.
     *
     */
    public void setCallDuration( long callDuration ) { 
        result.setCallDuration( callDuration );
    }


    /**
     * 
     * Get the value of <code>parseDuration</code>.
     *
     */
    public long getParseDuration() { 
        return result.getParseDuration();
    }

    /**
     * 
     * Set the value of <code>parseDuration</code>.
     *
     */
    public void setParseDuration( long parseDuration ) { 
        result.setParseDuration( parseDuration );
    }


    /**
     * When the API needs to shutdown you need to call this method FIRST and
     * persist it.  Then when the API starts you need to call config.setAfter()
     * with this value.
     */
    public Date getRestartPoint() {
        return result.getRestartPoint();
    }

    /**
     * Return the correct limit, factoring in the limit set by the user. 
     *
     */
    public int getLimit() {
        return result.getRequestLimit();
    }

    /**
     * Return true if more results are available.
     *
     */
    public boolean hasMoreResults() {
        return result.getHasMoreResults();
    }

    /**
     * Return a copy of the input streem
     */
    public InputStream getInputStream( ) throws IOException {
        return getInputStream( true );
    }


    /**
     * Return a copy of the input streem
     */
    public InputStream getInputStream( boolean decompress ) throws IOException {
        return result.getInputStream( decompress );
    }
       

    /**
     * Return if the results are compressed.
     */
    public boolean getIsCompressed () {
        return result.getIsCompressed();
    }
}
