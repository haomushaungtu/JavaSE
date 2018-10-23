package annotationDemo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author huanghao
 * @Retention只能用于修饰注解类型(指定保留时间) <br>
 * @Retention RUNTIME指定可以保留到运行期间，可以使用反射获取注解信息<br>
 * @Target 指定修饰的程序单元 <br>
 * @Documented 可以被提取成API文档 <br>
 * @Inherited 可被子类继承的注解<br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD })
@Documented
@Inherited
public @interface FirstAnnotation {

	String name() default "huanghao";

	int height();
}
