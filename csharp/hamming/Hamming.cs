using System;
using System.Linq;

namespace Hamming
{
    public static class Hamming
    {
        public static int Distance(string firstStrand, string secondStrand)
        {
            int counter = 0;
            
            if (firstStrand.Length != secondStrand.Length)
            {
                throw new ArgumentException();
            }


            for (int i = 0; i < firstStrand.Length; i++)
            {
                if (firstStrand[i] != secondStrand[i])
                {
                    counter++;
                }
            }

            return counter;
        }
    }
}