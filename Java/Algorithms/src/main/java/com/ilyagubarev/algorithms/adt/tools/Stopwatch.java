/*
 * Copyright 2013 Ilya Gubarev.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ilyagubarev.algorithms.adt.tools;

/**
 * Simple stopwatch.
 *
 * @version 1.03, 12 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public final class Stopwatch {

    private long _start;
    private long _stored;
    private boolean _started;

    /**
     * Creates a new instance of Stopwatch.
     */
    public Stopwatch() {
        
    }

    /**
     * Gets elapsed time in milliseconds.
     *
     * @return elapsed time.
     */
    public long getElapsedTime() {
        if (!_started) {
            return _stored; 
        }
        return System.currentTimeMillis() - _start;
    }

    /**
     * Starts or restarts the stopwatch.
     */
    public void start() {
        _start = System.currentTimeMillis();
        _started = true;
    }

    /**
     * Stops the stopwatch and stores elapsed time.
     */
    public void stop() {
        _stored = getElapsedTime();
        _started = false;
    }
}
