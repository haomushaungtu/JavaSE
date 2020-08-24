package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainResult {

	public void getTypeClass()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Person person = new Person();
		person.setPolice("警察");
		@SuppressWarnings("rawtypes")
		Class clazz =  person.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
		}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getName().startsWith("get")) {
				if (method.invoke(person) != null) {
					
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Field[] fields = Person.class.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(FirstAnnotation.class)) {
				FirstAnnotation firstAnnotation = (FirstAnnotation) field.getAnnotation(FirstAnnotation.class);
				System.out.println(firstAnnotation.height());
				System.out.println(field.getName());
			}
		}
		Class<Person> clazz = Person.class;
		if (clazz.isAnnotationPresent(FirstAnnotation.class)) {
			FirstAnnotation firstAnnotation = (FirstAnnotation) clazz.getAnnotation(FirstAnnotation.class);
			System.out.println(firstAnnotation.height());
		}

		MainResult result = new MainResult();
		result.getTypeClass();
	}
}
