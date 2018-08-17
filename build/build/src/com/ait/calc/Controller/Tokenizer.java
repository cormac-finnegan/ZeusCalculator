package com.ait.calc.Controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ait.calc.Model.CmacToken;
import com.ait.calc.Model.Token;

/**
 * Created by C.I.T on 24-Sep-17.
 */
public class Tokenizer{

    private ArrayList<Token> tokenArrayList = new ArrayList<>();
    public static String abstractRegex = "("+CmacToken.numericalRegex+"|"+CmacToken.operandRegex+")";
    Pattern numericalPattern = Pattern.compile(abstractRegex);

    public Tokenizer(String input){
        Matcher absMatcher = numericalPattern.matcher(input);

        while(absMatcher.find()){
            String s = null;
            try{
                s = absMatcher.group(0);
            }catch (IllegalStateException ils){

            }
            tokenArrayList.add(tokenize(s));
        }
    }

    public Token tokenize(String value){
        Matcher numMatcher = CmacToken.numericalPattern.matcher(value);
        Matcher opMatcher = CmacToken.operandPattern.matcher(value);

        if(numMatcher.find()){
            return Token.stringToToken(numMatcher.group(0));
        }else if(opMatcher.find()){
            return Token.stringToToken(opMatcher.group(0));
        }
        return null;
    }


    public ArrayList<Token> getTokenArrayList() {
        return tokenArrayList;
    }


    public Stack<CmacToken> toStack(ArrayList<CmacToken> arrayList){
        Stack<CmacToken> stack = new Stack<>();
        for(CmacToken t : arrayList){
            stack.add(t);
        }
        return stack;
    }

    public Queue<CmacToken> toQueue(ArrayList<CmacToken> arrayList){
        Queue<CmacToken> queue = new LinkedList<CmacToken>();
        for(CmacToken t : arrayList){
            queue.add(t);
        }
        return queue;
    }

}
