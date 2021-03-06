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
package com.ilyagubarev.algorithms.analysis;

/**
 * Test status types.
 *
 * @version 1.01, 23 September 2013
 * @since 23 September 2013
 * @author Ilya Gubarev
 */
public enum TestStatus {

    /**
     * Test failed.
     */
    FAILED("failed"),

    /**
     * Test passed.
     */
    PASSED("passed");

    private final String _text;

    private TestStatus(String text) {
        _text = text;
    }

    /**
     * Gets test status text.
     *
     * @return status text.
     */
    public String getText() {
        return _text;
    }

    @Override
    public String toString() {
        return _text;
    }
}
