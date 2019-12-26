package com.therazzerapp.semcom.content.semantic.logic.junctor;

import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.logic.LObject;
import com.therazzerapp.semcom.content.semantic.type.Type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class LJunctor extends LObject {

    /**
     *
     */
    private Junctor junctor;

    /**
     *
     */
    private boolean forceTruthType;

    /**
     *
     * @param typ
     * @param junctor
     * @param forceTruthType
     * @param <T>
     */
    public <T extends Type>LJunctor(T typ, Junctor junctor, boolean forceTruthType) {
        super(typ);
        this.junctor = junctor;
        this.forceTruthType = forceTruthType;
    }

    /**
     *
     * @param typ
     * @param junctor
     * @param <T>
     */
    public <T extends Type>LJunctor(T typ, Junctor junctor) {
        super(typ);
        this.junctor = junctor;
        forceTruthType = true;
    }

    /**
     *
     * @return
     */
    public Junctor getJunctor() {
        return junctor;
    }

    /**
     *
     * @param index
     * @return
     */
    protected SObject getArgument(int index){
        return getObjects().get(index);
    }

    public boolean isForceTruthType() {
        return forceTruthType;
    }

    public abstract boolean isValid();

}
