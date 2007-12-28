/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fntest;

import fn.FnCompiler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import jd.ClassDescriptor;

/**
 *
 * @author Calvin Ashmore
 */
public class CompileTool {

    private static final String tempDirectoryName = "tempTest";

    static void createTestSource(String className, String contents) throws IOException {
        File tempDirectory = new File(tempDirectoryName);
        if (!tempDirectory.exists()) {
            tempDirectory.mkdir();
        }

        File testSource = new File(tempDirectory, className + ".java");
        FileOutputStream output = new FileOutputStream(testSource);
        output.write(contents.getBytes());
        output.close();
    }

    static void tearDown() {
        File tempDirectory = new File(tempDirectoryName);
        if (!tempDirectory.exists()) {
            return;
        }

        for (File tempFile : tempDirectory.listFiles()) {
            tempFile.delete();
        }

        tempDirectory.delete();
    }

    static boolean compileFile(String className) throws IOException {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnostics, null, null);

        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromStrings(
                Arrays.asList(tempDirectoryName + "/" + className + ".java"));

        JavaCompiler.CompilationTask task = compiler.getTask(
                null/*new FileWriter(tempDirectoryName+"/out.txt")*/,
                fileManager, diagnostics, null, null, compilationUnits);

        boolean result = task.call();
        
        List<Diagnostic<? extends JavaFileObject>> results = new ArrayList(diagnostics.getDiagnostics());
        for (Diagnostic<? extends JavaFileObject> diagnostic : results) {
            //diagnostics.report(diagnostic);
            System.out.println(diagnostic);
        }


        fileManager.close();
        return result;
    }

    static Class loadClass(String className) throws ClassNotFoundException {
        ClassLoader loader = new MyClassLoader(ClassLoader.getSystemClassLoader());
        return loader.loadClass(className);
    }

    static Object instantiate(String className, String contents) throws IOException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        createTestSource(className, contents);
        if (!compileFile(className)) {
            throw new InstantiationException("Class " + className + " failed to compile");
        }
        Class myClass = loadClass(className);

        Object obj = myClass.newInstance();
        return obj;
    }
    
    static Object instantiateFn(String className, String file) throws Exception {
        
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getBytes());
        FnCompiler compiler = new FnCompiler();
        ClassDescriptor result = compiler.compile(bis);
        
        return instantiate(className, result.toString());
    }

    private static class MyClassLoader extends ClassLoader {

        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {

            try {
                File classFile = new File(tempDirectoryName, name + ".class");
                FileInputStream fileInput = new FileInputStream(classFile);

                byte[] binData = new byte[fileInput.available()];
                fileInput.read(binData);
                fileInput.close();

                return defineClass(name, binData, 0, binData.length);
            } catch (ClassFormatError e) {
                throw new ClassNotFoundException("Cannot load class", e);
            } catch (FileNotFoundException e) {
                throw new ClassNotFoundException("Cannot load class", e);
            } catch (IOException e) {
                throw new ClassNotFoundException("Cannot load class", e);
            }
        }
    }
}
