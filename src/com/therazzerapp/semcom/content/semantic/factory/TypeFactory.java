package com.therazzerapp.semcom.content.semantic.factory;

import com.therazzerapp.semcom.content.semantic.type.*;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class TypeFactory {

    /**
     *
     * @param extension
     * @param <T>
     * @return
     */
    public static <T extends Type> T createIntensionType(T extension){
        return (T) new TypeComplex(Typ.SITUATION,extension);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewSituationType(){
        return (T) new TypeAtom(Typ.SITUATION);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewEntityType(){
        return (T) new TypeAtom(Typ.ENTITY);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewTruthType(){
        return (T) new TypeAtom(Typ.TRUTHVALUE);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewEntityTruthType(){
        return (T) new TypeSimple(Typ.ENTITY,Typ.TRUTHVALUE);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewTruthTruthType(){
        return (T) new TypeSimple(Typ.TRUTHVALUE,Typ.TRUTHVALUE);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewSituationTruthType(){
        return (T) new TypeSimple(Typ.SITUATION,Typ.TRUTHVALUE);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewTransitiveVerbType(){
        return (T) new TypeComplex(Typ.ENTITY,new TypeSimple(Typ.ENTITY,Typ.TRUTHVALUE));
    }

    /**
     *
     * @param type
     * @param <T>
     * @return
     */
    public static <T extends Type> T createNewModificatorType(T type){
        return (T) new TypeComplex(type,type);
    }

}
