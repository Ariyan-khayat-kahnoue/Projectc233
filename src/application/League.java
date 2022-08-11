package application;

import java.lang.reflect.Array;

import application.TrackerAppController;

public class League<String> {
	String League;
	String Team1;
	String Team2;
	public League(String Leauge, String Team1, String Team2) {
		if (League != null && Team1!=null && Team2!= null) {
			getLeague();
		}
	}
	public Boolean getLeague() {
		Boolean LaLiga = false;
		Boolean BundasLiga = false;
		Boolean PremereLeague = false;
		Boolean SerieA = false;
		if (League.equals("La Liga")) {
			 LaLiga = true;
			return LaLiga;
		}
		if (League.equals("BundasLiga")) {
			BundasLiga = true;
			return BundasLiga;
		}
		if (League.equals("Premere League")) {
			PremereLeague = true;
			return PremereLeague;
		}
		if (League.equals("Serie A League")) {
			SerieA = true;
			return SerieA;
		}
		return false;
	}
	public void setLeague(String league) {
		League = league;
	}
	public String getTeam1() {
		return Team1;
	}
	public void setTeam1(String team1) {
		Team1 = League;
		
	}
	public String getTeam2() {
		return Team2;
	}
	public void setTeam2(String team2) {
		Team2 = team2;
	}
	
	
}
	
