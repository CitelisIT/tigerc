package symtab;

import java.util.ArrayList;
import symtab.scope.Scope;
import symtab.symbol.Symbol;

public class ScopePrinter {
    private Scope scope;
    private ArrayList<Integer> cellsSizes = new ArrayList<Integer>();
    private ArrayList<ArrayList<String>> printTable = new ArrayList<ArrayList<String>>();

    public ScopePrinter(Scope scope) {
        this.scope = scope;
        for (String key : scope.getSymbols().keySet()) {
            Symbol symbol = scope.getSymbol(key);
            ArrayList<String> line = symbol.getSymtabLine();
            printTable.add(line);
            for (int index = 0; index < line.size(); index++) {
                if (cellsSizes.size() <= index) {
                    cellsSizes.add(line.get(index).length());
                } else {
                    cellsSizes.set(index,
                            Math.max(cellsSizes.get(index), line.get(index).length()));
                }
            }


        }
        this.printScope();
    }

    public void printScope() {
        System.out.println("\nScope ID : " + this.scope.getScopeId());
        System.out.println("Parent ID : " + this.scope.getParentScope());
        System.out.println("Imbrication Level : " + this.scope.getImbricationLevel());

        for (ArrayList<String> line : this.printTable) {
            for (int i = 0; i < line.size(); i++) {
                System.out.print(
                        String.format("%-" + (cellsSizes.get(i) + 1) + "s", line.get(i)) + "┃ ");
            }

            System.out.println();
        }
    }

}
