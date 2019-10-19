// This file was auto-generated based on version 2.3.0 of the canonical data.

using System;
using Xunit;

namespace Hamming
{
    public class HammingTest
    {
        [Fact]
        public void Empty_strands()
        {
            Assert.Equal(0, global::Hamming.Hamming.Distance("", ""));
        }

        [Fact]
        public void Single_letter_identical_strands()
        {
            Assert.Equal(0, global::Hamming.Hamming.Distance("A", "A"));
        }

        [Fact]
        public void Single_letter_different_strands()
        {
            Assert.Equal(1, global::Hamming.Hamming.Distance("G", "T"));
        }

        [Fact]
        public void Long_identical_strands()
        {
            Assert.Equal(0, global::Hamming.Hamming.Distance("GGACTGAAATCTG", "GGACTGAAATCTG"));
        }

        [Fact]
        public void Long_different_strands()
        {
            Assert.Equal(9, global::Hamming.Hamming.Distance("GGACGGATTCTG", "AGGACGGATTCT"));
        }

        [Fact]
        public void Disallow_first_strand_longer()
        {
            Assert.Throws<ArgumentException>(() => global::Hamming.Hamming.Distance("AATG", "AAA"));
        }

        [Fact]
        public void Disallow_second_strand_longer()
        {
            Assert.Throws<ArgumentException>(() => global::Hamming.Hamming.Distance("ATA", "AGTG"));
        }

        [Fact]
        public void Disallow_left_empty_strand()
        {
            Assert.Throws<ArgumentException>(() => global::Hamming.Hamming.Distance("", "G"));
        }

        [Fact]
        public void Disallow_right_empty_strand()
        {
            Assert.Throws<ArgumentException>(() => global::Hamming.Hamming.Distance("G", ""));
        }
    }
}