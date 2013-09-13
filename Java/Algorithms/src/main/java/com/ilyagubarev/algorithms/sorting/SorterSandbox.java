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

import com.ilyagubarev.algorithms.sorting.methods.Sorter;
import com.ilyagubarev.algorithms.adt.ItemArray;
import com.ilyagubarev.algorithms.adt.ItemArrayFactory;
import com.ilyagubarev.algorithms.adt.ItemHelper;
import com.ilyagubarev.algorithms.adt.ItemNodeFactory;
import com.ilyagubarev.algorithms.adt.tools.Stopwatch;

/**
 *
 * @author Ilya Gubarev
 */
public final class SorterSandbox {

    /**
     * 
     *
     * @param sorter
     * @param target
     * @param helper
     * @param arrayFactory
     * @param nodeFactory
     * @param stopwatch
     *
     * @see ItemArray
     * @see ItemArrayFactory
     * @see ItemNodeFactory
     * @see ItemHelper
     * @see Sorter
     * @see Stopwatch
     */
    public static void run(Sorter sorter, ItemArray target, ItemHelper helper,
            ItemArrayFactory arrayFactory, ItemNodeFactory nodeFactory,
            Stopwatch stopwatch) {
        sorter.prepare(target.getSize());
        stopwatch.start();
        sorter.sort(target, helper, arrayFactory, nodeFactory);
        stopwatch.stop();
    }

    private SorterSandbox() {

    }
}