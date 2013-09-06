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

import com.ilyagubarev.algorithms.adt.analysis.Counter;

/**
 * Sorting algorithm common interface.
 *
 * @version 1.01, 07 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public interface SortingAlgorithm {

    /**
     * Sorts specified array in a natural order.
     *
     * @param array an array to be sorted.
     * @param comparisons counter of comparisons.
     * @param exchanges counter of item exchanges.
     *
     * @see Counter
     */
    void sort(Comparable[] array, Counter comparisons, Counter exchanges);
}
