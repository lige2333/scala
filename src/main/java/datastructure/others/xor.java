package datastructure.others;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class xor {
    public static void main(String[] args) {
        Boolean calc = calc("(0&0)|(1&1)|0|(0&1&0)|0");
        System.out.println(calc);
    }

    public static Boolean calc(String cal) {
        LinkedList<String> boolStack = new LinkedList<>();
        LinkedList<String> symbolStack = new LinkedList<>();
        List<String> listString = getListString(cal);
        for (String item : listString) {
            if (item.matches("\\d+")) {
                boolStack.add(item);
                if (symbolStack.size() > 0 && !symbolStack.peek().equals("(")) {
                    calc(boolStack,symbolStack);
                }
            } else if (item.equals("(")) {
                symbolStack.push(item);
            } else if (item.equals(")")) {
                while (!symbolStack.peek().equals("(")) {
                   calc(boolStack,symbolStack);
                }
                symbolStack.pop();
            } else {
                symbolStack.add(item);
            }
        }
        return !boolStack.pop().equals("0");
    }

    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split("");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    public static void calc(LinkedList<String> boolStack ,LinkedList<String> symbolStack) {
        String sym = symbolStack.pop();
        Boolean bool1 = !boolStack.pop().equals("0");
        Boolean bool2 = !boolStack.pop().equals("0");
        boolStack.add(logicCal(bool1, bool2, sym)?"1":"0");
    }



    public static Boolean logicCal(Boolean a1, Boolean a2, String calSym) {
        if (calSym.equals("&")) {
            return Boolean.logicalAnd(a1, a2);
        } else if (calSym.equals("|")) {
            return Boolean.logicalOr(a1, a2);
        }
        return false;
    }
}
