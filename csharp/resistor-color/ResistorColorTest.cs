// This file was auto-generated based on version 1.0.0 of the canonical data.

using Xunit;

namespace ResistorColor
{
    public class ResistorColorTest
    {
        [Fact]
        public void Black()
        {
            Assert.Equal(0, global::ResistorColor.ResistorColor.ColorCode("black"));
        }

        [Fact]
        public void White()
        {
            Assert.Equal(9, global::ResistorColor.ResistorColor.ColorCode("white"));
        }

        [Fact]
        public void Orange()
        {
            Assert.Equal(3, global::ResistorColor.ResistorColor.ColorCode("orange"));
        }

        [Fact]
        public void Colors()
        {
            Assert.Equal(new[] { "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white" }, global::ResistorColor.ResistorColor.Colors());
        }
    }
}