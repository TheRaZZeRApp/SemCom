package com.therazzerapp.semcom.content.semantic.type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since <version>
 */
public abstract class Type {

    private Typ value;

    public Type(Typ value) {
        this.value = value;
    }

    public abstract  <T extends Type> T getValue();

    public Typ getAtomValue() {
        return value;
    }

    public abstract String getLatexName();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
