package com.ait.calc.Init;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ait.calc.Controller.Tokenizer;
import com.ait.calc.Model.CmacToken;
import com.ait.calc.Model.Token;

/**
 * Created by C.I.T on 24-Sep-17.
 */
public class Init {

    public static void main(String[] args){


        // Input for matching the regexe pattern
        String input = "239+(3.09*(01.08-4))";
        //String input = "1+2*3/4";
        //String input = "50*6-3";

        Tokenizer tokenizer = new Tokenizer(input);

        ArrayList<Token> tokenArrayList = tokenizer.getTokenArrayList();
        for(Token t : tokenArrayList)
        	System.out.println(t.toString());



    }

}


