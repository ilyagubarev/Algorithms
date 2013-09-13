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

import com.ilyagubarev.algorithms.adt.collections.Array;
import com.ilyagubarev.algorithms.adt.collections.AuxMemory;

/**
 * Insertion sorting algorithm implementation.
 *
 * @see AbstractSorter
 *
 * @version 1.02, 12 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class InsertionSorter extends AbstractSorter {

    @Override
    protected void method(Array target, AuxMemory aux) {
        for (int pivot = 1; pivot < target.getSize(); ++pivot) {
            int i = pivot;
            while (i > 0 && target.less(i, i - 1)) {
                target.swap(i, i - 1);
                --i;
            }
        }
    }
}
