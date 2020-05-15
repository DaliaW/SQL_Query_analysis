import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Schema5 {
	// CREATE TABLE playing_position(position_id NUMERIC PRIMARY KEY,
	// position_desc VARCHAR(15));

	public static long insertPlayingPosition(int ID, String positionDesc,
			Connection conn) {
		String SQL = "INSERT INTO playing_position(position_id,position_desc) "
				+ "VALUES(?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, positionDesc);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE soccer_country(country_id NUMERIC PRIMARY KEY, country_abbr
	// VARCHAR(4), country_name VARCHAR(40));
	public static long insertSoccerCountry(int ID, String abbrv, String name,
			Connection conn) {
		String SQL = "INSERT INTO soccer_country(country_id,country_abbr,country_name) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, abbrv);
			pstmt.setString(3, name);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE player_mast(player_id NUMERIC PRIMARY KEY, team_id NUMERIC,
	// jersey_no NUMERIC, player_name VARCHAR(40), posi_to_play NUMERIC
	// REFERENCES playing_position, dt_of_bir date, age NUMERIC, playing_club
	// VARCHAR(40));
	public static long insertPlayerMast(int ID, int teamID, int jerseyNo,
			String pName, int position, Date dob, int age, String playingClub,
			Connection conn) {
		String SQL = "INSERT INTO player_mast(player_id,team_id,jersey_no,player_name,posi_to_play,dt_of_bir,age,playing_club) "
				+ "VALUES(?,?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setInt(2, teamID);
			pstmt.setInt(3, jerseyNo);
			pstmt.setString(4, pName);
			pstmt.setInt(5, position);
			pstmt.setDate(6, dob);
			pstmt.setInt(7, age);
			pstmt.setString(8, playingClub);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE coach_mast(coach_id NUMERIC PRIMARY KEY, coach_name
	// VARCHAR(40));
	public static long insertCoachMast(int ID, String coachName, Connection conn) {
		String SQL = "INSERT INTO coach_mast(coach_id,coach_name) "
				+ "VALUES(?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, coachName);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE soccer_city(city_id NUMERIC PRIMARY KEY, city VARCHAR(25),
	// country_id NUMERIC REFERENCES soccer_country);
	public static long insertSoccerCity(int ID, String city, int countryID,
			Connection conn) {
		String SQL = "INSERT INTO soccer_city(city_id,city,country_id) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, city);
			pstmt.setInt(3, countryID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE soccer_venue(venue_id NUMERIC PRIMARY KEY, venue_name
	// VARCHAR(30), city_id NUMERIC REFERENCES soccer_city, aud_capacity
	// NUMERIC);
	public static long insertSoccerVenue(int ID, String name, int cityID,
			int audCapacity, Connection conn) {
		String SQL = "INSERT INTO soccer_venue(venue_id,venue_name,city_id,aud_capacity) "
				+ "VALUES(?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setInt(3, cityID);
			pstmt.setInt(4, audCapacity);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE refree_mast(referee_id NUMERIC PRIMARY KEY, referee_name
	// VARCHAR(40), country_id NUMERIC REFERENCES soccer_country);
	public static long insertRefreeMast(int ID, String name, int countryID,
			Connection conn) {
		String SQL = "INSERT INTO refree_mast(referee_id,referee_name,country_id) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setInt(3, countryID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE asst_referee_mast(ass_ref_id NUMERIC PRIMARY KEY,
	// ass_ref_name VARCHAR(40), country_id NUMERIC REFERENCES soccer_country);
	public static long insertAsstRefreeMast(int ID, String name, int countryID,
			Connection conn) {
		String SQL = "INSERT INTO asst_referee_mast(ass_ref_id,ass_ref_name,country_id) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, name);
			pstmt.setInt(3, countryID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE match_mast(match_no NUMERIC PRIMARY KEY, play_stage
	// CHARACTER(1), play_date date, results CHARACTER(5), decided_by
	// CHARACTER(1), goal_score CHARACTER(5), venue_id NUMERIC REFERENCES
	// soccer_venue, referee_id NUMERIC REFERENCES refree_mast, audonce NUMERIC,
	// plr_of_match NUMERIC REFERENCES player_mast, stop1_sec NUMERIC, stop2_sec
	// NUMERIC);
	public static long insertMatchMast(int ID, String stage, Date playDate,
			String results, String decidedBy, String goalScore, int venueID,
			int refreeID, int audience, int playerID, int stop1, int stop2,
			Connection conn) {
		String SQL = "INSERT INTO match_mast(match_no,play_stage,play_date,results,decided_by,goal_score,venue_id,referee_id,audonce,plr_of_match,stop1_sec,stop2_sec) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, stage);
			pstmt.setDate(3, playDate);
			pstmt.setString(4, results);
			pstmt.setString(5, decidedBy);
			pstmt.setString(6, goalScore);
			pstmt.setInt(7, venueID);
			pstmt.setInt(8, refreeID);
			pstmt.setInt(9, audience);
			pstmt.setInt(10, playerID);
			pstmt.setInt(11, stop1);
			pstmt.setInt(12, stop2);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE match_details(match_no NUMERIC PRIMARY KEY, play_stage
	// CHARACTER(1), team_id NUMERIC REFERENCES soccer_country, win_loss
	// CHARACTER(1), decided_by VARCHAR(1), goal_score NUMERIC, penalty_score
	// NUMERIC, ass_ref NUMERIC REFERENCES asst_referee_mast, player_gk NUMERIC
	// REFERENCES player_mast);

	public static long insertMatchDetails(int ID, String stage, int teamID,
			String winLose, String decidedBy, int goalScore, int penaltyScore,
			int refreeID, int playerID, Connection conn) {
		String SQL = "INSERT INTO match_details(match_no,play_stage,team_id,win_lose,decided_by,goal_score,penalty_score,ass_ref,player_gk) "
				+ "VALUES(?,?,?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, stage);
			pstmt.setInt(3, teamID);
			pstmt.setString(4, winLose);
			pstmt.setString(5, decidedBy);
			pstmt.setInt(6, goalScore);
			pstmt.setInt(7, penaltyScore);
			pstmt.setInt(8, refreeID);
			pstmt.setInt(9, playerID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE team_coaches(team_id NUMERIC REFERENCES soccer_country,
	// coach_id NUMERIC REFERENCES coach_mast, PRIMARY KEY(team_id, coach_id));
	public static long insertTeamCoaches(int ID, int coachID, Connection conn) {
		String SQL = "INSERT INTO team_coaches(team_id,coach_id) "
				+ "VALUES(?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setInt(2, coachID);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE soccer_team(team_id NUMERIC REFERENCES soccer_country,
	// team_group CHARACTER(1), match_played NUMERIC, won NUMERIC, draw NUMERIC,
	// lost NUMERIC, goal_for NUMERIC, goal_agnst NUMERIC, goal_diff NUMERIC,
	// points NUMERIC, group_position NUMERIC, PRIMARY KEY(team_id));
	public static long insertSoccerTeam(int ID, String stage, int matchPlayed,
			int won, int draw, int lost, int goalFor, int goalAgainst,
			int goalDiff, int points, int groupPosition, Connection conn) {
		String SQL = "INSERT INTO soccer_team(team_id,team_group,match_played,won,draw,lost,goal_for,goal_agnst,goal_diff,points,group_position) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setString(2, stage);
			pstmt.setInt(3, matchPlayed);
			pstmt.setInt(4, won);
			pstmt.setInt(5, draw);
			pstmt.setInt(6, lost);
			pstmt.setInt(7, goalFor);
			pstmt.setInt(8, goalAgainst);
			pstmt.setInt(9, goalDiff);
			pstmt.setInt(10, points);
			pstmt.setInt(11, groupPosition);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE player_in_out(match_no NUMERIC REFERENCES match_mast,
	// team_id NUMERIC REFERENCES soccer_country, player_id NUMERIC REFERENCES
	// player_mast, in_out CHARACTER(1), time_in_out NUMERIC, play_schedule
	// CHARACTER(2), play_half NUMERIC, PRIMARY KEY(match_no, team_id,
	// player_id));
	public static long insertPlayerInOut(int teamID, int matchNo, int playerID,
			String inOut, int timeInOut, String playSchedule, int playHalf,
			Connection conn) {
		String SQL = "INSERT INTO player_in_out(match_no,team_id,player_id,in_out,time_in_out,play_schedule,play_half) "
				+ "VALUES(?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(2, teamID);
			pstmt.setInt(1, matchNo);
			pstmt.setInt(3, playerID);
			pstmt.setString(4, inOut);
			pstmt.setInt(5, timeInOut);
			pstmt.setString(6, playSchedule);
			pstmt.setInt(7, playHalf);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE goal_details(goal_id NUMERIC PRIMARY KEY, match_no NUMERIC,
	// player_id NUMERIC REFERENCES player_mast, team_id NUMERIC REFERENCES
	// soccer_country,goal_time NUMERIC, goal_type CHARACTER(1), play_stage
	// CHARACTER(1), goal_schedule CHARACTER(2),goal_half NUMERIC );

	public static long insertGoalDetails(int ID, int matchNo, int playerID,
			int teamID, int goalTime, String goalType, String playStage,
			String goalSchedule, int goalHalf, Connection conn) {
		String SQL = "INSERT INTO goal_details(goal_id,match_no,player_id,team_id,goal_time,goal_type,play_stage,goal_schedule,goal_half) "
				+ "VALUES(?,?,?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setInt(2, matchNo);
			pstmt.setInt(3, playerID);
			pstmt.setInt(4, teamID);
			pstmt.setInt(5, goalTime);
			pstmt.setString(6, goalType);
			pstmt.setString(7, playStage);
			pstmt.setString(8, goalSchedule);
			pstmt.setInt(9, goalHalf);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE penalty_shootout(kick_id NUMERIC PRIMARY KEY, match_no
	// NUMERIC REFERENCES match_mast, team_id NUMERIC REFERENCES soccer_country,
	// player_id NUMERIC REFERENCES player_mast, score_goal VARCHAR(1), kick_no
	// NUMERIC);

	public static long insertPenaltyShootOut(int ID, int matchNo, int teamID,
			int playerID, String scoreGoal, int kickNo, Connection conn) {
		String SQL = "INSERT INTO penalty_shootout(kick_id,match_no,team_id,player_id,score_goal,kick_no) "
				+ "VALUES(?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, ID);
			pstmt.setInt(2, matchNo);
			pstmt.setInt(3, teamID);
			pstmt.setInt(4, playerID);
			pstmt.setString(5, scoreGoal);
			pstmt.setInt(6, kickNo);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE match_captain(match_no NUMERIC REFERENCES match_mast,
	// team_id NUMERIC REFERENCES soccer_country, player_gk NUMERIC REFERENCES
	// player_mast, PRIMARY KEY(match_no, team_id, player_gk));
	public static long insertMatchCaptain(int matchNo, int teamID,
			int playerGk, Connection conn) {
		String SQL = "INSERT INTO match_captain(match_no,team_id,player_gk) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, matchNo);
			pstmt.setInt(2, teamID);
			pstmt.setInt(3, playerGk);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE penalty_gk(match_no NUMERIC REFERENCES match_mast, team_id
	// NUMERIC REFERENCES soccer_country, player_gk NUMERIC REFERENCES
	// player_mast, PRIMARY KEY(match_no, team_id, player_gk));
	public static long insertPenaltyGk(int matchNo, int teamID, int playerGk,
			Connection conn) {
		String SQL = "INSERT INTO penalty_gk(match_no,team_id,player_gk) "
				+ "VALUES(?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, matchNo);
			pstmt.setInt(2, teamID);
			pstmt.setInt(3, playerGk);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// CREATE TABLE player_booked(match_no NUMERIC REFERENCES match_mast,
	// team_id NUMERIC REFERENCES soccer_country, player_id NUMERIC REFERENCES
	// player_mast, booking_time VARCHAR(40), sent_off CHARACTER(1),
	// play_schedule CHARACTER(2), play_half NUMERIC, PRIMARY KEY(match_no,
	// team_id, player_id));
	public static long insertPlayerBooked(int matchNo, int teamID,
			int playerID, String bookingTime, String sentOff,
			String playSchedule, int playHalf, Connection conn) {
		String SQL = "INSERT INTO player_booked(match_no,team_id,player_id,booking_time,sent_off,play_schedule,play_half) "
				+ "VALUES(?,?,?,?,?,?,?);";

		long id = 0;
		try {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(SQL,
					Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, matchNo);
			pstmt.setInt(2, teamID);
			pstmt.setInt(3, playerID);
			pstmt.setString(4, bookingTime);
			pstmt.setString(5, sentOff);
			pstmt.setString(6, playSchedule);
			pstmt.setInt(7, playHalf);

			int affectedRows = pstmt.executeUpdate();
			System.out.println("Number of affected rows is " + affectedRows);
			// check the affected rows
			if (affectedRows > 0) {
				// get the ID back
				try (ResultSet rs = pstmt.getGeneratedKeys()) {
					// System.out.println(rs.next());
					if (rs.next()) {
						id = rs.getLong(1);
						pstmt.close();
						conn.commit();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println(ex.getMessage());
				}
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		return id;
	}

	// ////////////////////////////////////////////// Data Population Methods
	// ///////////////////////////////////////
	public static void populatePlayingPosition(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertPlayingPosition(i, "Desc" + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateSoccerCountry(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertSoccerCountry(i, "GUC", "Germany" + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	@SuppressWarnings("deprecation")
	public static void populatePlayerMast(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertPlayerMast(i, i, i, "Salah" + i, i,
					new Date(12, 2, 1999), 19, "Liverpool" + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateCoachMast(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertCoachMast(i, "Name" + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateSoccerCity(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertSoccerCity(i, "Name" + i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateSoccerVenue(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertSoccerVenue(i, "Name" + i, i, 1000 + i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateRefreeMast(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertRefreeMast(i, "Name" + i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateAsstRefreeMast(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertAsstRefreeMast(i, "Name" + i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	@SuppressWarnings("deprecation")
	public static void populateMatchMast(Connection conn) {

		for (int i = 1; i < 10000; i++) {
			String result = "Win";
			if (i > 5000)
				result = "Lose";
			if (insertMatchMast(i, "a", new Date(28, 3, 2019), result, "b",
					"1-2", i, i, 1000 + i, i, i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateMatchDetails(Connection conn) {

		for (int i = 1; i < 10000; i++) {
			String result = "W";
			if (i > 5000)
				result = "L";
			if (insertMatchDetails(i, "a", i, result, "b", i, i, i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateTeamCoach(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertTeamCoaches(i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateSoccerTeam(Connection conn) {

		for (int i = 1; i < 10000; i++) {

			if (insertSoccerTeam(i, "a", i, i, i, i, i, i, i, i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populatePlayerInOut(Connection conn) {

		for (int i = 1; i < 10000; i++) {

			if (insertPlayerInOut(i, i, i, "a", i, "ab", i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateGoalDetails(Connection conn) {

		for (int i = 1; i < 10000; i++) {
			if (insertGoalDetails(i, i, i, i, i, "b", "i", "m", i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populatePenaltyShootOut(Connection conn) {

		for (int i = 1; i < 10000; i++) {
			if (insertPenaltyShootOut(i, i, i, i, "b", i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populateMatchCaptain(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertMatchCaptain(i, i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populatePenaltyGk(Connection conn) {
		for (int i = 1; i < 10000; i++) {

			if (insertPenaltyGk(i, i, i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void populatePlayerBooked(Connection conn) {

		for (int i = 1; i < 10000; i++) {

			if (insertPlayerBooked(i, i, i, "a", "b", "ab", i, conn) == 0) {
				System.err.println("insertion of record " + i + " failed");
				break;
			} else
				System.out.println("insertion was successful");
		}
	}

	public static void insertSchema5(Connection connection) {
		populatePlayingPosition(connection);
		populateSoccerCountry(connection);
		populatePlayerMast(connection);
		populateCoachMast(connection);
		populateSoccerCity(connection);
		populateSoccerVenue(connection);
		populateRefreeMast(connection);
		populateAsstRefreeMast(connection);
		populateMatchMast(connection);
		populateMatchDetails(connection);
		populateTeamCoach(connection);
		populateSoccerTeam(connection);
		populatePlayerInOut(connection);
		populateGoalDetails(connection);
		populatePenaltyShootOut(connection);
		populateMatchCaptain(connection);
		populatePenaltyGk(connection);
		populatePlayerBooked(connection);
	}

	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/schema5", "postgres",
					"YOURPASSWORD");
			insertSchema5(connection);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
}
