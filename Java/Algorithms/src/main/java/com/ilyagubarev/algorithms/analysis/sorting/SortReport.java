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
package com.ilyagubarev.algorithms.analysis.sorting;

import java.io.Serializable;

/**
 *
 * @author gubarev
 */
public final class SortReport implements Serializable {

    private TestStatus _status;
    private String _statusInfo;
    private SortTask _task;
    private String _sorterInfo;
    private long _comparisons;
    private long _hashings;
    private long _tests;
    private long _reads;
    private long _writes;
    private long _auxArrayAllocations;
    private long _auxArrayAllocationMax;
    private long _auxArrayAllocationTotal;
    private long _auxReads;
    private long _auxWrites;
    private long _recursionMax;
    private long _time;

    private SortReport() {
        
    }
}