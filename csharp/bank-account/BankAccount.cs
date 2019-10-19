using System;

public class BankAccount
{
    private decimal _balance;
    private bool _open;

    public BankAccount()
    {
        _open = true;
    }
    
    public void Open()
    {
        _balance = 0;
    }

    public void Close()
    {
        _open = false;
    }

    public decimal Balance
    {
        get
        {
            if (_open)
            {
                return _balance;   
            }
            else
            {
                throw new InvalidOperationException();
            }
        }
    }

    public void UpdateBalance(decimal change)
    {
        lock (this)
        {
            _balance = decimal.Add(_balance, change);
        }
    }
}
