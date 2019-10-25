using System;
using System.Collections.Generic;

public static class NucleotideCount
{
    private static Dictionary<char, int> _nucleotide;
    
    public static IDictionary<char, int> Count(string sequence)
    {
        InitNucleotide();

        foreach (char sequenceChar in sequence)
        {
            if (!_nucleotide.ContainsKey(sequenceChar))
            {
                throw new ArgumentException();
            }
            
            _nucleotide[sequenceChar]++;
        }
        return _nucleotide;
    }

    private static void InitNucleotide()
    {
        _nucleotide = new Dictionary<char, int>()
        {
            ['A'] = 0,
            ['C'] = 0,
            ['G'] = 0,
            ['T'] = 0
        };
    }
}