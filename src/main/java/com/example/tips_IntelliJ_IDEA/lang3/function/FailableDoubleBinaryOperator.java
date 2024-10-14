/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.tips_IntelliJ_IDEA.lang3.function;

import java.util.function.DoubleBinaryOperator;

/**
 * A functional interface like {@link DoubleBinaryOperator} that declares a {@code Throwable}.
 *
 * @param <E> Thrown exception.
 * @since 3.11
 */
@FunctionalInterface
public interface FailableDoubleBinaryOperator<E extends Throwable> {

    /**
     * Applies this operator to the given operands.
     *
     * @param left  the first operand
     * @param right the second operand
     * @return the operator result
     * @throws E if the operation fails
     */
    double applyAsDouble(double left, double right) throws E;
}
