module Accumulate

let accumulate func inputList =
    [for value in inputList -> func value]
