package com.therazzerapp.semcom.content.semantic.type;

import com.therazzerapp.semcom.Constants;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public class TypeComplex extends Type {

    private LinkedList<? super Type> arguments;
    private Set<? super Type> value = new HashSet<>();

    public <T extends Type>TypeComplex(Typ argument, Typ value) {
        super(null);
        this.arguments = new LinkedList<>();
        this.arguments.addLast(new TypeAtom(argument));
        this.value.add(new TypeAtom(value));
    }

    public <T extends Type>TypeComplex(Typ argument, T value) {
        super(null);
        this.arguments = new LinkedList<>();
        this.arguments.addLast(new TypeAtom(argument));
        this.value.add(value);
    }

    public <T extends Type>TypeComplex(LinkedList<? super Type> arguments, T value) {
        super(null);
        this.arguments = arguments;
        this.value.add(value);
    }

    public <T extends Type>TypeComplex(T argument, T value) {
        super(null);
        LinkedList<? super Type> args = new LinkedList<>();
        args.addLast(argument);
        this.arguments = args;
        this.value.add(value);
    }

    public LinkedList<? super TypeAtom> getArguments() {
        return arguments;
    }

    /**
     *
     * @param <T>
     * @return
     */
    @Override
    public <T extends Type> T getValue() {
        return (T) value.iterator().next();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Type)){
            return false;
        }
        return toString().equals(obj.toString()); //I know I know...
    }

    @Override
    public String getLatexName() {
        if (arguments == null){
            return getValue().getLatexName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.SYMBOL_BRACKET_TYPE_L);
        if (arguments.size() > 1){
            sb.append(Constants.SYMBOL_BRACKET_TYPE_L);
        }
        for (Object argument : arguments) {
            Type t = (Type) argument;
            sb.append(t.getLatexName());
            sb.append(Constants.SYMBOL_BRACKET_TYPE_COMMA);
        }
        sb.setLength(sb.length()-1);
        if (arguments.size() > 1){
            sb.append(Constants.SYMBOL_BRACKET_TYPE_R);
        }
        sb.append(Constants.SYMBOL_BRACKET_TYPE_COMMA);
        sb.append(getValue().getLatexName());
        sb.append(Constants.SYMBOL_BRACKET_TYPE_R);
        return sb.toString();
    }

    @Override
    public String toString() {
        if (arguments == null){
            return getValue().toString();
        }
        StringBuilder sb = new StringBuilder();
        if (arguments.size() > 0 && value.size()!=0){
            sb.append("(");
        }
        for (Object argument : arguments) {
            Type t = (Type) argument;
            sb.append(t.toString());
            sb.append(",");
        }
        sb.setLength(sb.length()-1);
        if (arguments.size() > 1){
            sb.append(")");
        }
        sb.append(",");
        sb.append(getValue().toString());
        sb.append(")");
        return sb.toString();
    }
}
