using System;
using System.Collections.Generic;
using System.Linq;

public class CircularBuffer<T>
{
    private int _capacity;
    private List<T> _buffer;
    
    public CircularBuffer(int capacity)
    {
        _capacity = capacity;
        _buffer = new List<T>(capacity);
    }

    public T Read()
    {
        if (_buffer.Count == 0)
        {
            throw new InvalidOperationException();
        }

        var result = _buffer[0];
        _buffer = _buffer.Skip(1).ToList();
        return result;
    }

    public void Write(T value)
    {
        if (_buffer.Count >= _capacity)
        {
            throw new InvalidOperationException();
        }
        
        _buffer.Add(value);
    }

    public void Overwrite(T value)
    {
        if (_buffer.Count >= _capacity)
        {
            _buffer = _buffer.Skip(1).ToList();
        }
        
        Write(value);
    }

    public void Clear()
    {
        _buffer.Clear();
    }
}