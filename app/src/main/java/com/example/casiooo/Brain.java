package com.example.casiooo;

import static android.content.ContentValues.TAG;

import android.util.Log;

import java.text.BreakIterator;
import java.util.Scanner;
import java.util.Stack;

public class Brain {
    private static Scanner sc = new Scanner(System.in);
    public int check(char c)
    {
        if(c == '(' || c == ')') return 0;
        if(c == 'x' || c == '/') return 2;
        if(c == '+' || c == '-') return 1;
        return 3;
    }
    public String convert(String s)
    {
        Stack<Character> stk = new Stack<>();
        String res = "";
        for(int i = 0; i <= s.length()-1; i++)
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.')
            {
                if(i < s.length() - 1) {
                    if (!((s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') || s.charAt(i+1) == '.')) res = res + s.charAt(i) + " ";
                    else res = res + s.charAt(i);
                }
                else {
                    res = res + s.charAt(i) + " ";
                }
            }
            else if(s.charAt(i) == '(') stk.push(s.charAt(i));
            else if(s.charAt(i) == ')')
            {
                while(stk.peek() != '(' && stk.size() > 0)
                {
                    res = res + stk.peek() + " ";
                    stk.pop();
                }
                stk.pop();
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '/' || s.charAt(i) == 'x' || s.charAt(i) == '-')
            {
                while(stk.size() > 0 && (check(stk.peek()) >= check(s.charAt(i))))
                {
                    res = res + stk.peek() + " ";
                    stk.pop();
                }
                stk.push(s.charAt(i));
            }
        while(stk.size() > 0)
        {
            if(stk.peek() != '(') res = res + stk.peek();
            stk.pop();
        }
        return res;
    }
    public float Solve(String s)
    {
        s = convert(s);
        ///System.out.println(conver(s));
        String x = "";
        Stack<Float> st = new Stack<>();
        for(int i = 0; i <= s.length()-1; i++)
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '.')
            {
                x = x + s.charAt(i);
            }
            else if(s.charAt(i) == ' ' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')
            {
                st.push(Float.parseFloat(x));
                x = "";
            }
            else if((s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == 'x') && st.size() > 1)
            {
                float b = st.peek();
                st.pop();
                float a = st.peek();
                st.pop();
                float tmp = 0;
                if (s.charAt(i) == '+') tmp = a + b;
                if (s.charAt(i) == '-') tmp = a - b;
                if (s.charAt(i) == 'x') tmp = a * b;
                if (s.charAt(i) == '/') tmp = a / b;
                st.push(tmp);
            }
        if(st.size() == 0) return 0;
        else {
            //return Float.parseFloat(String.format("%.6g%n", st.peek()));
            return st.peek();
        }
    }
}
