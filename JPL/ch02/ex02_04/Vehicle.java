package ch02.ex02_04;

public class Vehicle {
	public long speed;
	public String angle;
	public String owner;
	public static long nextId = 0;
	public long id; //変更されないのでfinalにすべき
}
