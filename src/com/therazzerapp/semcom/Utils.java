package com.therazzerapp.semcom;

import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.type.Type;
import com.therazzerapp.semcom.content.semantic.type.TypeAtom;
import com.therazzerapp.semcom.content.semantic.type.TypeComplex;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class Utils {
    public static <T extends Type, S extends SObject> T compileType(LinkedList<? super SObject> objects){
        if (objects.size() == 1){
            return ((S)objects.get(0)).getType();
        }
        LinkedList<TypeComplex> tList = new LinkedList<>();
        int j = 0;
        for (int i = objects.size()-1; i > 0; i--) {
            if (j == 0){
                tList.addLast(new TypeComplex(((S)objects.get(i-1)).getType(),(((S)objects.get(i)).getType())));
            } else {
                tList.addLast(new TypeComplex(((S)objects.get(i-1)).getType(),tList.get(j-1)));
            }
            j++;

        }
        return (T) tList.getLast();
    }

    /**
     * d
     * @param type
     * @param args
     * @param <T>
     * @return
     */
    public static <T extends Type> T calcType(T type, LinkedList<? extends SObject> args){
        if (type == null){
            return null;
        }
        if (args == null || args.size() == 0){
            return type;
        }
        //todo
        return type;
    }


}
