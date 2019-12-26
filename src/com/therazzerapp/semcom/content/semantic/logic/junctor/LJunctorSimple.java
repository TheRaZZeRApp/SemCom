package com.therazzerapp.semcom.content.semantic.logic.junctor;

import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.TypeAtom;
import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.type.TypeSimple;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class LJunctorSimple extends LJunctor {

    /**
     *
     * @param junctor
     * @param object
     */
    public LJunctorSimple(Junctor junctor, SObject object, boolean forceTruthType) {
        super(new TypeSimple(Typ.TRUTHVALUE,Typ.TRUTHVALUE),junctor, forceTruthType);
        addObject(object);
        addVariables(object.getVariables());
    }

    @Override
    public String getLatexCode() {
        return getJunctor().getLatexCode() + getObjects().getFirst().getLatexCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LJunctorSimple)){
            return false;
        }
        if (!getJunctor().equals(((LJunctorSimple) obj).getJunctor())){
            return false;
        }
        return getArgument(0).equals(((LJunctorSimple) obj).getArgument(0));
    }

    @Override
    public String toString() {
        return getJunctor().getName() + " " + getObjects().getFirst().toString();
    }

    @Override
    public boolean isValid() {
        if (getArgument(0).getType().equals(new TypeAtom(Typ.TRUTHVALUE))){
            return true;
        }
        return !isForceTruthType();
    }
}
