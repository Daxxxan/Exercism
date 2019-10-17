using System.Collections.Generic;
using System.Linq;

namespace HighScores
{
    public class HighScores
    {
        private List<int> _scores;
        
        public HighScores(List<int> scores)
        {
            _scores = scores;
        }

        public List<int> Scores()
        {
            return _scores;
        }

        public int Latest()
        {
            return _scores.Last();
        }

        public int PersonalBest()
        {
            return _scores.Max();
        }

        public List<int> PersonalTopThree()
        {
            while (_scores.Count > 3)
            {
                _scores.Remove(_scores.Min());
            }

            return _scores.OrderByDescending(score => score).ToList();
        }
    }
}