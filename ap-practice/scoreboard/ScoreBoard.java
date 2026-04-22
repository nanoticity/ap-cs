public class ScoreBoard {

  private String team1Name;
  private String team2Name;
  private int team1Score;
  private int team2Score;
  private int activeTeam;

  public ScoreBoard(String team1Name, String team2Name) {
    this.team1Name = team1Name;
    this.team2Name = team2Name;
    this.team1Score = 0;
    this.team2Score = 0;
    this.activeTeam = 1;
  }

  public void recordPlay(int points) {
    if (points > 0) {
      if (activeTeam == 1) {
        team1Score += points;
      } else {
        team2Score += points;
      }
    } else {
      activeTeam = (activeTeam == 1) ? 2 : 1;
    }
  }

  public String getScore() {
    String activeTeamName = (activeTeam == 1) ? team1Name : team2Name;
    return team1Score + "-" + team2Score + "-" + activeTeamName;
  }
}
