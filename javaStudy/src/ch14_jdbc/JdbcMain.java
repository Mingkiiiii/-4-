package ch14_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcMain {
	
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String DB_ID = "java";
	private static final String DB_PW = "oracle";
	
	public static boolean updateUser(int hakno, String userNm) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("등록 실패");
			System.exit(0); 
		}

		try {
			conn = DriverManager.getConnection(URL, DB_ID,DB_PW);
			System.out.println("접속 성공");
			StringBuffer query = new StringBuffer();
			query.append(" UPDATE 학생");
			query.append(" SET 이름 = ?");
			query.append(" WHERE 학번=?");
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, userNm);
			ps.setInt(2, hakno);
			int cnt = ps.executeUpdate();
			if(cnt > 0) {
				System.out.println(cnt + "건 업데이트됨.");
				return true;
			}else {
				System.out.println("대상건이 없음.");	
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close(); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void printUserInfo(int hakno, String userNm) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        Class.forName("oracle.jdbc.driver.OracleDriver");
	        conn = DriverManager.getConnection(URL, DB_ID,DB_PW);
	        StringBuffer query = new StringBuffer();
	        query.append(" SELECT * FROM 학생");
	        query.append(" WHERE 학번 = ? OR 이름 = ?");
	        ps = conn.prepareStatement(query.toString());
	        ps.setInt(1, hakno);
	        ps.setString(2, userNm);
	        rs = ps.executeQuery();

	        while(rs.next()) {
	            // 적절한 필드명으로 변경해 주세요.
	            int hakNo = rs.getInt("학번");
	            String name = rs.getString("이름");
	            // 추가적인 필드가 있다면 이곳에 작성해주세요.
	            System.out.println("학번: " + hakNo + ", 이름: " + name);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if(rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(ps != null) {
	            try {
	                ps.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if(conn != null) {
	            try {
	                conn.close(); 
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 학번을 입력해주세요:");
		int hanNo = Integer.parseInt(scan.nextLine());
		System.out.println("새로운 이름을 입력하세요:");
		String nm = scan.nextLine();
		boolean result = updateUser(hanNo, nm);
		if(result) {
			System.out.println("정보가 성공적으로 업데이트 되었습니다.");
		}else {
			System.out.println("정보 업데이트에 실패했습니다.");
		}
		
		
		
		
		// 사용자의 이름 or 학번을 입력받아
		// 정보를 출력하는 메서드를 만들고 테스트하시오.
		System.out.println("조회할 학번 혹은 이름을 입력하세요:");
	    String input = scan.nextLine();
	    int hakNo = -1;
	    String userName = "";

	    // 입력값이 숫자인지 문자인지 판별
	    try {
	        hakNo = Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        userName = input;
	    }

	    printUserInfo(hakNo, userName);
	}
	}

