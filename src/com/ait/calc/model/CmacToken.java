package com.ait.calc.model;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ait.calc.model.Token.TokenType;

/**
 * Created by C.I.T on 24-Sep-17.
 */
public abstract class CmacToken {

    public String stringRepresentation;
    public static String numericalRegex = "[0-9]\\d*(?:\\.\\d+)?|[0-9]\\d*(?:\\.\\d+)?(?:E-[\\d]+)?|π|ℇ";
    public static String precisionNumericalRegex = "[0-9]\\d*(?:\\.\\d+)?(?:E-[\\d]+)?";
    public static String operandRegex = "[\\-\\*\\+\\/\\^\\%\\(\\)\\!]";
    //public static String inlineFunctionRegex = "(?:cos|tan|sin|log)(?:\\([^\\(\\)]+\\){1})";
    public static String inlineFunctionRegex = "(?:[(]?"+numericalRegex+"[)]?)?"+InlineFunction.constructRegex()+"(?:\\([^\\(\\)]+\\){1})";
    public static String expressionRegex = "(?:" + numericalRegex + "|" + operandRegex + "|"+ inlineFunctionRegex +")";
    public static String specialCharRegex = InlineFunction.constructRegex()+"(?:\\({1}"+expressionRegex+"+\\){1})";
    public static String prependedFunctionRegex = "("+numericalRegex +")(?:"+ InlineFunction.constructRegex()+")"; 
    

    // Step 1: Allocate a Pattern object to compile a regexe
    public static Pattern numericalPattern = Pattern.compile(numericalRegex);
    public static Pattern precisionNumericalPattern = Pattern.compile(precisionNumericalRegex);
    public static Pattern operandPattern = Pattern.compile(operandRegex);
    public static Pattern specialCharPattern = Pattern.compile(specialCharRegex);
    public static Pattern inlineFunctionPattern = Pattern.compile(inlineFunctionRegex);
    public static Pattern prependedFunctionPattern = Pattern.compile(prependedFunctionRegex);


}
