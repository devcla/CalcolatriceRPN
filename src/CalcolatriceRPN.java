import java.util.Stack;

public class CalcolatriceRPN {
    private String notazioneInfissa;
    private String notazionePostfissa;
    public CalcolatriceRPN() {}

    public String getNotazioneInfissa() {
        return notazioneInfissa;
    }

    public String getNotazionePostfissa() {
        return notazionePostfissa;
    }

    public void setNotazioneInfissa(String notazioneInfissa) {
        this.notazioneInfissa = notazioneInfissa;
    }

    public void setNotazionePostfissa(String notazionePostfissa) {
        this.notazionePostfissa = notazionePostfissa;
    }

    private boolean isNumber(char c) {
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7'
                || c == '8' || c == '9') {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') {
            return true;
        }
        else {
            return false;
        }
    }

    private int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        else if (c == '*' || c == '/') {
            return 2;
        }
        else {
            return 0;
        }
    }

    private String outputToString(Stack<Character> output) {
        StringBuilder result = new StringBuilder();
        while (!output.isEmpty()) {
            Character element = output.pop();
            result.insert(0, element);
        }
        return result.toString();
    }

    public void trasformaInPostfissa() {
        Stack<Character> operatori = new Stack<>();
        Stack<Character> risultato = new Stack<>();

        for (int i = 0; i < notazioneInfissa.length(); i++) {
            char c = notazioneInfissa.charAt(i);
            if (isNumber(c)) {
                risultato.push(c);
            } else if (c == '(') {
                operatori.push(c);
            } else if (c == ')') {
                while (operatori.peek() != '(') {
                    risultato.push(operatori.pop());
                }
                operatori.pop();
            } else if (isOperator(c)) {
                while (!operatori.isEmpty() && getPriority(c) <= getPriority(operatori.peek())) {
                    risultato.push(operatori.pop());
                }
                operatori.push(c);
            }
        }

        while (!operatori.isEmpty()) {
            risultato.push(operatori.pop());
        }

        notazionePostfissa = outputToString(risultato);
    }
}
