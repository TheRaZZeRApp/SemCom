package com.therazzerapp.semcom.content.semantic;

import com.therazzerapp.semcom.content.semantic.expression.SVariable;
import com.therazzerapp.semcom.content.semantic.type.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * <description>
 *
 * @author Paul Eduard Koenig <s6604582@stud.uni-frankfurt.de>
 * @since 0.0.0
 */
public abstract class SObject {

    /**
     *
     */
    private Set<? super Type> type = new HashSet<>();

    /**
     *
     */
    private LinkedList<SVariable> variables = new LinkedList<>();

    /**
     *
     * @param typ
     */
    public SObject(Typ typ) {
        this.type.add(new TypeAtom(typ));
    }

    /**
     *
     * @param type
     */
    public <T extends Type>SObject(T type) {
        this.type.add(type);
    }

    /**
     *
     * @param <T>
     * @return
     */
    public <T extends Type> T getType() {
        try{
            return (T) type.iterator().next();
        } catch (ClassCastException ignored){
            return null;
        }
    }

    /**
     *
     * @param type
     * @param <T>
     */
    public <T extends Type> void setType(T type) {
        this.type.clear();
        this.type.add(type);
    }

    /**
     *
     * @return
     */
    public TypeAtom getTypeAtom(){
        return isAtom() ? getType() : null;
    }

    /**
     *
     * @return
     */
    public TypeSimple getTypeSimple(){
        return isSimple() ? getType() : null;
    }

    /**
     *
     * @return
     */
    public TypeComplex getTypeComplex(){
        return isComplex() ? getType() : null;
    }

    /**
     * Checks if the argument is of type {@link TypeAtom}
     * @return true if the argument is atom, false if not
     */
    public boolean isAtom(){
        return (getType() != null) && getType() instanceof TypeAtom;
    }

    /**
     * Checks if the argument is of type {@link TypeSimple}
     * @return true if the argument is simple, false if not
     */
    public boolean isSimple(){
        return (getType() != null) && getType() instanceof TypeSimple;
    }

    /**
     * Checks if the argument is of type {@link TypeComplex}
     * @return true if the argument is complex, false if not
     */
    public boolean isComplex(){
        return (getType() != null) && getType() instanceof TypeComplex;
    }

    /**
     *
     * @return
     */
    public abstract String getLatexCode();

    /**
     *
     * @return
     */
    public LinkedList<SVariable> getVariables(){
        return variables;
    }

    /**
     *
     * @param variables
     */
    public void addVariables(LinkedList<SVariable> variables){
        this.variables.addAll(variables);
    }

    /**
     *
     * @param variable
     */
    public void addVariable(SVariable variable){
        variables.addLast(variable);
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean containsVariable(String name){
        for (SVariable boundVariable : variables) {
            if (boundVariable.getExpression().equals(name)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param name
     */
    public void removeVariable(String name){
        variables.removeIf(variable -> variable.getExpression().equals(name));
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean isVariableBound(String name){
        for (SVariable variable : variables) {
            if (variable.getExpression().equals(name)){
                return variable.isBound();
            }
        }
        return false;
    }

    /**
     *
     * @param name
     * @param <T>
     * @return
     */
    public <T extends Type> T getTypeOfVariable(String name){
        for (SVariable variable : variables) {
            if (variable.getExpression().equals(name)){
                return variable.getType();
            }
        }
        return null;
    }

    /**
     *
     * @param name
     */
    public void bindVariable(String name){
        for (SVariable variable : variables) {
            if (variable.getExpression().equals(name)){
                int i = variables.indexOf(variable);
                variables.remove(variable);
                variable.setBound(true);
                variables.add(i,variable);
            }
        }
    }

    /**
     *
     * @param vSet
     * @return
     */
    public boolean checkVariables(LinkedList<SVariable> vSet){
        for (SVariable v : vSet) {
            if (containsVariable(v.getExpression())){
                if (v.isBound() != isVariableBound(v.getExpression()) || !v.getType().equals(getTypeOfVariable(v.getExpression()))){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
