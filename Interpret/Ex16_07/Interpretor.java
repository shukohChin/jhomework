package Ex16_07;

import java.awt.Frame;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class Interpretor {
	Class<?> cls;

	//インスタンス生成
	public Object createInstanceWithoutArgs(String className){
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Object obj;
		try {
			obj = cls.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}

	public Object createInstanceWithArgs(String className, Class<?>[] types, Object[] args) throws Throwable{
		Class<?> c = null;

		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}


		Constructor<?> constructor = null;

		try {
			constructor = c.getConstructor(types);
		} catch (SecurityException e) {
			System.out.println(e);
			return null;
		} catch (NoSuchMethodException e) {
			System.out.println(e);
			return null;
		}

		try {
			return constructor.newInstance(args);
		} catch (IllegalArgumentException e) {
			System.out.println(e);
			return null;
		} catch (InstantiationException e) {
			System.out.println(e);
			return null;
		} catch (IllegalAccessException e) {
			System.out.println(e);
			return null;
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw e.getCause();
		}

	}

	//メンバーを取得
	public String getAllMembers(String className){
		StringBuilder sb = new StringBuilder();
		Class<? extends Object> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			sb.append("クラスが見つからない！");
			return sb.toString();
		}

		sb.append("コンストラクタリスト↓\n");
		sb.append(Interpretor.printMembers(c.getConstructors()));
		sb.append("フィールドリスト↓\n");
		sb.append(Interpretor.printMembers(c.getDeclaredFields()));
		sb.append("メソッドリスト↓\n");
		sb.append(Interpretor.printMembers(c.getMethods()));
		return sb.toString();
	}

	//フィールド修正
	public void setField(Object obj, String field, Object val){
		Class<? extends Object> c = obj.getClass();
		try {
			Field f = c.getDeclaredField(field);
			f.setAccessible(true);
			f.set(obj, val);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	//特定なフィールド取得
	public Object getField(Object obj, String field){
		Class<? extends Object> c = obj.getClass();
		Field f = null;
		Object result = null;
		try {
			f = c.getDeclaredField(field);
			f.setAccessible(true);
			result = f.get(obj);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return result;
	}

	//メソッド呼び出す
	public Object invoke(Object obj, String name, Class<?>[] types, Object[] args) throws Throwable {
		Class<? extends Object> c = obj.getClass();
		Throwable failure;
			Method m = null;
			Object result = null;
			try {
				m = c.getMethod(name, types);
			} catch (SecurityException e) {
				failure = e;
			} catch (NoSuchMethodException e) {
				failure = e;
			}
			m.setAccessible(true);
			try {
				result = m.invoke(obj, (Object[]) args);
			} catch (IllegalArgumentException e) {
				failure = e;
			} catch (IllegalAccessException e) {
				failure = e;
			} catch (InvocationTargetException e) {
				System.out.println(m);
				failure = e.getCause();
				throw failure;
			}

			return result;
	}

	//コンストラクタ
	public Object getConstructor(Object obj, Class<?>[] types, Object[] args) {
		Class<?> c = obj.getClass();

		Constructor constructor;
		try {
			constructor = c.getConstructor(types);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		Object result = null;
		try {
			result = constructor.newInstance(args);
		} catch (Exception e) {

		}
		return result;
	}

	private static String printMembers(Member[] mems) {
		StringBuilder sb = new StringBuilder();
		for(Member m : mems) {
			String decl = m.toString();
			strip(decl, "java.lang.");
			sb.append(decl + "\n");
		}
		sb.append("\n");
		return sb.toString();
	}

	private static String strip(String decl, String str) {
		return decl.replaceAll(str, "");
	}

	public static void main(String[] args){
		Interpretor interpret = new Interpretor();
		try {
			Frame frame = (Frame)interpret.createInstanceWithArgs("java.awt.Frame", new Class[]{String.class}, new Object[]{"TTTTTTTT"});
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		Frame frame = (Frame) interpret.createInstance("java.awt.Frame");
//
//		Object obj = interpret.createInstance("java.awt.Frame");

//		try {
//			interpret.invoke(obj, "setVisible", new Class[]{boolean.class}, new Object[]{true});
//		} catch (Throwable e1) {
//			// TODO 自動生成された catch ブロック
//			e1.printStackTrace();
//		}


//		System.out.println(obj.getClass());
////		interpret.printField();
//		interpret.setField(frame, "title", "Title");
//
//		Class[] types = {int.class, int.class};
//		Integer[] integerArgs = {new Integer(200), new Integer(100)};
//		try {
//			interpret.invoke(frame, "setSize", types, integerArgs);
//		} catch (Throwable e) {
//			// TODO 自動生成された catch ブロック
//			System.out.println(e.getMessage());
//		}
//
//		Class[] types2 = {String.class};
//		String[] stringArgs = {"TITLE"};
//		Frame frame2 = (Frame) interpret.getConstructor(frame, types2, stringArgs);
//		frame.setVisible(true);
//		frame2.setVisible(true);
//
//
//		String string = (String) interpret.createInstance("java.lang.String");
//		try {
//			string = (String) Interpretor.invoke(string, "substring",
//					new Class[] { int.class }, new Object[] { -1 });
//		} catch (Throwable e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
	}
}
