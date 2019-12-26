package com.therazzerapp.semcom.content.semantic.lambda;

import com.therazzerapp.semcom.Constants;
import com.therazzerapp.semcom.Utils;
import com.therazzerapp.semcom.content.semantic.SObject;
import com.therazzerapp.semcom.content.semantic.expression.SVariable;
import com.therazzerapp.semcom.content.semantic.logic.junctor.LJunctor;
import com.therazzerapp.semcom.content.semantic.type.Typ;
import com.therazzerapp.semcom.content.semantic.type.Type;
import com.therazzerapp.semcom.content.semantic.type.TypeAtom;
import com.therazzerapp.semcom.content.semantic.type.TypeComplex;

import java.util.LinkedList;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since <version>
 */
public class LDFunction extends LDObject {

    /**
     * The master prefix of the lambda function.
     */
    LDPrefix prefix;

    /**
     * The main body of the lambda function.
     */
    SObject body;

    /**
     * The ordered list of arguments that will be applied to the function.
     */
    LinkedList<SObject> arguments = new LinkedList<>();

    /**
     * Defines if the function will be printed within brackets or without.
     */
    boolean brackets;


    public LDFunction(LDPrefix prefix, SObject body, SObject argument, boolean printType, boolean brackets) {
        super(new TypeAtom(null),printType);
        this.prefix = prefix;
        this.body = body;
        this.arguments.addLast(argument);
        this.brackets = brackets;
        setType(compileType());
        addVariables(body.getVariables());
    }


    public LDFunction(LDPrefix prefix, SObject body, boolean printType, boolean brackets) {
        super(new TypeAtom(null),printType);
        this.prefix = prefix;
        this.body = body;
        this.brackets = brackets;
        setType(compileType());
        addVariables(body.getVariables());
    }

    public LDFunction(LDPrefix prefix, SObject body, LinkedList<SObject> arguments, boolean printType, boolean brackets) {
        super(new TypeAtom(null),printType);
        this.prefix = prefix;
        this.body = body;
        if (arguments != null){
            this.arguments.addAll(arguments);
        }
        this.brackets = brackets;
        setType(compileType());
        addVariables(body.getVariables());
    }

    public LDFunction(LDPrefix prefix, SObject body, LinkedList<SObject> arguments, boolean printType) {
        super(new TypeAtom(null),printType);
        this.prefix = prefix;
        this.body = body;
        if (arguments != null){
            this.arguments.addAll(arguments);
        }
        setType(compileType());
        addVariables(body.getVariables());
    }

    public LDFunction(LDPrefix prefix, SObject body, LinkedList<SObject> arguments) {
        super(new TypeAtom(null), false);
        this.prefix = prefix;
        this.body = body;
        if (arguments != null){
            this.arguments.addAll(arguments);
        }
        setType(compileType());
        addVariables(body.getVariables());
    }

    /**
     *
     * @return
     */
    public LinkedList<? super SObject> getMatrixPrefix(){
        LinkedList<? super SObject> list = new LinkedList<>();
        list.addLast(prefix);
        SObject b = body;
        while (b instanceof LDFunction){
            list.add(((LDFunction) b).prefix);
            b = ((LDFunction) b).body;
        }
        return list;
    }

    /**
     * Returns all variables found in the matrix prefix of the lambda function.
     * @return
     */
    public LinkedList<SVariable> getHeadVariables(){
        LinkedList<SVariable> variables = new LinkedList<>();
        for (Object matrixPrefix : getMatrixPrefix()) {
            variables.addAll(((SObject)matrixPrefix).getVariables());
        }
        return variables;
    }

    /**
     *
     * @param <T>
     * @return
     */
    private <T extends Type> T compileType(){
        if (arguments.size() == 0){
            if (body instanceof LJunctor){
                return (T) new TypeComplex(prefix.getType(), new TypeAtom(Typ.TRUTHVALUE));
            }
            return (T) new TypeComplex(prefix.getType(),body.getType());
        }
        return Utils.calcType(Utils.compileType(getMatrixPrefix()),arguments);
    }

    /**
     * Returns the prefix of the lambda function.
     * @return
     */
    public LDPrefix getPrefix() {
        return prefix;
    }

    /**
     * Returns the body of the lambda function.
     * @return
     */
    public SObject getBody() {
        return body;
    }

    /**
     * Returns the arguments that will be applied to the lambda function.
     * @return
     */
    public LinkedList<SObject> getArguments() {
        return arguments;
    }

    /**
     *
     * @return
     */
    public boolean isBrackets() {
        return brackets;
    }

    @Override
    public String getLatexCode() {
        StringBuilder sb = new StringBuilder();
        for (SObject argument : arguments) {
            sb.append("(");
            sb.append(argument.getLatexCode());
            sb.append(")");
        }
        String t = body.getLatexCode();
        if (brackets){
            t = Constants.SYMBOL_BRACKETL + body.getLatexCode() + Constants.SYMBOL_BRACKETR;
        }
        return prefix.getLatexCode() + t + sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LDFunction)){
            return false;
        } if (!getType().equals(((LDFunction) obj).getType())){
            return false;
        } if (!getPrefix().equals(((LDFunction) obj).getPrefix())){
            return false;
        } if (!getBody().equals(((LDFunction) obj).getBody())){
            return false;
        } if (getArguments().size() != ((LDFunction) obj).getArguments().size()){
            return false;
        }
        for (SObject argument : arguments) {
            if (!((LDFunction) obj).getArguments().contains(argument)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (SObject argument : arguments) {
            sb.append("(");
            sb.append(argument.toString());
            sb.append(")");
        }
        String t = body.toString();
        if (brackets){
            t = Constants.SYMBOL_BRACKETL + body.toString() + Constants.SYMBOL_BRACKETR;
        }
        return prefix.toString() + t + sb.toString();
    }
}
