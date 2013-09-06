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
package com.ilyagubarev.algorithms.sorting;

/**
 * Sorting algorithm common implementation.
 *
 * @see SortingAlgorithm
 *
 * @version 1.01, 07 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public abstract class AbstractSortingAlgorithm implements SortingAlgorithm {

    /**
     * Exchanges array objects of specified indeces with each other.
     *
     * @param array an array with objects to be exchanged.
     * @param first the first object index.
     * @param second the second object index.
     * @throws ArrayIndexOutOfBoundsException if indeces are illegal.
     */
    protected void exchange(Object[] array, int first, int second) {
        Object buffer = array[first];
        array[first] = array[second];
        array[second] = buffer;
    }

    /**
     * Checks if one comparable object is less than another.
     *
     * @param subject an object to be tested.
     * @param sample a sample object.
     * @return true if the subject is less than the sample.
     * @throws ClassCastException if the objects are incomparable.
     */
    protected boolean isLess(Comparable subject, Comparable sample) {
        return subject.compareTo(sample) < 0;
    }
}