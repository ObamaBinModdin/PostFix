/**
 * Project: Project5
 * Completion Time: 3.5 hours
 * 
 * Honor Code: “I pledge that I have neither given nor received help from anyone
 * other than the instructor or the TAs for all program components included here.”
 */

package project5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) throws IOException, Exception 
    {
        Main main=new Main();
        main.run(new File("expression.txt"));
    }//Main method
    
    protected ArrayList<ArrayList> readFile(File file) throws FileNotFoundException
    {
        Scanner scanner=new Scanner(file);
        ArrayList<ArrayList> expressions=new ArrayList<ArrayList>();
        
        while(scanner.hasNextLine())
        {
            ArrayList<String> expression=new ArrayList<String>();
            
            String[] stringConvertor=scanner.nextLine().split(" ");
            int arraySize=stringConvertor.length;
            
            for(int x=0;x<arraySize;x++)
            {
                expression.add(stringConvertor[x]);
            }
            
            expressions.add(expression);
        }
        
        return expressions;
    }//readFile() method. takes in a file and returns an ArrayList of ArrayList<String>
    
    protected void toDeque(ArrayList<String> expressions) throws Exception
    {
        ArrayDeque<Object> postfixDeque=new ArrayDeque<Object>();
        int arraySize=expressions.size();
        
        for(int x=0;x<arraySize;x++)
        {
            try
            {
                double input=Double.parseDouble(expressions.get(x));
                postfixDeque.push(input);
                System.out.print((int)input + " ");
            }
            catch(NumberFormatException e)
            {
                if(postfixDeque.size()<2)
                {
                    throw new Exception("\nToo many operators!");
                }
                
                double valueOne =(Double)postfixDeque.pop();
                double valueTwo =(Double)postfixDeque.pop();
                
                switch(expressions.get(x))
                {  
                    case "+":
                        postfixDeque.push(valueTwo+valueOne);
                        System.out.print("+ ");
                        break;
                    case "-":
                        postfixDeque.push(valueTwo-valueOne);
                        System.out.print("- ");
                        break;
                    case "*":
                        postfixDeque.push(valueTwo*valueOne);
                        System.out.print("* ");
                        break;
                    case "/":
                        if(valueOne==0)
                        {
                            throw new ArithmeticException("\nCannot divide by 0");
                        }
                        postfixDeque.push(valueTwo/valueOne);
                        System.out.print("/ ");
                        break;
                }
            }   
        }
        
        if(postfixDeque.size()>1)
        {
            throw new Exception("\nToo many operands!");
        }
        
        double returnVal=(Double)postfixDeque.pop();
        postfixDeque.clear();
        
        System.out.println("= "+returnVal);
    }//toDeque() method. Takes in an ArrayList of Strings. Void return. Prints out the input expressions to postfix with an output.
    
    public void run(File file) throws FileNotFoundException, Exception
    {
        ArrayList<ArrayList> expressionLines=readFile(file);
        int arraySize=expressionLines.size();
        
        for(int x=0;x<arraySize;x++)
        {
            toDeque(expressionLines.get(x));
        }
    }//run() method. Takes in a file. Uses readFile() and toDeque(). Clears clutter and redundancy from Main().
}//Main class
