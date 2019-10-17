using System.Collections.Generic;
using System.Linq;

namespace HighScores
{
    public class HighScores
    {
        private List<int> _scores;
        
        public HighScores(List<int> scores) => _scores = scores;

        public List<int> Scores() => _scores;

        public int Latest() => _scores.Last();

        public int PersonalBest() => _scores.Max();

        public List<int> PersonalTopThree() => 
            _scores
                .OrderByDescending(score => score)
                .Take(3)
                .ToList();
    }
}