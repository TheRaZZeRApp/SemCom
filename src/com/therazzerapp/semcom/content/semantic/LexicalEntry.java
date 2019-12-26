package com.therazzerapp.semcom.content.semantic;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class LexicalEntry extends SObject{

    /**
     *
     */
    private String lexem;

    /**
     *
     */
    private SObject translation;

    /**
     * Defines if the lexem will be printed bold or not in the latex code.
     */
    private boolean isFat;

    public LexicalEntry(String lexem, SObject translation, boolean isFat) {
        super(translation.getType());
        this.lexem = lexem;
        this.isFat = isFat;
        this.translation = translation;
        addVariables(translation.getVariables());

    }

    /**
     *
     * @return
     */
    public String getLexem() {
        return lexem;
    }

    /**
     *
     * @return
     */
    public boolean isFat() {
        return isFat;
    }

    /**
     *
     * @return
     */
    public SObject getTranslation() {
        return translation;
    }

    @Override
    public String getLatexCode() {
        return lexem;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LexicalEntry)){
            return false;
        }
        if (!((LexicalEntry) obj).getLexem().equals(lexem)){
            return false;
        }
        if (!((LexicalEntry) obj).getType().equals(getType())){
            return false;
        }
        if (!((LexicalEntry) obj).getTranslation().equals(translation)){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "|" + lexem + "|";
    }
}
