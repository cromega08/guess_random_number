import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws Exception {
        byte to_guess = init();
        int answer;
        float num;
        String input;
        boolean pass = false, reached = false;
        Pattern regex = Pattern.compile("[a-zA-Z]");
        Matcher matcher;
        do {
            input = JOptionPane.showInputDialog(null, "Your number is:");
            matcher = regex.matcher(input);
            if (matcher.find()) {
                JOptionPane.showMessageDialog(null, "Alphabetic characters aren't supported\n\nJust enter numbers among 1 and 100");
                continue;
            }
            num = Float.parseFloat(input);
            answer = Math.round(num);
            pass = answer > 0 && answer < 101? true:false;
            if (pass) {
                byte difference = answer == to_guess? (byte) 0:
                                    answer > to_guess? (byte) 1:
                                    answer < to_guess? (byte) -1:null;
                switch (difference) {
                    case 0: reached = true; break;
                    case 1: JOptionPane.showMessageDialog(null, "Your number is higher than the answer"); break;
                    case -1: JOptionPane.showMessageDialog(null, "Your number is lower than the answer"); break;
                }
            } else {JOptionPane.showMessageDialog(null, "Your number isn't among the specified range");}
        } while(reached != true);
        last_output();
    }
    
    protected static byte init() {
        JOptionPane.showMessageDialog(null, "Welcome to the guess the number game\n\n" +
                                            "Your job is to guess a number among 1 and 100 and...\n\n" +
                                            "That's all! Give it a try!");
        Random random = new Random();
        int to_guess = random.nextInt(100) + 1; to_guess = random.nextInt(100) + 1;
        return (byte)to_guess;
    }

    protected static void last_output() {
        JOptionPane.showMessageDialog(null, "Congrats, you win!\n\nThere's no price, by the way :v");
        JOptionPane.showMessageDialog(null, "Coded by Cromega");
    }
}
