package com.example.kvtag.util;

import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FormulaEvaluator {

    public static boolean evaluateFormula(String formula, Object item, String objectType){
        Map<String, Object> vars = new HashMap<>();
        vars.put(objectType, item);

        Serializable compiled = MVEL.compileExpression(formula);

        return (boolean) MVEL.executeExpression(compiled, vars);
    }
}
