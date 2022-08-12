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
	public String getLeague() {
		if (League.equals("La Liga")) {
		setTeam1(League);
			return League;
		}
		if (League.equals("BundasLiga")) {
			
		}
		if (League.equals("Premere League")) {
			
		}
		if (League.equals("Serie A League")) {
			
		}
		return League;
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
	
