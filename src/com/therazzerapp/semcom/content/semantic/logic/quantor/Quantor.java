package com.therazzerapp.semcom.content.semantic.logic.quantor;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public enum Quantor {
    UNIVERSAL("\u2200","\\forall"),
    EXISTENTIAL("\u2203","\\exists");

    private final String name;
    private final String latexCode;

    Quantor(String name, String latexCode) {
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
        return latexCode;
    }
}
