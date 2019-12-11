/*
 * FXGL - JavaFX Game Library. The MIT License (MIT).
 * Copyright (c) AlmasB (almaslvl@gmail.com).
 * See LICENSE for details.
 */

package com.almasb.fxgl.entity.action;

import com.almasb.fxgl.entity.Entity;

/**
 * A single entity action.
 * The action is finished after its execution.
 *
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public abstract class Action {

    /**
     * The entity performing this action.
     */
    protected Entity entity;

    protected boolean isCompleted = false;

    private boolean isCancelled = false;

    /**
     * @return entity to which the action is attached, or null if action is not attached
     */
    public final Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        if (this.entity != null && this.entity != entity)
            throw new IllegalArgumentException("Attempting to set a different entity to action");

        this.entity = entity;
    }

    /**
     * @return true if this action is complete and does not require further execution
     */
    public boolean isComplete() {
        return isCompleted;
    }

    // TODO: final methods?
    public boolean isCancelled() {
        return isCancelled;
    }

    public void cancel() {
        isCancelled = true;
    }

    public void reset() {
        isCompleted = false;
        isCancelled = false;
        //entity = null;
        onReset();
    }

    protected void onReset() { }

    /**
     * Called on entity world update tick.
     *
     * @param tpf time per frame
     */
    protected abstract void onUpdate(double tpf);

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
