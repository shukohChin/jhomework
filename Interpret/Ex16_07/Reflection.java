package Ex16_07;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {

	/**
	 *
	 * @param obj
	 * 				フィールドを持つオブジェクト
	 * @param name
	 * 				フィールド名
	 * @return
	 * 				フィールド値
	 */
	public static Object getField(Object obj, String name) {
		Class<? extends Object> c = obj.getClass();

		Field f = null;
		try {
			f = c.getDeclaredField(name);
			f.setAccessible(true);
			return f.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 *
	 * @param obj
	 * 				フィールドを持つオブジェクト
	 * @param name
	 * 				フィールド名
	 * @param value
	 * 				セットする値
	 */
	public static void setField(Object obj, String name, Object value) {
		Class<? extends Object> c = obj.getClass();

		Field f = null;
		try {
			f = c.getDeclaredField(name);
			f.setAccessible(true);
			f.set(obj, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 *
	 * @param obj
	 * 				メソッドを持つオブジェクト
	 * @param name
	 * 				メソッド名
	 * @param args
	 * 				引数
	 */
	public static Object invoke(Object obj, String name, Class<?>[] args) {
		Class<? extends Object> c = obj.getClass();
		try {
			Method m = c.getDeclaredMethod(name, args);
			m.setAccessible(true);
			return m.invoke(obj, (Object[]) args);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
