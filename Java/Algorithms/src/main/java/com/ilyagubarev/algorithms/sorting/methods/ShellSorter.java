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
import com.ilyagubarev.algorithms.sorting.utils.gapping.GapProvider;

/**
 * Donald Shell method sorting algorithm implementation.
 *
 * @see AbstractSorter
 *
 * @version 1.05, 20 September 2013
 * @since 11 September 2013
 * @author Ilya Gubarev
 */
public final class ShellSorter extends AbstractSorter {

    private final GapProvider _provider;

    /**
     * Creates a new instance of ShellSorting with specified gap provider.
     *
     * @param provider gap values provider.
     *
     * @see GapProvider
     */
    public ShellSorter(GapProvider provider) {
        _provider = provider;
    }

    @Override
    public String getInfo() {
        return "Shell method with " + _provider.getSequenceInfo();
    }

    @Override
    public void prepare(int n) {
        _provider.reset(n);
    }

    @Override
    public <T> void sort(ArrayModel<T> target, Comparator<T> comparator,
            ArrayModelFactory arrayFactory, NodeModelFactory nodeFactory,
            Registry recursions, Stopwatch stopwatch) {
        while (!_provider.isEmpty()) {
            int gap = _provider.getNext();
            for (int pivot = gap; pivot < target.getSize(); ++pivot) {
                int i = pivot;
                while (i >= gap && swapIfLess(target, comparator, i, i - gap)) {
                    i = i - gap;
                }
                stopwatch.check();
            }
        }
    }
}
