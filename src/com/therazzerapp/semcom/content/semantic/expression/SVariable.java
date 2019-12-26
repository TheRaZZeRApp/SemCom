package com.therazzerapp.semcom.content.semantic.expression;

import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.Type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class SVariable extends SExpression {

    private boolean bound;

    public SVariable(Typ typ, String expression, boolean bound, boolean printType) {
        super(typ, expression, printType);
        this.bound = bound;
        addVariable(this);
    }

    public <T extends Type> SVariable(T type, String expression, boolean bound, boolean printType) {
        super(type, expression, printType);
        this.bound = bound;
        addVariable(this);
    }

    public <T extends Type> SVariable(T type, String expression, boolean bound) {
        super(type, expression);
        this.bound = bound;
        addVariable(this);
    }

    public <T extends Type> SVariable(T type, String expression) {
        super(type, expression);
        addVariable(this);
    }

    public boolean isBound() {
        return bound;
    }

    public void setBound(boolean bound) {
        this.bound = bound;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SVariable)){
            return false;
        }
        if (!getType().equals(((SVariable) obj).getType())){
            return false;
        }
        if (isBound() != ((SVariable) obj).isBound()){
            return false;
        }
        return getExpression().equals(((SVariable) obj).getExpression());
    }

    @Override
    public String toString() {
        return getExpression();
    }
}
