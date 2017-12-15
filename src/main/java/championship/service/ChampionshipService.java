package championship.service;


import org.springframework.stereotype.Service;


@Service
public class ChampionshipService {

    public boolean checkSequence(String sequence) {
        if (isNumbers(sequence)&& checkSequenceLength(sequence))
            return true;
        else
            return false;
    }

    public boolean isNumbers(String sequence) {
        String pattern = "[0-9]+";
        boolean result = sequence.matches(pattern);
        return result;
    }

public boolean checkSequenceLength(String string) {
        if (string.length() <= 50 && string.length() > 0)

            return true;
        else
            return false;

    }

public Integer[] transformSequenceToArray(String sequence) {

        if (0 < sequence.length() && sequence.length() <= 50) {
            Integer sequenceArray[] = new Integer[sequence.length()];
            for (int i = 0; i < sequenceArray.length; i++) {
                sequenceArray[i] = Integer.parseInt(sequence.charAt(i) + "");
            }
            return sequenceArray;
        } else {
            return null;
        }

    }

 public boolean isEven(Integer number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }


    public Integer countTotalSteps(String sequence) {
        Integer sequenceArray[] = transformSequenceToArray(sequence);

        Integer totalStepsCount = 0;
        Integer index = 0;
        Integer infinite = 0;
        while (true) {
            if (isEven(sequenceArray[index])) {
                if ((sequenceArray.length - index - 1) >= sequenceArray[index]) {
                    if (index == (sequenceArray.length - 1)) {
                        infinite = 1;
                    } else if ((index == 0) && (infinite == 1)) {
                        totalStepsCount = -1;
                        break;
                    }

                    totalStepsCount += sequenceArray[index];
                    index += sequenceArray[index];

                } else {
                    totalStepsCount += index;

                    break;
                }

            } else {
                if (index >= sequenceArray[index]) {
                    if (index == (sequenceArray.length - 1)) {
                        infinite = 1;
                    } else if ((index == 0) && (infinite == 1)) {
                        totalStepsCount = -1;
                        break;
                    }
                    totalStepsCount += sequenceArray[index];
                    index = index - sequenceArray[index];

                } else {
                    totalStepsCount += index;
                    break;
                }
            }

        }

        return totalStepsCount;
    }
    

}
