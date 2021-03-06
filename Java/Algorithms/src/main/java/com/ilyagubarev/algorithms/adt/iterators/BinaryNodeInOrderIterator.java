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
package com.ilyagubarev.algorithms.adt.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.ilyagubarev.algorithms.adt.collections.StackModel;
import com.ilyagubarev.algorithms.adt.collections.stacks.SimpleStackModel;
import com.ilyagubarev.algorithms.adt.nodes.BinaryNodeModel;
import com.ilyagubarev.algorithms.adt.nodes.NodeModelFactory;

/**
 * In order iterator over a tree based on binary node models.
 *
 * @see Iterator
 *
 * @version 1.04, 20 September 2013
 * @since 15 September 2013
 * @author Ilya Gubarev
 */
public final class BinaryNodeInOrderIterator<T> implements Iterator<T> {

    private final StackModel<BinaryNodeModel<T>> _passed;

    private BinaryNodeModel<T> _next;

    /**
     * Creates a new instance of BinaryNodeInOrderIterator.
     *
     * @param root a root node.
     * @param factory a node model factory.
     *
     * @see BinaryNodeModel
     * @see NodeModelFactory
     */
    public BinaryNodeInOrderIterator(BinaryNodeModel<T> root,
            NodeModelFactory factory) {
        _passed = new SimpleStackModel<BinaryNodeModel<T>>(factory);
        passToLeft(root);
    }

    @Override
    public boolean hasNext() {
        return _next != null;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("iterator has no next element");
        }
        T result = _next.getItem();
        BinaryNodeModel<T> node = _next.getRightChild();
        if (node != null) {
            passToLeft(node);            
        } else {
            while (!(_passed.isEmpty() || _next == _passed.pop())) {
                _next = _next.getParent();
            }
        }
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("removal is not supported");
    }

    private void passToLeft(BinaryNodeModel<T> node) {
        while (node != null) {
            _passed.push(node);
            node = node.getLeftChild();
        }
        _next = _passed.pop();
    }
}
