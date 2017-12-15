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
    

}
