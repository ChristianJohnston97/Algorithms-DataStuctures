import java.util.*;
public class DecimalToBinary
{
	public static void main(String[] args)
	{
		int decimal = 23;
		toBinaryUsingStack(decimal);
	}

	public static void toBinary(int number)
	{
		int binary[] = new int[25];
        int index = 0;

        while(number > 0)
        {
        	int remainder = number % 2;
        	number = number / 2;
        	binary[index] = remainder;
        	index++;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
        System.out.print("\n");
	}

    // uses a stack 
    // better version
    public static void toBinaryUsingStack(int number)
    {
        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder binary = new StringBuilder();

        while(number != 0)
        {
            stack.push(number%2);
            number = number/2;
        }

        while(!stack.isEmpty())
        {
            binary.append(stack.pop());
        }
        System.out.println(binary.toString());
    }
}