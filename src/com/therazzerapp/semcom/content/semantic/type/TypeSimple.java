package com.therazzerapp.semcom.content.semantic.type;

import com.therazzerapp.semcom.Constants;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class TypeSimple extends Type {

    private Typ argument;

    public TypeSimple(Typ argument, Typ value) {
        super(value);
        this.argument = argument;
    }

    /**
     *
     * @return
     */
    public Typ getArgument() {
        return argument;
    }

    @Override
    public String getLatexName() {
        return Constants.SYMBOL_BRACKET_TYPE_L + argument.getLatexCode() + Constants.SYMBOL_BRACKET_TYPE_COMMA + getAtomValue().getLatexCode() + Constants.SYMBOL_BRACKET_TYPE_R;
    }

    @Override
    public String toString() {
        return "(" + argument.getName() + "," +  getAtomValue().getName() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TypeSimple)){
            return false;
        }
        if (((TypeSimple) obj).argument != argument){
            return false;
        }
        if (((TypeSimple) obj).getAtomValue() != getAtomValue()){
            return false;
        }
        return true;
    }

    @Override
    public <T extends Type> T getValue() {
        return (T) new TypeAtom(getAtomValue());
    }
}
