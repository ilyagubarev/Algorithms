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
package com.ilyagubarev.algorithms.adt;

import com.ilyagubarev.algorithms.adt.tools.Counter;
import com.ilyagubarev.algorithms.adt.tools.Registry;

/**
 * Item array allocator.
 *
 * @version 1.01, 13 September 2013
 * @since 13 September 2013
 * @author Ilya Gubarev
 */
public final class ItemArrayFactory {

    private final Registry _allocations;

    /**
     * Creates a new instance of ItemArrayFactory.
     *
     * @param allocations a registry of allocations.
     *
     * @see Registry
     */
    public ItemArrayFactory(Registry allocations) {
        if (allocations == null) {
            throw new NullPointerException("allocations registry is null");
        }        
        _allocations = allocations;
    }

    /**
     * Creates a new instance of ItemArray of specified size.
     *
     * @param size a size of the array.
     * @param reads a counter of array read operations.
     * @param writes a counter of array write operations.
     * @return a new instance of ItemArray.
     * @throws IllegalArgumentException is specified size is negative.
     *
     * @see Counter
     * @see ItemArray
     */
    public ItemArray create(int size, Counter reads, Counter writes) {
        if (size < 0) {
            throw new IllegalArgumentException("array size is negative");
        }
        if (reads == null) {
            throw new NullPointerException("reads counter is null");            
        }
        if (writes == null) {
            throw new NullPointerException("writes counter is null");            
        }
        _allocations.add(size);
        return new ItemArray(size, reads, writes);
    }
}
