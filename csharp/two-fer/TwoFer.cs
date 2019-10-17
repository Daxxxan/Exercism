using System;

namespace TwoFer
{
    public static class TwoFer
    {
        public static string Speak(string name = null)
        {
            return $"One for {name ?? "you"}, one for me.";
        }
    }
}
