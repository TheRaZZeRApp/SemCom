package com.therazzerapp.semcom.content.semantic.lambda;

import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.Type;


/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class LDObject extends SObject {

    /**
     *
     */
    private boolean printType;

    public LDObject(Typ typ, boolean printType) {
        super(typ);
        this.printType = printType;
    }

    public <T extends Type>LDObject(T type, boolean printType) {
        super(type);
        this.printType = printType;
    }

    /**
     *
     * @return
     */
    public boolean isPrintType() {
        return printType;
    }

    /**
     *
     * @param printType
     */
    public void setPrintType(boolean printType) {
        this.printType = printType;
    }

    @Override
    public abstract String getLatexCode();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
