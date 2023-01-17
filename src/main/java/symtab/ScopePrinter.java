package symtab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import symtab.scope.Scope;
import symtab.symbol.Symbol;

public class ScopePrinter {
    private Scope scope;
    private ArrayList<Integer> cellsSizes = new ArrayList<Integer>();
    private ArrayList<ArrayList<String>> printTable = new ArrayList<ArrayList<String>>();
    private HashMap<String, String> colorSybolCat = new HashMap<String, String>();
    private String padding;

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


        List<String> symbolCatOrder = Arrays.asList("TYPE", "VAR", "FUNC");

        Collections.sort(printTable,
                (l1, l2) -> symbolCatOrder.indexOf(l1.get(0)) - symbolCatOrder.indexOf(l2.get(0)));

        if (cellsSizes.size() > 0) {
            colorSybolCat.put("VAR", "\033[32;1m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "VAR") + "\033[0m");
            colorSybolCat.put("TYPE", "\033[34;1m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "TYPE") + "\033[0m");
            colorSybolCat.put("FUNC", "\033[95;1m"
                    + String.format("%-" + (cellsSizes.get(0) + 1) + "s", "FUNC") + "\033[0m");
        }
        // this.padding = "\033[" + (this.scope.getImbricationLevel() * 7) + "C";
        this.padding = ".      ".repeat(this.scope.getImbricationLevel() + 1);

        this.printScope();
    }

    public void printBottomTable() {
        System.out.print(this.padding + "┗━");
        for (int i = 0; i < cellsSizes.size() - 1; i++) {
            System.out.print("━".repeat(cellsSizes.get(i) + 1) + "┻━");
        }
        System.out.print("━".repeat(cellsSizes.get(cellsSizes.size() - 1) + 1) + "┛\n");
    }

    public void printTopTable() {
        System.out.print(this.padding + "┏━");
        for (int i = 0; i < cellsSizes.size() - 1; i++) {
            System.out.print("━".repeat(cellsSizes.get(i) + 1) + "┳━");
        }
        System.out.print("━".repeat(cellsSizes.get(cellsSizes.size() - 1) + 1) + "┓\n");
    }

    public void printScope() {
        System.out.println(
                this.padding + "\n" + this.padding + "Scope ID : " + this.scope.getScopeId());
        System.out.println(this.padding + "Parent ID : " + this.scope.getParentScope());
        System.out
                .println(this.padding + "Imbrication Level : " + this.scope.getImbricationLevel());

        if (this.scope.getSymbols().size() > 0) {

            printTopTable();

            for (ArrayList<String> line : this.printTable) {
                System.out.print(
                        this.padding + "┃ " + String.format("%-" + (cellsSizes.get(0) + 1) + "s",
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
