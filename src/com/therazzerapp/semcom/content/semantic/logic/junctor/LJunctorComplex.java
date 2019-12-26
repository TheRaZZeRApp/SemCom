package com.therazzerapp.semcom.content.semantic.logic.junctor;

import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.TypeAtom;
import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.type.TypeComplex;
import com.therazzerapp.semcom.content.semantic.type.TypeSimple;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class LJunctorComplex extends LJunctor {

    /**
     *
     * @param junctor
     * @param object
     * @param object2
     * @param forcedTruthType
     */
    public LJunctorComplex(Junctor junctor, SObject object, SObject object2, boolean forcedTruthType) {
        super(new TypeComplex(new TypeAtom(Typ.TRUTHVALUE),new TypeSimple(Typ.TRUTHVALUE,Typ.TRUTHVALUE)),junctor, forcedTruthType);
        addObject(object);
        addObject(object2);
        addVariables(object.getVariables());
        addVariables(object2.getVariables());
    }

    /**
     *
     * @param junctor
     * @param object
     * @param object2
     */
    public LJunctorComplex(Junctor junctor, SObject object, SObject object2) {
        super(new TypeComplex(new TypeAtom(Typ.TRUTHVALUE),new TypeSimple(Typ.TRUTHVALUE,Typ.TRUTHVALUE)),junctor, true);
        addObject(object);
        addObject(object2);
        addVariables(object.getVariables());
        addVariables(object2.getVariables());
    }

    @Override
    public String getLatexCode() {
        return getArgument(0).getLatexCode() + " " +  getJunctor().getLatexCode() + " " + getArgument(1).getLatexCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LJunctorComplex)){
            return false;
        }
        if (!getJunctor().equals(((LJunctorComplex) obj).getJunctor())){
            return false;
        }
        if (!getArgument(0).equals(((LJunctorComplex) obj).getArgument(0))){
            return false;
        }
        return getArgument(1).equals(((LJunctorComplex) obj).getArgument(1));
    }

    @Override
    public String toString() {
        return getArgument(0).toString() + " " + getJunctor().getName() + " " + getArgument(1).toString();
    }

    @Override
    public boolean isValid() {
        if (getArgument(0).getType().equals(new TypeAtom(Typ.TRUTHVALUE)) && getArgument(1).getType().equals(new TypeAtom(Typ.TRUTHVALUE))){
            return true;
        }
        if (getJunctor().equals(Junctor.EQUAL) && !isForceTruthType()){
            return getArgument(0).getType().equals(getArgument(1).getType());
        }
        else return !isForceTruthType();
    }
}
