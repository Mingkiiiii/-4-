package ch11_java_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;



public class ApiDate {

	public static void main(String[] args) {
		// 1. Date클래스
		// 1970년 1월 1일 자정(UTC)이후의 시간을 밀리초 단위로 표현
		Date dateToday = new Date();
		System.out.println(dateToday);
		// 원하는 포멧형태로 만들 수 있음. 단 yyyy <- 같은 고정표현을 사용하며
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String strToday = simpleDateFormat.format(dateToday);
		System.out.println(strToday);
		// dateToday 사용하여 2024-01-17 을 출력하시오
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
		String strToday1 = simpleDateFormat1.format(dateToday);
		System.out.println(strToday1);
		//뉴욕시간
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss",Locale.US);
		TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
		sdf3.setTimeZone(timeZone);
		String newYork = sdf3.format(dateToday);
		System.out.println(newYork);
		
		String strDinner = "2024-01-18 18:10:00";
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dinner = null;
		try {
			dinner = simpleDateFormat.parse(strDinner);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			System.out.println(dinner);
		}
		//
		System.out.println(dateToday.getTime());
		System.out.println(dinner.getTime());
		long diffMillSec = dinner.getTime()- dateToday.getTime();
		System.out.println(diffMillSec + "밀리초 남음");
		System.out.println(diffMillSec/1000 + "초 남음");
		System.out.println(diffMillSec/1000/60 + "분 남음");
		System.out.println(diffMillSec/1000/60/60 + "시간 남음");
		// Calendar 클래스 (YEAR, MONTH.. 같은 필드를 제공) 날자계산 조작 유용함.
		// 1일뒤 한달 뒤 와 같은..
		Calendar calToday = Calendar.getInstance();
		System.out.println(calToday.getTime());
		System.out.println(calToday.get(Calendar.YEAR));
		System.out.println(calToday.get(Calendar.MONTH)+1);
		System.out.println(calToday.get(Calendar.DATE));
		System.out.println(calToday.get(Calendar.HOUR_OF_DAY));
		//3일뒤
		calToday.add(Calendar.DATE, 3);
		System.out.println(simpleDateFormat.format(calToday.getTime()));
		// 10일전
		calToday.add(Calendar.DATE, -10);
		System.out.println(simpleDateFormat.format(calToday.getTime()));
		// 5개월뒤
		calToday.add(Calendar.MONTH, 5);
		System.out.println(simpleDateFormat.format(calToday.getTime()));
		// 달력만들기
		Calendar calendars = Calendar.getInstance();
		int year = 2024;
		int month = 1;
		calendars.set(year, month-1, 1);  // 해당월 1일날짜
		// 해당월의 마지막 일자 얻기
		int lastDay = calendars.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		// 해당 월의 시작요일
		//1:일요일 2:월요일
		int startDay= calendars.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		System.out.println(year + "년" + month + "월 달력");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		int current = 1;
		for(int i=1; i<=42; i++) {
			if(i < startDay) {
				System.out.print("\t");
			}else {
				System.out.printf("%d\t", current);
				current++;
				if(current > lastDay) {
					break;
				}
			}
			if(i % 7 ==0) {
				System.out.println();
				
			}
		}
		System.out.println();
		
		
		workingCalendar(2024, 2);
		workingCalendar(2024, 3);
		workingCalendar(2024, 4);
		workingCalendar(2024, 5);
		workingCalendar(2024, 6);
		

	}
	public static void workingCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(year + "년 " + month + "월 달력");
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        // 시작 요일 전까지 공백을 채운다.
        for (int i = 1; i < startDay; i++) {
            System.out.print("\t");
        }

        for (int day = 1, dayOfWeek = startDay; day <= lastDay; day++, dayOfWeek++) {
            System.out.print(day + "\t");

            // 토요일이 지나면 줄을 바꾼다.
            if (dayOfWeek == Calendar.SATURDAY) {
                System.out.println();
                dayOfWeek = 0; // 요일을 초기화 (일요일부터 다시 시작)
            }
        }
        System.out.println(); // 마지막 줄바꿈
    }
    

}
