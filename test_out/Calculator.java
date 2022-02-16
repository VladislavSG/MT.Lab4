import java.io.IOException;

public class Calculator extends AbstractParser {
    public Calculator(String src) {
        super(src);
    }

    public Node ruleE(Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            default: {
                Integer a = 0;
                node.add(ruleS(a));
                node.add(ruleS0(a));
                res = a;
                break;
            }
        }
        return node;
    }

    public Node ruleS0(Integer a) throws IOException {
        Node node = new Node();
        switch (peek()) {
            case ('+'): {
                expect("+");
                Integer next = 0;
                node.add(ruleS(next));
                a += next;
                node.add(ruleS0(a));
                break;
            }
            default: {
                break;
            }
        }
        return node;
    }

    public Node ruleS(Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            default: {
                Integer b = 1;
                node.add(ruleM(b));
                node.add(ruleM0(b));
                res += b;
                break;
            }
        }
        return node;
    }

    public Node ruleM0(Integer a) throws IOException {
        Node node = new Node();
        switch (peek()) {
            case ('*'): {
                expect("*");
                Integer b = 1;
                node.add(ruleM(b));
                a *= b;
                node.add(ruleM0(a));
                break;
            }
            default: {
                break;
            }
        }
        return node;
    }

    public Node ruleM(Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            default: {
                res = 0;
                node.add(ruleINT0(res));
                break;
            }
            case ('('): {
                expect("(");
                node.add(ruleE(res));
                expect(")");
                break;
            }
        }
        return node;
    }

    public Node ruleINT0(Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            default: {
                Integer f = null;
                node.add(ruleDIGIT(f));
                node.add(ruleINT1(f, res));
                break;
            }
        }
        return node;
    }

    public Node ruleINT1(Integer pref, Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            default: {
                Integer f = null;
                node.add(ruleDIGIT(f));
                pref = pref * 10 + f;
                node.add(ruleINT1(pref, res));
                break;
            }
            default: {
                res = pref;
                break;
            }
        }
        return node;
    }

    public Node ruleDIGIT(Integer res) throws IOException {
        Node node = new Node();
        switch (peek()) {
            case ('0'): {
                expect("0");
                res = 0;
                break;
            }
            case ('1'): {
                expect("1");
                res = 1;
                break;
            }
            case ('2'): {
                expect("2");
                res = 2;
                break;
            }
            case ('3'): {
                expect("3");
                res = 3;
                break;
            }
            case ('4'): {
                expect("4");
                res = 4;
                break;
            }
            case ('5'): {
                expect("5");
                res = 5;
                break;
            }
            case ('6'): {
                expect("6");
                res = 6;
                break;
            }
            case ('7'): {
                expect("7");
                res = 7;
                break;
            }
            case ('8'): {
                expect("8");
                res = 8;
                break;
            }
            case ('9'): {
                expect("9");
                res = 9;
                break;
            }
        }
        return node;
    }
}