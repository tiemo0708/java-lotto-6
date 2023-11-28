package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.constants.ErrorMessage.*;
import static lotto.view.ConstantsMessage.*;

public class LottoInput {
    public String askPrice() {
        System.out.println(ASK_BUY_PRICE.getMessage());
        String input = Console.readLine();
        return input;

    }

    public List<Integer> prizeNumberInput() {
        while (true) {
            try {
                printNewLine();
                System.out.println(ASK_PRIZE_NUMBER.getMessage());
               return  changeInt(Arrays.asList(Console.readLine().split(",")));
            }catch (IllegalArgumentException e){
                System.out.println(OUTFRANGE.getMessage());
            }
        }
    }
    public Integer bonusNumberInput() {
        try{
        printNewLine();
        System.out.println(ASK_BONUS_NUMBER.getMessage());
        String input = Console.readLine();

        return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ONENUMBER.getMessage());
        }

    }
    private List<Integer> changeInt(List<String> prizeNumbers) {
            try{
                List<Integer> numbers = prizeNumbers.stream()
                        .map(Integer::parseInt)
                        .filter(i->i>0&&i<45)
                        .toList();
                if(numbers.size() != prizeNumbers.size()){
                    throw new NumberFormatException();
                }
                return numbers;
            }catch (NumberFormatException e){
                throw new IllegalArgumentException(OUTFRANGE.getMessage());
            }

    }

    private void printNewLine() {
        System.out.println();
    }
}
