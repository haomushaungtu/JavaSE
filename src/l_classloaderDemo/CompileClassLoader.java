package l_classloaderDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义类记载器</br>
 * 
 * @author huanghao
 *
 */
public class CompileClassLoader extends ClassLoader {

    private static Logger logger = LoggerFactory.getLogger(CompileClassLoader.class);

    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int) len];
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int r = inputStream.read(raw);
            if (r != len) {
                throw new IOException("无法读取全部文件:");
            }
            return raw;
        }
    }

    private boolean compile(String javaFile) throws IOException {
        logger.info("CompileClassLoader正在编译:[{}]......", javaFile);
        Process process = Runtime.getRuntime().exec("javac" + javaFile);
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        int result = process.exitValue();
        return result == 0;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        @SuppressWarnings("rawtypes")
        Class clazz = null;
        String fileStub = name.replace(".", "/");
        String javaFileName = fileStub + ".java";
        String classFileName = fileStub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);
        if (javaFile.exists() && !classFile.exists() || javaFile.lastModified() > classFile.lastModified()) {
            try {
                if (!compile(javaFileName) || !classFile.exists()) {
                    throw new ClassNotFoundException("ClassNotFoundException" + "javaFileName");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (classFile.exists()) {
            try {
                byte[] raw = getBytes(classFileName);
                clazz = defineClass(name, raw, 0, raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (clazz == null) {
            throw new ClassNotFoundException();
        }
        return clazz;
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (args.length == 0) {
            logger.info("缺少目标类,请按如下格式运行源文件");
            logger.info("java CompileClassLoader ClassName");
            return;
        }
        String progClass = args[0];
        String progArgs[] = new String[args.length - 1];
        System.arraycopy(args, 1, progArgs, 0, progArgs.length);
        CompileClassLoader cl = new CompileClassLoader();
        Class<?> clazz = cl.loadClass(progClass);
        Method method = clazz.getMethod("main", new String[0].getClass());
        Object argsArray[] = progArgs;
        method.invoke(null, argsArray);
    }
}
