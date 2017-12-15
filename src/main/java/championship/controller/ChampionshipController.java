package championship.controller;


import championship.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ChampionshipController {
    private final ChampionshipService championshipService;


    @Autowired
    public ChampionshipController(ChampionshipService championshipService) {
        this.championshipService = championshipService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getSequence(@RequestParam(value = "sequence") String sequence) {
        if (championshipService.checkSequence(sequence)) {
            String steps = String.valueOf(championshipService.countTotalSteps(sequence));
            System.out.println(steps);
            return steps;
        } else return "Invalid sequence";
    }
}
