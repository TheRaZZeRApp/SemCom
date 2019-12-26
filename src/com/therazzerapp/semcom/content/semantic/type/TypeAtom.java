package com.therazzerapp.semcom.content.semantic.type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class TypeAtom extends Type{

    public TypeAtom(Typ value) {
        super(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof TypeAtom)){
            return false;
        }
        return ((TypeAtom) obj).getAtomValue() == getAtomValue();
    }

    @Override
    public String getLatexName() {
        return getAtomValue().getLatexCode();
    }

    @Override
    public String toString() {
        return getAtomValue().getName();
    }

    @Override
    public <T extends Type> T getValue() {
        return (T) this;
    }
}
