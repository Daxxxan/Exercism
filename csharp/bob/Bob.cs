using System;

public static class Bob
{
    public static string Response(string statement)
    {
        if (StatementIsEmpty(statement.Trim()))
        {
            return "Fine. Be that way!";
        }
        
        if (StatementIsAQuestion(statement.Trim()) && StatementIsUppercase(statement))
        {
            return "Calm down, I know what I'm doing!";
        }
        
        if (StatementIsAQuestion(statement.Trim()))
        {
            return "Sure.";
        }

        if (StatementIsUppercase(statement))
        {
            return "Whoa, chill out!";
        }

        return "Whatever.";
    }

    private static bool StatementIsEmpty(string statement)
    {
        return statement.Length == 0;
    }

    private static bool StatementIsAQuestion(string statement)
    {
        return statement[statement.Length - 1].Equals('?');
    }

    private static bool StatementIsUppercase(string statement)
    {
        int counter = 0;
        
        foreach (var letter in statement)
        {
            if (char.IsLetter(letter) && !char.IsUpper(letter))
            {
                return false;
            }

            if (!char.IsLetter(letter))
            {
                counter++;   
            }
        }

        return counter != statement.Length;
    }
}