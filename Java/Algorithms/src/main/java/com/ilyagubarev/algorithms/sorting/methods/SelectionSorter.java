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
package com.ilyagubarev.algorithms.sorting.methods;

import java.util.Comparator;

import com.ilyagubarev.algorithms.adt.arrays.ArrayModel;
import com.ilyagubarev.algorithms.adt.arrays.ArrayModelFactory;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.utils.Registry;
import com.ilyagubarev.algorithms.adt.utils.Stopwatch;

/**
 * Sorting algorithm implementation based on selection method.
 *
 * @see AbstractSorter
 *
 * @version 1.05, 20 September 2013
 * @since 07 September 2013
 * @author Ilya Gubarev
 */
public final class SelectionSorter extends AbstractSorter {

    @Override
    public String getInfo() {
        return "Selection method";
    }

    @Override
    public <T> void sort(ArrayModel<T> target, Comparator<T> comparator,
            ArrayModelFactory arrayFactory, NodeModelFactory nodeFactory,
            Registry recursions, Stopwatch stopwatch) {
        for (int pivot = 0; pivot < target.getSize(); ++pivot) {
            int min = pivot;
            for (int i = pivot + 1; i < target.getSize(); ++i) {
                min = less(target, comparator, i, min) ? i : min;
            }
            swap(target, pivot, min);
            stopwatch.check();
        }        
    }
}
