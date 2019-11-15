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
        if (BufferIsEmpty())
        {
            throw new InvalidOperationException();
        }

        var result = _buffer[0];
        Dequeue();
        return result;
    }

    private bool BufferIsEmpty()
    {
        return _buffer.Count == 0;
    }

    public void Write(T value)
    {
        if (BufferIsFull())
        {
            throw new InvalidOperationException();
        }
        
        _buffer.Add(value);
    }

    public void Overwrite(T value)
    {
        if (BufferIsFull())
        {
            Dequeue();
        }
        
        Write(value);
    }

    private bool BufferIsFull()
    {
        return _buffer.Count >= _capacity;
    }

    private void Dequeue()
    {
        _buffer = _buffer.Skip(1).ToList();
    }

    public void Clear()
    {
        _buffer.Clear();
    }
}