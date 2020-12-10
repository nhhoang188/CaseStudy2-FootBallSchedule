package model;

import controler.Schedules;

public class Match extends Schedules {
    private String dayCompetition, matchScore, broadcastChannel, nameHost, nameGuest;
    Team host;
    Team guest;

    public Match(String dayCompetition, String matchScore, String broadcastChannel, String nameHost, String nameGuest) {
        this.dayCompetition = dayCompetition;
        this.matchScore = matchScore;
        this.broadcastChannel = broadcastChannel;
        this.nameHost = nameHost;
        this.nameGuest = nameGuest;
    }

    public Match() {
    }

    public String getNameHost() {
        return nameHost;
    }

    public void setNameHost(String nameHost) {
        this.nameHost = nameHost;
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
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
        return "[" +
                "TeamHost=" + nameHost +
                ", matchScore='" + matchScore + '\'' +
                ", Teamguest=" + nameGuest +
                ", Day=" + dayCompetition +
                ", Channel='" + broadcastChannel + '\'' +
                ']';
    }
}
