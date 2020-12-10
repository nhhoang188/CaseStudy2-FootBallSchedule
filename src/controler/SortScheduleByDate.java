package controler;

import model.Match;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;


public class SortScheduleByDate implements Comparator<Match> {
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public int compare(Match match, Match match2) {
        try {
            return dateFormat.parse(match.getDayCompetition()).compareTo(dateFormat.parse(match2.getDayCompetition()));

        }catch (ParseException e){
            throw new IllegalArgumentException(e);
        }

    }
}
