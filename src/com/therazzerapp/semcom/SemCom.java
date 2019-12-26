package com.therazzerapp.semcom;

import com.therazzerapp.semcom.content.semantic.expression.SConstant;
import com.therazzerapp.semcom.content.semantic.expression.SVariable;
import com.therazzerapp.semcom.content.semantic.factory.TypeFactory;
import com.therazzerapp.semcom.content.semantic.lambda.LDFunction;
import com.therazzerapp.semcom.content.semantic.lambda.LDPrefix;
import com.therazzerapp.semcom.content.semantic.logic.junctor.Junctor;
import com.therazzerapp.semcom.content.semantic.logic.junctor.LJunctorComplex;
import com.therazzerapp.semcom.content.semantic.type.*;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class SemCom {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        TypeSimple typeST = new TypeSimple(Typ.SITUATION,Typ.TRUTHVALUE);
        LDPrefix ldP = new LDPrefix(new SVariable(typeST,"p",true));
        LDPrefix ldX = new LDPrefix(new SVariable(TypeFactory.createNewEntityType(),"x",true));


    }
}
