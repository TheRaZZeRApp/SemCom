package com.therazzerapp.semcom.content.semantic.type;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public enum Typ {

    TRUTHVALUE("t"),
    ENTITY("e"),
    SITUATION("s");

    private final String name;

    Typ(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getLatexCode() {
        return "$" + name + "$";
    }

}
