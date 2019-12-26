package com.therazzerapp.semcom.content.semantic.expression;

import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.Type;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class SConstant extends SExpression {


    public <T extends Type>SConstant(T type, String expression, LinkedList<SVariable> variables, boolean printType) {
        super(type, expression, printType);
        addVariables(variables);
    }

    public SConstant(Typ typ, String expression, boolean printType) {
        super(typ, expression, printType);
    }

    public SConstant(Typ typ, String expression) {
        super(typ, expression, false);
    }

    public <T extends Type>SConstant(T type, String expression, boolean printType) {
        super(type, expression, printType);
    }

    public <T extends Type>SConstant(T type, String expression) {
        super(type, expression, false);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SConstant)){
            return false;
        }
        if (!getType().equals(((SConstant) obj).getType())){
            return false;
        }
        return getExpression().equals(((SConstant) obj).getExpression());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SVariable variable : getVariables()) {
            sb.append("(");
            sb.append(variable.toString());
            sb.append(")");
        }
        return getExpression() + sb.toString();
    }
}
