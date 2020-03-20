import java.util.ArrayList;
import java.util.List;

class MinesweeperBoard {
    List<String> board;

    public MinesweeperBoard(List<String> board) {
        this.board = board;
    }

    public List<String> withNumbers() {
        ArrayList<String> newBoard = new ArrayList<>(board);

        for(int row = 0; row < newBoard.size(); row++) {
           for(int characterPosition = 0; characterPosition < newBoard.get(row).length(); characterPosition++) {
               if(isMine(newBoard, row, characterPosition)) {
                   int firstRowToModify = getFirstRowToModify(row);
                   int lastRowToModify = getLastRowToModify(newBoard, row);
                   int firstCharacterToModify = getFirstCharacterToModify(characterPosition);
                   int lastCharacterToModify = getLastCharacterToModify(newBoard, firstRowToModify, characterPosition);

                   modifyNeighborsCells(newBoard, firstRowToModify, lastRowToModify, firstCharacterToModify, lastCharacterToModify);
               }
           }
        }
        return newBoard;
    }

    private void modifyNeighborsCells(ArrayList<String> board, int rowToModify, int lastRowToModify, int firstCharacterToModify, int lastCharacterToModify) {
        for(; rowToModify <= lastRowToModify; rowToModify++) {
            for(int characterToModify = firstCharacterToModify; characterToModify <= lastCharacterToModify; characterToModify++) {
                if(!isMine(board, rowToModify, characterToModify)) {
                    modifyCell(board, rowToModify, characterToModify);
                }
            }
        }
    }

    private void modifyCell(ArrayList<String> board, int rowToModify, int characterToModify) {
        char newCellValue = modifyCellValue(board, rowToModify, characterToModify);
        affectNewCellToTheRow(board, rowToModify, characterToModify, newCellValue);
    }

    private char modifyCellValue(ArrayList<String> board, int rowToModify, int characterToModify) {
        char newChar = board.get(rowToModify).charAt(characterToModify);

        if(newChar != ' ') {
            newChar = String.valueOf(Integer.parseInt(String.valueOf(newChar)) + 1).charAt(0);
        } else {
            newChar = '1';
        }
        return newChar;
    }

    private void affectNewCellToTheRow(ArrayList<String> board, int rowToModify, int characterToModify, char newCellValue) {
        StringBuilder newRow = new StringBuilder(board.get(rowToModify));
        newRow.setCharAt(characterToModify, newCellValue);
        board.set(rowToModify, newRow.toString());
    }

    private int getLastCharacterToModify(ArrayList<String> board, int firstRowToModify, int characterPosition) {
        if(characterPosition != board.get(firstRowToModify).length() - 1) {
            characterPosition += 1;
        }
        return characterPosition;
    }

    private int getFirstCharacterToModify(int characterPosition) {
        if(characterPosition > 0) {
            characterPosition -= 1;
        }
        return characterPosition;
    }

    private int getLastRowToModify(ArrayList<String> board, int row) {
        if (board.size() - 1 != row) {
             row += 1;
        }
        return row;
    }

    private int getFirstRowToModify(int row) {
        if(row > 0) {
            return row - 1;
        }
        return 0;
    }

    private boolean isMine(ArrayList<String> board, int row, int characterPosition) {
        return board.get(row).charAt(characterPosition) == '*';
    }
}
