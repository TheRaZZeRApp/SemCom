package com.therazzerapp.semcom.content.semantic.logic.quantor;

import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.expression.SVariable;
import com.therazzerapp.semcom.content.semantic.logic.LObject;
import com.therazzerapp.semcom.content.semantic.type.Type;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class LQuantor extends LObject {

    /**
     *
     */
    private Quantor quantor;

    public <T extends Type>LQuantor(T typ, Quantor quantor, SVariable variable, SObject scope) {
        super(typ);
        this.quantor = quantor;
        variable.setBound(true);
        addVariable(variable);
        addObject(scope);
    }

    /**
     *
     * @return
     */
    public LinkedList<SVariable> getVariablesInScope(){
        return getObjects().get(0).getVariables();
    }

    /**
     *
     * @return
     */
    public Quantor getQuantor() {
        return quantor;
    }

    /**
     *
     * @return
     */
    public SVariable getVariable() {
        return getVariables().get(0);
    }

    @Override
    public String getLatexCode() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return quantor.getName() + getVariable().toString();
    }
}
