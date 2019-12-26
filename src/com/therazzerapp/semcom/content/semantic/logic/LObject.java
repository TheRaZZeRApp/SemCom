package com.therazzerapp.semcom.content.semantic.logic;

import com.therazzerapp.semcom.content.semantic.type.Type;
import com.therazzerapp.semcom.content.semantic.SObject;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class LObject extends SObject {

    /**
     *
     */
    private LinkedList<SObject> objects = new LinkedList<>();

    /**
     *
     */
    public <T extends Type>LObject(T typ) {
        super(typ);
    }

    /**
     *
     * @param object
     */
    public void addObject(SObject object){
        this.objects.addLast(object);
    }

    /**
     *
     * @return
     */
    protected LinkedList<SObject> getObjects() {
        return objects;
    }

    @Override
    public <T extends Type> void setType(T type) {

    }

    @Override
    public abstract String getLatexCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
