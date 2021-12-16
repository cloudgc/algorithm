package org.cloudfun.model.extand;

/**
 * @author cloudgc
 * @since 12/10/2021
 **/
public abstract sealed class Shape permits Circle, MyCircle {
    /**
     *
     */
   abstract void area();
}
