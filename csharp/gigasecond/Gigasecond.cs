using System;

namespace Gigasecond
{
    public static class Gigasecond
    {
        public static DateTime Add(DateTime moment) => moment.AddSeconds(1E9);
    }
}