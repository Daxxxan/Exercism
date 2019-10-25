using System;
using System.Collections.Generic;

namespace RobotName
{
    public class Robot
    {
        private HashSet<string> _generatedNames = new HashSet<string>();
        private string _name;

        public Robot()
        {
            _name = GenerateRobotName();
        }

        public string Name
        {
            get
            {
                return _name;
            }
        }

        public void Reset()
        {
            _name = GenerateRobotName();
        }
        
        private string GenerateRobotName()
        {
            string robotName;

            do
            {
                robotName = GenerateName();
            } while (!_generatedNames.Add(robotName));

            return robotName;
        }
    
        private string GenerateName()
        {
            string generatedRobotName = string.Empty;
        
            generatedRobotName += GenerateLetters(2);
            generatedRobotName += generateRandomNumber(100, 999);
        
            return generatedRobotName.ToUpper();
        }

        private string GenerateLetters(int numberLettersToGenerate)
        {
            string generatedLetters = string.Empty;
        
            for (int i = 0; i < numberLettersToGenerate; i++)
            {
                generatedLetters += (char) ('a' + generateRandomNumber(0, 25));
            }

            return generatedLetters;
        }

        private int generateRandomNumber(int from, int to)
        {
            Random random = new Random();
            return random.Next(from, to);
        }
    }
}