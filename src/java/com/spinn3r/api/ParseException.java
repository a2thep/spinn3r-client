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

/**
 * Thrown if there's any problem with the underlying XML parsing infrastructure.
 */
public class ParseException extends Exception {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public ParseException( Exception cause ) {
        initCause( cause );
    }

    public ParseException( Exception cause, String message ) {
        super( message );
        initCause( cause );
    }

    public ParseException( String message ) {
        super( message );
    }

}