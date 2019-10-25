using System.Collections.Generic;
using System.Linq;

namespace GradeSchool
{
    public class GradeSchool
    {
        private Dictionary<string, int> _grades = new Dictionary<string, int>();
    
        public void Add(string student, int grade)
        {
            _grades.Add(student, grade);
        }

        public IEnumerable<string> Roster()
        {
            return new Dictionary<string, int>(_grades.OrderBy(grades => grades.Value).ThenBy(grades => grades.Key)).Keys;
        }

        public IEnumerable<string> Grade(int grade)
        {
            List<string> gotByGrade = new List<string>();
        
            foreach (var grd in _grades)
            {
                if (grd.Value.Equals(grade))
                {
                    gotByGrade.Add(grd.Key);
                }
            }

            return gotByGrade.OrderBy(name => name);
        }
    }
}