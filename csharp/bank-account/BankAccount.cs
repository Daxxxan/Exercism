using System;

public class BankAccount
{
    private decimal _balance;
    private bool _open;

    public void Open()
    {
        lock (this)
        {
            _open = true;   
        }
    }

    public void Close()
    {
        lock (this)
        { 
            _open = false;   
        }
    }

    public decimal Balance
    {
        get
        {
            lock (this)
            {
                if (!_open)
                {
                    throw new InvalidOperationException();
                
                }
                return _balance;      
            }
        }
    }

    public void UpdateBalance(decimal change)
    {
        lock (this)
        {
            if (!_open)
            {
                throw new InvalidOperationException();
            }
            _balance = decimal.Add(_balance, change);
        }
    }
}
