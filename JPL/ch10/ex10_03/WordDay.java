package ch10.ex10_03;
import ch06.ex06_01.Day;

public class WordDay {
	public static boolean isWorkingDay1(Day day){
		if(day == Day.MONDAY || day == Day.TUESDAY || day == Day.WEDNESDAY ||
				day == Day.THURSDAY || day == Day.FRIDAY){
			return true;
		}else{
			return false;
		}
	}

	public static boolean isWorkingDay2(Day day){
		boolean result = false;

		switch(day){
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			result = true;
			break;
		case SATURDAY:
		case SUNDAY:
			result = false;
		}
		return result;
	}


	public static void main(String[] args){
		System.out.println("if");
		System.out.println("MONDAY: " + isWorkingDay1(Day.MONDAY));
		System.out.println("SATURDAY: " + isWorkingDay1(Day.SATURDAY));
		System.out.println("THURSDAY: " + isWorkingDay1(Day.THURSDAY));

		System.out.println("switch:");
		System.out.println("MONDAY: " + isWorkingDay2(Day.MONDAY));
		System.out.println("SATURDAY: " + isWorkingDay2(Day.SATURDAY));
		System.out.println("THURSDAY: " + isWorkingDay2(Day.THURSDAY));
	}
}
