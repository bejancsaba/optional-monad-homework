package com.reactive.monad;

import com.google.common.primitives.Ints;

import java.util.Optional;

/**
 * The goal is to implement the retrieval of an integer value.
 * The value is stored as a String inside MyNestedObject. This object is stored in MyObject.
 * Both MyObject, MyNestedObject and the value can be null.
 *
 * The return value is default "1" in case any of the earlier listed objects are null,
 * the String value can't be parsed to Integer or if it is a negative number.
 */
public class Worker {

    private static final Integer DEFAULT_RETURN_VALUE = 1;

    public Integer getPositiveIntFromObjectWithDefaultMonad(MyObject obj) {
        // TODO: Implement the same flow using Optional monad and function composition as shown below in the imperative code
        return -1;
    }

    /**
     * Introducing the Optional monad following the imperative approach doesn't achieve much.
     * Basically we are replacing the null check with the isPresent function call.
     *
     * @param obj the parameter MyObject
     * @return the nested number or 1 in case of missing data.
     */
    public Integer getPositiveIntFromObjectWithDefaultImperative(MyObject obj) {
        if (obj != null) {
            Optional<MyNestedObject> nested = obj.getNested();
            if (nested.isPresent()) {
                Optional<String> intLikeData = nested.get().getIntLikeData();
                if (intLikeData.isPresent()) {
                    Integer intValue = Ints.tryParse(intLikeData.get());
                    if (intValue != null) {
                        if (intValue >= 0) {
                            return intValue;
                        } else {
                            return DEFAULT_RETURN_VALUE;
                        }
                    } else {
                        return DEFAULT_RETURN_VALUE;
                    }
                } else {
                    return DEFAULT_RETURN_VALUE;
                }
            } else {
                return DEFAULT_RETURN_VALUE;
            }
        } else {
            return DEFAULT_RETURN_VALUE;
        }
    }

    public static Integer getDefault() {
        return DEFAULT_RETURN_VALUE;
    }
}
