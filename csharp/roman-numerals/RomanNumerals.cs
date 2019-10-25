using System;
using System.Collections.Generic;
using System.Linq;

namespace RomanNumerals
{
    public static class RomanNumeralExtension
    {
        private static Dictionary<int, string> _romanNumbers = new Dictionary<int, string>()
        {
            {1000, "M"},
            {900, "CM"},
            {500, "D"},
            {400, "CD"},
            {100, "C"},
            {90, "XC"},
            {50, "L"},
            {40, "XL"},
            {10, "X"},
            {9, "IX"},
            {5, "V"},
            {4, "IV"},
            {1, "I"}
        };
        
        public static string ToRoman(this int value)
        {
            string result = string.Empty;
            
            while (value > 0)
            {
                foreach (var (decimalNumber, romanNumber) in _romanNumbers)
                {
                    if (value - decimalNumber >= 0)
                    {
                        result += romanNumber;
                        value -= decimalNumber;
                        break;
                    }
                }
            }

            return result;
        }
    }
}