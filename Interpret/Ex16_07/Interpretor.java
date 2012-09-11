package Ex16_07;

import java.awt.Color;
import java.awt.Frame;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Interpretor {
	//ゲットクラス
	public Class<?> getInputClass(String className) throws Throwable{
		Class<?> c = null;
		Throwable failure;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
//			throw new ClassNotFoundException(className + "クラスが見つからない！", e);
			failure = e;
			throw failure;
		}
		return c;
	}

	//インスタンス生成
	public Object createInstanceWithoutArgs(String className) throws Throwable{
		Class<?> c = null;
		Throwable failure;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
//			throw new ClassNotFoundException(className + "クラスが見つからない！", e);
			failure = e;
			throw failure;
		}

		Object obj;
		try {
			obj = c.newInstance();
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
		return obj;
	}

	public Object createInstanceWithArgs(String className, Class<?>[] types, Object[] args) throws Throwable{
		Class<?> c = null;
		Throwable failure;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
//			throw new ClassNotFoundException(className + "クラスが見つからない！", e);
			failure = e;
			throw failure;
		}

		Constructor<?> constructor = null;

		try {
			constructor = c.getConstructor(types);
		} catch (SecurityException e) {
			failure = e;
			throw failure;
		} catch (NoSuchMethodException e) {
			failure = e;
			throw failure;
		}

		try {
			return constructor.newInstance(args);
		} catch (IllegalArgumentException e) {
			failure = e;
			throw failure;
		} catch (InstantiationException e) {
			failure = e;
			throw failure;
		} catch (IllegalAccessException e) {
			failure = e;
			throw failure;
		} catch (InvocationTargetException e) {
			failure = e;
			throw failure;
		}

	}

	//フィールドの値取得
	public String getFieldVal(Object obj) throws Throwable{
		Class<? extends Object> c = obj.getClass();
		StringBuilder sb = new StringBuilder();
		Field[] fs = null;
		Object result = null;
		Throwable failure;
		try {
			fs = c.getDeclaredFields();
			for(Field f : fs) {
				f.setAccessible(true);
				String decl = f.toString();
				sb.append(strip2(decl));
				if (Modifier.isStatic(f.getModifiers())) {
					result = f.get(null);
				} else {
					result = f.get(obj);
				}
				sb.append(" = " + result + "\n");
			}
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			failure = e;
			throw failure;
		}
		return sb.toString();
	}

	//メンバーを取得
	public String getAllMembers(String className){
		StringBuilder sb = new StringBuilder();
		Class<? extends Object> c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
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
	public void setField(Object obj, String field, Object val) throws Throwable{
		Class<? extends Object> c = obj.getClass();
		Field f = null;
		Throwable failure;
		try {
			f = c.getDeclaredField(field);
		} catch (SecurityException e) {
			failure = e;
			throw failure;
		} catch (NoSuchFieldException e) {
			try{
				f = c.getField(field);
			}catch (SecurityException e2) {
				failure = e2;
				throw failure;
			} catch (NoSuchFieldException e2) {
				failure = e2;
				throw failure;
			}
		}
		f.setAccessible(true);
		try {
			if (Modifier.isFinal(f.getModifiers())) {
				Field modifiersField = Field.class.getDeclaredField("modifiers");
				modifiersField.setAccessible(true);
				modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
			}
			if (Modifier.isStatic(f.getModifiers())) {
				f.set(null, val);
			} else {
				f.set(obj, val);
			}
		} catch (IllegalArgumentException e) {
			failure = e;
			throw failure;
		} catch (IllegalAccessException e) {
			failure = e;
			throw failure;
		}
	}

	//特定なフィールド取得
	public Object getField(Object obj, String field) throws Throwable{
		Class<? extends Object> c = obj.getClass();
		Field f = null;
		Object result = null;
		Throwable failure;
		try {
			f = c.getDeclaredField(field);
			f.setAccessible(true);
			if (Modifier.isStatic(f.getModifiers())) {
				result = f.get(null);
			} else {
				result = f.get(obj);
			}

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			failure = e;
			throw failure;
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
				throw failure;
			} catch (NoSuchMethodException e) {
				try{
					m = c.getDeclaredMethod(name, types);
				}catch (SecurityException e2) {
					failure = e2;
					throw failure;
				} catch (NoSuchMethodException e2) {
					failure = e2;
					throw failure;
				}
			}
			m.setAccessible(true);
			try {
				result = m.invoke(obj, (Object[]) args);
			} catch (IllegalArgumentException e) {
				failure = e;
				throw failure;
			} catch (IllegalAccessException e) {
				failure = e;
				throw failure;
			} catch (InvocationTargetException e) {
				failure = e.getCause();
				throw failure;
			}

			return result;
	}

	public Object invokeWithoutArgs(Object obj, String name) throws Throwable{
		Class<? extends Object> c = obj.getClass();
		Throwable failure;
		Method m = null;
		Object result = null;
		try {
			m = c.getMethod(name);
		} catch (SecurityException e) {
			failure = e;
			throw failure;
		} catch (NoSuchMethodException e) {
			failure = e;
			throw failure;
		}
		m.setAccessible(true);
		try {
			result = m.invoke(obj);
		} catch (IllegalArgumentException e) {
			failure = e;
			throw failure;
		} catch (IllegalAccessException e) {
			failure = e;
			throw failure;
		} catch (InvocationTargetException e) {
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

	private static String strip2(String decl) {
		int lastInd = decl.lastIndexOf(".");
		String result = null;
		if(decl.contains("[]")){
			result = decl.substring(lastInd + 1, decl.length()) + "[]";
		}else{
			result = decl.substring(lastInd + 1, decl.length());
		}
		return result;
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
		Object obj = null;
		try {
			obj = interpret.createInstanceWithoutArgs("java.awt.Frame");
			interpret.getFieldVal(obj);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			interpret.invokeWithoutArgs(obj, "isResizable");
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			interpret.invoke(obj, "setBackground", new Class[]{Color.class}, new Object[]{Color.blue});
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			interpret.setField(obj, "serialVersionUID", "22222");
		} catch (Throwable e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

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
//		String string = null;
//		try {
//			string = (String) interpret.createInstanceWithoutArgs("java.lang.String");
//		} catch (Exception e1) {
//			// TODO 自動生成された catch ブロック
//			e1.printStackTrace();
//		}
//		try {
//			string = (String) interpret.invoke(string, "substring",
//					new Class[] { int.class }, new Object[] { -1 });
//		} catch (Throwable e) {
//			// TODO 自動生成された catch ブロック
//			System.out.println(e.getCause().getCause());
//		}
	}
}
