package by.epam.task3.service;

public class CalculateFromStringImpl implements CalculateFromString {

    private static final CalculateFromStringImpl instance = new CalculateFromStringImpl();

    private String stringForCulculation;
    private String result;

     String Lex[];
     int ptrL;

     String opStack[];
     int ptrOp;

     String valStack[];
     int ptrVal;

    public CalculateFromStringImpl() {

        this.Lex=new String[200];
        for (int i=0; i<200; i++) Lex[i]="";
       this.ptrL=0;
        this.opStack=new String[200];
        this.ptrOp=0;
        this.valStack=new String[200];
        this.ptrVal=0;
    }

    public static CalculateFromStringImpl getInstance() {
        return instance;
    }

    public String getResult() {
        return result;
    }

    public String getStringForCulculation() {
        return stringForCulculation;
    }

    private void setResult(String result) {
        this.result = result;
    }

    public void stringForCulculation(String stringForCulculation) {
        this.stringForCulculation = stringForCulculation;
    }

    @Override
    public void calculate(String str) {
        stringForCulculation (str);

        String curr;
        String top;


        parsString(str);

        for (int i = 0; i <= ptrL; i++) {
            curr = Lex[i];
            switch (curr) {
                case "(":
                    pushOp(curr);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "^":
                    if (isEmptyOp()) {
                        pushOp(curr);
                        break;
                    }
                    top = peekOp();
                    if (Prty(curr) > Prty(top)) {
                        pushOp(curr);
                        break;
                    } else {
                        exec();
                        pushOp(curr);
                        break;
                    }
                case ")":
                    while (true) {
                        top = peekOp();
                        if (top.equals("(")) {
                            top = popOp();
                            break;
                        }
                        exec();
                    }
                    break;
                default:
                    pushVal(curr);
            }

        }

        setResult(popVal());
    }
    public  int Prty(String o)
    {
        int r=-1;
        switch (o)
        {
            case "(":
                r=0;
                break;
            case "+":
            case "-":
                r=1;
                break;
            case "*":
            case "/":
                r=2;
                break;
            case "^":
                r=3;
        }
        return r;
    }

    public  String peekOp()
    {
        return opStack[ptrOp-1];
    }

    public  boolean isEmptyOp()
    {
        return (ptrOp==0);
    }

    public  boolean isEmptyVal()
    {
        return (ptrVal==0);
    }

    public  void pushOp(String op)
    {
        opStack[ptrOp++]=op;
    }

    public  void pushVal(String v)
    {
        valStack[ptrVal++]=v;
    }

    public  String popOp()
    {
        return opStack[--ptrOp];
    }

    public  String popVal()
    {
        return valStack[--ptrVal];
    }

    public  void exec()
    {
        double a1,a2,r;
        String v1,v2;
        String op;

        v2=popVal();
        v1=popVal();
        op=popOp();

        a1=Double.parseDouble(v1);
        a2=Double.parseDouble(v2);

        r=0.0;

        switch (op)
        {
            case "+":
                r=a1+a2;
                break;
            case "-":
                r=a1-a2;
                break;
            case "*":
                r=a1*a2;
                break;
            case "/":
                r=a1/a2;
                break;
            case "^":
                r=Math.pow(a1,a2);
                break;
        }

        v1=Double.toString(r);
        pushVal(v1);

    }



    public void parsString(String str)
    {
        char s;
        String Tmp="";
        for (int i=0; i<str.length(); i++)
        {
            s=str.charAt(i);
            switch (s)
            {
                case '+':
                case '-':
                case '*':
                case '^':
                case '/':
                case '(':
                case ')':
                    if (Tmp.length() > 0)
                    {
                        Lex[ptrL++]=Tmp;
                        Tmp="";
                    }
                    Lex[ptrL++]=""+s;
                    break;
                case ' ':
                    break;
                default:
                    Tmp=Tmp+s;
            }
        }
        if (Tmp.length() > 0) Lex[ptrL]=Tmp;
    }


}
