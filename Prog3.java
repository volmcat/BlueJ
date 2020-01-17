import java.util.*;
/**
 * This program reads in two strings, perferably of roman numerals, and prints out those strings as an integer value.
 * It then reads in an operation and performs that operation with the two numbers entered.
 * After performing the operation it prints out the new number as an integer and as a roman numberal.
 * 
 * @author (Brice Vollmer) 
 * @version (11/9/2015)
 */
public class Prog3
{
   private static final int BAD_VAL = -1;
   private static final int M_VAL = 1000;
   private static final int D_VAL = 500;
   private static final int C_VAL = 100;
   private static final int L_VAL = 50;
   private static final int X_VAL = 10;
   private static final int V_VAL = 5;
   private static final int I_VAL = 1;

   public static void main(String args[])
   {
      Scanner stdin = new Scanner(System.in);
      String operand1Str, operand2Str, opStr;                    
      int operand1, operand2;              
      while(stdin.hasNext())
      {
          operand1Str = stdin.next();
          operand1 = getRomanNumeral(operand1Str);
          while(operand1 == BAD_VAL)
          {      
              System.out.println("Not a Roman Numeral. Please enter a valid Roman Numeral.");
              operand1Str = stdin.next(); 
          }
          System.out.println("The first number is " + operand1);
          operand2Str =  stdin.next();
          operand2 = getRomanNumeral(operand2Str);
          while(operand2 == BAD_VAL)
          {
              System.out.println("Not a Roman Numeral. Please enter a valid Roman Numeral.");
              operand2Str = stdin.next();
          }
          System.out.println("The second number is " + operand2);
          opStr = stdin.next();
          System.out.println("Arithmetic operation is " + opStr);
          printResult(operand1, operand2, opStr.charAt(0));
          System.out.println();
      }
      System.out.println("Done. Normal termination.");
   }
    
    /*
    * This method performs the operation that is given with the two numbers that are used. 
    * @param operand1   First number as an integer
    * @param operand2   Second number as an integer
    * @param operation  Operation to be performed as a character
    * @return           The new number after the operation has been completed.
    */
    public static int performOperation(int operand1, int operand2, char operation)
    {
        if(operand2 == 0)
            return 0;
        if(operation == '+')
            return operand1 + operand2;
        else if(operation == '-')
            return operand1 - operand2;
        else if(operation == '*')
            return operand1 * operand2;
        else if(operation == '/')
            return operand1 / operand2;
        else 
            return BAD_VAL;    
    }
    
    /*
    * This method prints out the operation that was performed along with the new value as in integer and newly built Rman numeral.
    * @param operand1   First number entered as an integer
    * @param operand2   Second number entered as an integer
    * @param operation  operation that was entered to be perform
    */
    public static void printResult(int operand1, int operand2, char operation)
    {
        int value = performOperation(operand1, operand2, operation);
        if(operation == '-')
            System.out.println("The difference of " + operand1 + " and " + operand2 + " is " + buildRomanNumeral(value) + " (" + value + ")");
        else if(operation == '+')
            System.out.println("The sum of " + operand1 + " and " + operand2 + " is " + buildRomanNumeral(value) + " (" + value + ")");    
        else if(operation == '*')
            System.out.println("The product of " + operand1 + " and " + operand2 + " is " + buildRomanNumeral(value) + " (" + value + ")");
        else if(operation == '/')
            System.out.println("The quotient of " + operand1 + " and " + operand2 + " is " + buildRomanNumeral(value) + " (" + value + ")");
    }
    
    /*
    * This method returns a newly built roman numeral after taking in an integer.
    * @param val   Value calculated after the operation was performed. (The new number)
    * @return      Returns the newly built roman numeral.
    */
    public static String buildRomanNumeral(int val)
    {
        String romanNumeral = "";
        if(val < 0)
        {
            romanNumeral += "-";
            val = Math.abs(val);
        }      
        if(val == 0)
            return "zero";
        int mValue = val / M_VAL;
        val = val % M_VAL;
        for(int i = 0; i < mValue; i++)
            romanNumeral += "M";
        for(;val >= D_VAL; val -= D_VAL)
            romanNumeral += "D";    
        int cValue = val / C_VAL;
        val = val % C_VAL;
        for(int i = 0; i < cValue; i++)
            romanNumeral += "C";
        for(;val >= L_VAL; val -= L_VAL)
            romanNumeral += "L";    
        int xValue = val / X_VAL;
        val = val % X_VAL;
        for(int i = 0; i < xValue; i++)
            romanNumeral += "X";
        for(;val >= V_VAL; val -= V_VAL)
            romanNumeral += "V";
        int iValue = val / I_VAL;
        for(int i = 0; i < iValue; i++)
            romanNumeral += "I";
        return romanNumeral;  
    }
    
    /*
    * This method takes in a value and returns the roman digit that is equal to it
    * @param val  a value
    * @return     the roman digit that equals that value
    */
    public static char romanDigitChar(int val)
    {
      if(val == I_VAL)
          return 'I';
      else if(val == V_VAL)
          return 'V';
      else if(val == X_VAL)
          return 'X'; 
      else if(val == L_VAL)
          return 'L';
      else if(val == C_VAL)
          return 'C';
      else if(val == D_VAL)
          return 'D'; 
      else if(val == M_VAL)
          return 'M';   
      else 
          return ' ';    
    }
    
    /*
    * This method reads in a roman digit and returns the value of that digit. if it is not a valid roman numeral it rejects it
    * @param roman_digit  the roman digit in question
    * @return value of character is valid otherwise return bad value.            ?
    */
    public static int romanDigitValue(char roman_digit)
    {
        String roman_digitString = roman_digit + "";
        String roman_digitUpper = roman_digitString.toUpperCase();
        if(roman_digitUpper.equals("I"))
            return I_VAL;
        else if(roman_digitUpper.equals("V"))
            return V_VAL;  
        else if(roman_digitUpper.equals("X"))
            return X_VAL;
        else if(roman_digitUpper.equals("L"))
            return L_VAL;
        else if(roman_digitUpper.equals("C"))
            return C_VAL;
        else if(roman_digitUpper.equals("D"))
            return D_VAL;
        else if(roman_digitUpper.equals("M"))
            return M_VAL;    
        else 
            return BAD_VAL;
    }
    
    /*
    * This method takes the string the user entered and validates it while creating the value of that string and returns it as an integer
    * @param The input the user has typed in as a string
    * @return The value of that string as a integer
    */
    static int getRomanNumeral(String input)
    {
      int i = 0, value = 0;
      while(i < input.length())
      {      
          value += romanDigitValue(input.charAt(i));
          i++;
      }
      return value;
    }
}
