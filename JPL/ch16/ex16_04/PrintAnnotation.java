package ch16.ex16_04;

import java.lang.annotation.Annotation;

public class PrintAnnotation {
	public static void main(String[] args){
		Class<Test> cls = Test.class;
		Annotation[] runTimeAnno = cls.getAnnotations();
		for(Annotation ann : runTimeAnno){
			System.out.println(ann);
		}
	}
}
