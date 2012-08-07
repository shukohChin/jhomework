package Ex16_07;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Format {
	public static HashMap<String, Class<?>> map = new HashMap<String, Class<?>>();
	static{
		map.put("int", int.class);
		map.put("long", long.class);
		map.put("double", double.class);
		map.put("float", float.class);
		map.put("string", String.class);
		map.put("boolean", boolean.class);
	}

	public static Class<?>[] getClassTypes(String[] strs){
		Class<?>[] classTypes = new Class[strs.length / 2];
		for(int i = 0, j = 0; i < strs.length / 2; i++){
			classTypes[i] = Format.changeFormat(strs[j]);
			j += 2;
		}
		return classTypes;
	}

	public static Object[] getArgs(String[] strs){
		Object[] args = new Object[strs.length / 2];
		Class<?> classType;
		for(int i = 0, j = 1; i < strs.length / 2; i++){
			 classType = Format.changeFormat(strs[j - 1]);
			if(classType == int.class){
				args[i] = Integer.parseInt(strs[j]);
			}else if(classType == long.class){
				args[i] = Long.parseLong(strs[j]);
			}else if(classType == double.class){
				args[i] = Double.parseDouble(strs[j]);
			}else if(classType == float.class){
				args[i] = Float.parseFloat(strs[j]);
			}else if(classType == boolean.class){
				args[i] = Boolean.parseBoolean(strs[j]);
			}else{
				args[i] = strs[j];
			}
			j += 2;
		}
		return args;
	}

	//クラスオブジェクトを出す
	private static Class<?> changeFormat(String str){
		String strLow = str.toLowerCase();
		return(map.get(strLow));
	}


}
