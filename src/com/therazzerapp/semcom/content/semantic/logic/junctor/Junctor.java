package com.therazzerapp.semcom.content.semantic.logic.junctor;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public enum Junctor {
    AND("\u2227","\\land"),
    OR("\u2228","\\lor"),
    NOT("\u00AC","\\lnot"),
    EQUAL("=","="),
    MIMPLICATION("\u2192","\\rightarrow");

    private final String name;
    private final String latexCode;

    Junctor(String name, String latexCode) {
        this.name = name;
        this.latexCode = latexCode;
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
        return "$" + latexCode + "$";
    }
}
