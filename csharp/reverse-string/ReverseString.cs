using System;
using System.Linq;

public static class ReverseString
{
    public static string Reverse(string input)
    {
        char[] result = input.ToCharArray();
        Array.Reverse(result);
        return new string(result);
    }
}