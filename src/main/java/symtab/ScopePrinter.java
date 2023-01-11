package symtab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import symtab.scope.Scope;
import symtab.symbol.Symbol;

public class ScopePrinter {
    private Scope scope;
    private ArrayList<Integer> cellsSizes = new ArrayList<Integer>();
    private ArrayList<ArrayList<String>> printTable = new ArrayList<ArrayList<String>>();
    private HashMap<String, String> colorSybolCat = new HashMap<String, String>();

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
        if (cellsSizes.size() > 0) {
            colorSybolCat.put("VAR", "\033[32m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "VAR") + "\033[0m");
            colorSybolCat.put("TYPE", "\033[34m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "TYPE") + "\033[0m");
            colorSybolCat.put("FUNC", "\033[95m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "FUNC") + "\033[0m");
        }

        this.printScope();
    }

    public void printBottomTable() {
        System.out.print("┗━");
        for (int i = 0; i < cellsSizes.size() - 1; i++) {
            System.out.print("━".repeat(cellsSizes.get(i) + 1) + "┻━");
        }
        System.out.print("━".repeat(cellsSizes.get(cellsSizes.size() - 1) + 1) + "┛\n");
    }

    public void printTopTable() {
        System.out.print("┏━");
        for (int i = 0; i < cellsSizes.size() - 1; i++) {
            System.out.print("━".repeat(cellsSizes.get(i) + 1) + "┳━");
        }
        System.out.print("━".repeat(cellsSizes.get(cellsSizes.size() - 1) + 1) + "┓\n");
    }

    public void printScope() {
        System.out.println("\nScope ID : " + this.scope.getScopeId());
        System.out.println("Parent ID : " + this.scope.getParentScope());
        System.out.println("Imbrication Level : " + this.scope.getImbricationLevel());

        if (this.scope.getSymbols().size() > 0) {

            printTopTable();

            for (ArrayList<String> line : this.printTable) {
                System.out.print("┃ " + String.format("%-" + (cellsSizes.get(0) + 1) + "s",
                        this.colorSybolCat.get(line.get(0))) + "┃ ");
                for (int i = 1; i < line.size(); i++) {
                    System.out
                            .print(String.format("%-" + (cellsSizes.get(i) + 1) + "s", line.get(i))
                                    + "┃ ");
                }

                System.out.println();
            }
            printBottomTable();
        }


    }

}
