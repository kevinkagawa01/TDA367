package com.cbm.tda367.model;

/**
 * Enables object cloning, without compromising internal representation of object's class.
 *
 * @author Kevin Pham
 * @author Simon Holst
 * @author Carl-Magnus Wall
 * @author Pegah Amanzadeh
 * @version 0.2
 * @since 0.2
 */
public interface Prototype<T> {

    /**
     * Returns a safe copy of object.
     *
     * @return safe copy of object.
     */
    T cloneObject();
}
