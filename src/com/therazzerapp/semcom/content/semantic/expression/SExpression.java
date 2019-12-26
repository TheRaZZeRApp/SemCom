package com.therazzerapp.semcom.content.semantic.expression;

import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.Type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class SExpression extends SObject {

    String expression;
    boolean printType;


    public <T extends Type>SExpression(T type, String expression) {
        super(type);
        this.expression = expression;
    }

    public SExpression(Typ typ, String expression, boolean printType) {
        super(typ);
        this.expression = expression;
        this.printType = printType;
    }

    public <T extends Type>SExpression(T type, String expression, boolean printType) {
        super(type);
        this.expression = expression;
        this.printType = printType;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public String getLatexCode() {
        return printType ? getExpression() + "\\textsubscript{" + getType().getLatexName() + "}" : getExpression();
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
