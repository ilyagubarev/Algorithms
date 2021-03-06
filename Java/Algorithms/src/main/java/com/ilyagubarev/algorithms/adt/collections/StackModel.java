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
package com.ilyagubarev.algorithms.adt.collections;

/**
 * LIFO policy collection model common interface.
 *
 * @see CollectionModel
 *
 * @version 1.04, 19 September 2013
 * @since 02 September 2013
 * @author Ilya Gubarev
 */
public interface StackModel<T> extends CollectionModel<T> {

    /**
     * Gets the latest pushed item.
     *
     * @return the latest pushed item.
     * @throws IllegalStateException if the stack is empty.
     */    
    T peek();

    /**
     * Gets the latest pushed item and removes it from the stack.
     *
     * @return the latest pushed item.
     * @throws IllegalStateException if the stack is empty.
     */    
    T pop();

    /**
     * Pushes down a new item into the stack.
     *
     * @param item an item to be pushed to the stack.
     */
    void push(T item);
}
