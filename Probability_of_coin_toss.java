import java.util.Random;

/**
 * Let's say we have a function findProbabilityofCoinToss(), this predicts the
 * toss with a probability of an event with a 40% and 60% accuracy, such as 40%
 * head and 60% time tails. So how can we write another method over this to
 * manipulate the frequency to be 50% for eacg ocurance.
 */

public class Probability_of_coin_toss {


    private String makeProbEqual() {
        Random rand = new Random();
        String side = findProbabilityofCoinToss();
        if("tails".equals(side) && rand.nextInt(0,6) == 5) {
            return "heads";
        }
        return side;
    }

}