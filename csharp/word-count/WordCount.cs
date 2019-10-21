using System;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public static class WordCount
{
    public static IDictionary<string, int> CountWords(string phrase)
    {
        var words = new Dictionary<string, int>();
        var matches = Regex.Matches(phrase.ToLower(), @"\w+[^\s|,]*\w+|\w");

        foreach (Match match in matches)
        {
            if (!words.TryAdd(match.Value, 1))
            {
                words[match.Value]++;
            }
        }
        return words;
    }
}