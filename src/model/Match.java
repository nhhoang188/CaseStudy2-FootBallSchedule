package model;

public class Match {
    private String dayCompetition, matchScore,broadcastChannel;
    Team host;
    Team guest;

    public Match(String dayCompetition, String matchScore, String broadcastChannel, Team host, Team guest) {
        this.dayCompetition = dayCompetition;
        this.matchScore = matchScore;
        this.broadcastChannel = broadcastChannel;
        this.host = host;
        this.guest = guest;
    }

    public Match() {
    }

    public String getDayCompetition() {
        return dayCompetition;
    }

    public void setDayCompetition(String dayCompetition) {
        this.dayCompetition = dayCompetition;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    public String getBroadcastChannel() {
        return broadcastChannel;
    }

    public void setBroadcastChannel(String broadcastChannel) {
        this.broadcastChannel = broadcastChannel;
    }

    public Team getHost() {
        return host;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    public Team getGuest() {
        return guest;
    }

    public void setGuest(Team guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "Match{" +
                "dayCompetition='" + dayCompetition + '\'' +
                ", matchScore='" + matchScore + '\'' +
                ", broadcastChannel='" + broadcastChannel + '\'' +
                ", host=" + host.getName() +
                ", guest=" + guest.getName() +
                '}';
    }
}
