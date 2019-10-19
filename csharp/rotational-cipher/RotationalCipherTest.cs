// This file was auto-generated based on version 1.2.0 of the canonical data.

using Xunit;

public class RotationalCipherTest
{
    [Fact]
    public void Rotate_a_by_0_same_output_as_input()
    {
        Assert.Equal("a", new RotationalCipher("a", 0).Rotate());
    }

    [Fact]
    public void Rotate_a_by_1()
    {
        Assert.Equal("b", new RotationalCipher("a", 1).Rotate());
    }

    [Fact]
    public void Rotate_a_by_26_same_output_as_input()
    {
        Assert.Equal("a", new RotationalCipher("a", 26).Rotate());
    }

    [Fact]
    public void Rotate_m_by_13()
    {
        Assert.Equal("z", new RotationalCipher("m", 13).Rotate());
    }

    [Fact]
    public void Rotate_n_by_13_with_wrap_around_alphabet()
    {
        Assert.Equal("a", new RotationalCipher("n", 13).Rotate());
    }

    [Fact]
    public void Rotate_capital_letters()
    {
        Assert.Equal("TRL", new RotationalCipher("OMG", 5).Rotate());
    }

    [Fact]
    public void Rotate_spaces()
    {
        Assert.Equal("T R L", new RotationalCipher("O M G", 5).Rotate());
    }

    [Fact]
    public void Rotate_numbers()
    {
        Assert.Equal("Xiwxmrk 1 2 3 xiwxmrk", new RotationalCipher("Testing 1 2 3 testing", 4).Rotate());
    }

    [Fact]
    public void Rotate_punctuation()
    {
        Assert.Equal("Gzo'n zvo, Bmviyhv!", new RotationalCipher("Let's eat, Grandma!", 21).Rotate());
    }

    [Fact]
    public void Rotate_all_letters()
    {
        Assert.Equal("Gur dhvpx oebja sbk whzcf bire gur ynml qbt.", new RotationalCipher("The quick brown fox jumps over the lazy dog.", 13).Rotate());
    }
}