/**
 * This question involves a scoreboard for a game.
 * The game is played between two teams who alternate turns so that at any given
 * time, one team is active and the other team is inactive.
 * During a turn, a team makes one or more plays.
 * Each play can score one or more points and the team’s turn continues, or the
 * play can fail, in which case no points are scored and the team’s turn ends.
 * The Scoreboard class, which you will write, is used to keep track of the
 * score in a game.
 *
 * The Scoreboard class contains a constructor and two methods.
 *
 * • The constructor has two parameters. The first parameter is a String
 * containing the name of team 1, and the second parameter is a String
 * containing the name of team 2. The game always begins with team 1 as the
 * active team.
 *
 * • The recordPlay method has a single nonnegative integer parameter that is
 * equal to the number of points scored on a play or 0 if the play failed. If
 * the play results in one or more points scored, the active team’s score is
 * updated and that team remains active. If the value of the parameter is 0, the
 * active team’s turn ends and the inactive team becomes the active team. The
 * recordPlay method does not return a value.
 *
 * • The getScore method has no parameters. The method returns a String
 * containing information about the current state of the game. The returned
 * string begins with the score of team 1, followed by a hyphen ("-"), followed
 * by the score of team 2, followed by a hyphen, followed by the name of the
 * team that is currently active.
 *
 * @question 2
 */
public class Scoreboard {
	private final String team1Name;
	private final String team2Name;
	private int team1Score;
	private int team2Score;
	private boolean isTeam1Active;

	public Scoreboard(String t1n, String t2n) {
		team1Name = t1n;
		team2Name = t2n;
		team1Score = 0;
		team2Score = 0;
		isTeam1Active = true;
	}

	public void recordPlay(int points) {
		if (points == 0)
			isTeam1Active = !isTeam1Active;
		else if (isTeam1Active)
			team1Score += points;
		else
			team2Score += points;
	}

	public String getScore() {
		return String.format("%d-%d-%s", team1Score, team2Score, isTeam1Active ? team1Name : team2Name);
	}

	/**
	 * Copied from the sample test sequence in the question.
	 * Expected output:
	 * 0-0-Red
	 * 1-0-Red
	 * 1-0-Blue
	 * 1-0-Blue
	 * 1-3-Blue
	 * 1-4-Red
	 * 1-8-Red
	 * 0-0-Lions
	 * 1-8-Red
	 */
	public static void main(String[] args) {
		Scoreboard game = new Scoreboard("Red", "Blue");
		info(game.getScore());
		game.recordPlay(1);
		info(game.getScore());
		game.recordPlay(0);
		info(game.getScore());
		info(game.getScore());
		game.recordPlay(3);
		info(game.getScore());
		game.recordPlay(1);
		game.recordPlay(0);
		info(game.getScore());
		game.recordPlay(0);
		game.recordPlay(4);
		game.recordPlay(0);
		info(game.getScore());
		Scoreboard match = new Scoreboard("Lions", "Tigers");
		info(match.getScore());
		info(game.getScore());
	}

	// so that logging will be somewhat similar to the setting of the info variable
	// in the sample execution sequence from the question
	private static void info(String str) {
		System.out.println(str);
	}
}
