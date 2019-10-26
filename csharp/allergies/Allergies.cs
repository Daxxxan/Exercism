using System;
using System.Linq;

public enum Allergen
{
    Eggs = 1,
    Peanuts = 2,
    Shellfish = 4,
    Strawberries = 8,
    Tomatoes = 16,
    Chocolate = 32,
    Pollen = 64,
    Cats = 128
}

public class Allergies
{
    private int _allergy;
    
    public Allergies(int mask)
    {
        _allergy = mask;
    }

    public bool IsAllergicTo(Allergen allergen)
    {
        return (_allergy & (int)allergen) > 0;
    }

    public Allergen[] List()
    {
        return Enum.GetValues(typeof(Allergen))
            .Cast<Allergen>()
            .Where(allergen => (_allergy & (int)allergen) > 0)
            .ToArray();
    }
}