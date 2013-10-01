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
import com.ilyagubarev.algorithms.adt.collections.queues.PriorityQueueModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;
import com.ilyagubarev.algorithms.adt.utils.Registry;
import com.ilyagubarev.algorithms.adt.utils.Stopwatch;

/**
 * Sorting algorithm implementation based on binary heap properties.
 *
 * @see AbstractSorter
 *
 * @version 1.03, 01 October 2013
 * @since 16 September 2013
 * @author Ilya Gubarev
 */
public final class HeapSorter extends AbstractSorter {

    @Override
    public String getInfo() {
        return "Heap based method";
    }

    @Override
    public <T> void sort(ArrayModel<T> target, Comparator<T> comparator,
            ArrayModelFactory arrayFactory, NodeModelFactory nodeFactory,
            Registry recursions, Stopwatch stopwatch) {
        for (int i = target.getSize() - 1; i > target.getSize() / 2; i--) {
            surface(target, i, comparator, recursions);
            stopwatch.check();
        }
    }

    private <T> void surface(ArrayModel<T> target, int itemIndex,
            Comparator<T> comparator, Registry recursions) {
        int parent = itemIndex / 2;
        if ((parent > 0) && (less(target, comparator, parent, itemIndex))) {
            T buffer = target.read(itemIndex);
            target.write(itemIndex, target.read(parent));
            target.write(parent, buffer);
            registerRecursiveCall(recursions);
            surface(target, parent, comparator, recursions);
            registerRecursiveReturn(recursions);
        }
    }
}

//    @Override
//    public <T> void sort(ArrayModel<T> target, Comparator<T> comparator,
//            ArrayModelFactory arrayFactory, NodeModelFactory nodeFactory,
//            Registry recursions, Stopwatch stopwatch) {
//        PriorityQueueModel<T> heap = new PriorityQueueModel<T>(target.getSize(),
//                comparator, arrayFactory);
//        for (T item : target) {
//            heap.enqueue(item);
//        }
//        for (int i = 0; i < target.getSize(); i++) {
//            target.write(i, heap.dequeue());
//        }
//    }