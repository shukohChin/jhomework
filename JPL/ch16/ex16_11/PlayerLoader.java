package ch16.ex16_11;

import java.io.IOException;

public class PlayerLoader extends ClassLoader{
	public Class<?> findClass(String name)throws ClassNotFoundException{
		try{
			byte[] buf = bytesForClass(name);
			return defineClass(name, buf, 0, buf.length);
		}catch(IOException e){
			throw new ClassNotFoundException(e.toString());
		}
	}
}
