package com.beyondvelocity.utils;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * Provides essential package related runtime type information.
 */
public class Rtti {
    public final String packageName;
    private final String packagePath;
    private final List<String> fileNames = new ArrayList<>();
    private final List<String> classNames = new ArrayList<>();

    /*
     * Initializes a new instance of the main package.
     */
    public Rtti(String packageName) {
        this.packageName = packageName;
        this.packagePath = packageName.replace('.', '/');

        findNames();
    }

    /*
     * Gets the packageName of the main package.
     */
    public String getPackageName() {
        return packageName;
    }

    /*
     * Gets the path to the main package.
     */
    public String getPackagePath() {
        return packagePath;
    }

    /*
     * Gets all the file names in the main package.
     */
    public String[] getFileNames() {
        return fileNames.toArray(new String[] {});
    }

    /*
     * Gets all the class names in the main package.
     */
    public String[] getClassNames() {
        return classNames.toArray(new String[] {});
    }

    /*
     * Gets a list of classes with the specified annotation.
     */
    public List<Class<?>> getClassesWith(Class<? extends Annotation> annotation) {
        List<Class<?>> results = new ArrayList<>();

        for(String name: classNames) {
            Class<?> cls;

            try {
                cls = Class.forName(name);
            } catch (ClassNotFoundException e) {
                continue;
            }

            if (cls.isAnnotationPresent(annotation) && !results.contains(cls)) {
                results.add(cls);
            }
        }

        return results;
    }

    // finds the files in the main package and initializes the names field accordingly.
    private void findNames() {
        try {
            var urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);

            while (urls.hasMoreElements()) {
                var url = urls.nextElement();
                findNamesFor(url);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // recursively searches the URL for file and class names.
    private void findNamesFor(URL url) throws IOException {
        if (!url.getProtocol().equals("file")) return;

        var dir = new File(url.getFile());
        var files = dir.listFiles();
        if (files == null) return;

        for (var file : files) {
            if (file.isDirectory()) {
                var dirUrl = file.toURI().toURL();
                findNamesFor(dirUrl);
                continue;
            }

            fileNames.add(file.getPath());

            if (file.getName().endsWith(".class")) {
                var name = getClassName(url.getPath(), file.getName());
                classNames.add(name);
            }
        }
    }

    // gets the class packageName from the specified url path and filename
    private String getClassName(String urlPath, String filename) {
        var sb = new StringBuilder();

        sb.append(urlPath.substring(urlPath.indexOf(packagePath)));

        if (sb.charAt(sb.length() - 1) != '/') {
            sb.append('/');
        }

        sb.append(filename);

        return sb.toString()
                 .replace('/', '.')
                 .replace(".class", "");
    }
}
