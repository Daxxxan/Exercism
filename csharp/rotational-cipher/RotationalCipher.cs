using System;
using System.Linq;
using System.Security.Cryptography;

public static class RotationalCipher
{
    public static string Rotate(string text, int shiftKey)
    {
        string result = string.Empty;
        
        foreach (char letter in text)
        {
            result += Cipher(letter, shiftKey);
        }

        return result;
    }

    private static char Cipher(char letter, int shiftKey)
    {
        if (!char.IsLetter(letter))
        {
            return letter;
        }

        char letterReferenceFrame = char.IsUpper(letter) ? 'A' : 'a';
        return (char) ((((letter - letterReferenceFrame) + shiftKey) % 26) + letterReferenceFrame);
    }
}