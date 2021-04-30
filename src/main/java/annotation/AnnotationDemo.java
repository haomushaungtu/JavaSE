package annotation;

import java.lang.reflect.Field;

/**
 * @author admin
 */
public class AnnotationDemo {
    @FirstAnnotation(height = 100)
    private String height;

    public static void main(String[] args) {
        AnnotationDemo demo = new AnnotationDemo();
        Class<? extends AnnotationDemo> clazz = demo.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(FirstAnnotation.class)) {
                FirstAnnotation annotation = field.getAnnotation(FirstAnnotation.class);
                System.out.println(annotation.height());
            }
            System.out.println(field.getName());
        }
    }
}
