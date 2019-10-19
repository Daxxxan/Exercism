using System;
using System.Linq;
using System.Security.Cryptography;

public class RotationalCipher
{
    private string _text;
    private int _shiftKey;

    public RotationalCipher(string text, int shiftKey)
    {
        this._text = text;
        this._shiftKey = shiftKey;
    }
    
    public string Rotate()
    {
        string result = string.Empty;
        
        foreach (char letter in _text)
        {
            result += Cipher(letter);
        }

        return result;
    }

    private char Cipher(char letter)
    {
        if (!char.IsLetter(letter))
        {
            return letter;
        }
        
        return ShiftLetter(letter);
    }

    private char ShiftLetter(char letter)
    {
        char letterReferenceFrame = LetterReferenceFrame(letter);
        return (char) ((((letter - letterReferenceFrame) + _shiftKey) % 26) + letterReferenceFrame);
    }

    private char LetterReferenceFrame(char letter)
    {
        return char.IsUpper(letter) ? 'A' : 'a';
    }
}