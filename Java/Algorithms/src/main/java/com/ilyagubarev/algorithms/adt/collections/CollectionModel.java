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
 * Collection model common interface.
 *
 * @see Iterable
 *
 * @version 1.02, 19 September 2013
 * @since 03 September 2013
 * @author Ilya Gubarev
 */
public interface CollectionModel<T> extends Iterable<T> {

    /**
     * Gets current size of the collection.
     *
     * @return current size.
     */
    int getSize();

    /**
     * Checks if the collection is empty.
     *
     * @return true if the collection is empty.
     */
    boolean isEmpty();    
}
