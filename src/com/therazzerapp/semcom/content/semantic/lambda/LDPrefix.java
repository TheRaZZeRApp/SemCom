package com.therazzerapp.semcom.content.semantic.lambda;

import com.therazzerapp.semcom.Constants;
import com.therazzerapp.semcom.content.semantic.expression.SExpression;
import com.therazzerapp.semcom.content.semantic.type.Type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since <version>
 */
public class LDPrefix extends LDObject {

    /**
     *
     */
    private SExpression expression;

    public <T extends Type> LDPrefix(SExpression expression, boolean printType) {
        super(expression.getType(), printType);
        this.expression = expression;
        addVariables(expression.getVariables());
    }

    public <T extends Type> LDPrefix(SExpression expression) {
        super(expression.getType(), false);
        this.expression = expression;
        addVariables(expression.getVariables());
    }

    public SExpression getExpression() {
        return expression;
    }

    @Override
    public String getLatexCode() {
        String t = getType().getLatexName();
        if (isAtom()){
            t = Constants.SYMBOL_BRACKET_TYPE_L + getType().getLatexName() + Constants.SYMBOL_BRACKET_TYPE_R;
        }
        return isPrintType() ? Constants.SYMBOL_LAMBDA + expression.getExpression() + "\\textsubscript{" + t + "}" : Constants.SYMBOL_LAMBDA + expression.getExpression();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LDPrefix)){
            return false;
        }
        if (!getType().equals(((LDPrefix) obj).getType())){
            return false;
        }
        if (!expression.equals(((LDPrefix) obj).getExpression())){
            return false;
        }
        if (getVariables().size() != ((LDPrefix) obj).getVariables().size()){
            return false;
        }
        if (!checkVariables(((LDPrefix) obj).getVariables())){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\u03BB" + expression.getExpression() + ".";
    }
}
