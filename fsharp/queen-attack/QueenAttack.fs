module QueenAttack

let create (x, y) =
    let queenAxesWithinRange position = position > 0 && position < 8
    queenAxesWithinRange x && queenAxesWithinRange y

let canAttack (blackQueen: int * int) (whiteQueen: int * int) : bool =
    let firstRow, firstColumn = blackQueen
    let secondRow, secondColumn = whiteQueen
    firstRow = secondRow || firstColumn = secondColumn || abs(firstRow - secondRow) = abs (firstColumn - secondColumn)