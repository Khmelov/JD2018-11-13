package by.it.skarpovich.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskC {
    static String dir(Class<?> cl) {
        String mypath = System.getProperty("user.dir") + File.separator + "src" + File.separator+"by" + File.separator + "it" + File.separator+"skarpovich"+File.separator;

        //String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        //System.out.println(cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator));
       // System.out.println(cl.getTypeName());
        //System.out.println(System.getProperty("user.dir"));
        return mypath;
    }

    public static void main(String[] args) {

                File f = null;
                File[] paths;

                try {

                    // create new file
                    f = new File(dir(TaskC.class));

                 // returns pathnames for files and directory
                    paths = f.listFiles();

                    // for each pathname in pathname array
                    for(File path:paths) {
                        if (f.isFile()){
                            System.out.println(f.getName());
                        }
                        if (f.isDirectory()){
                            System.out.println(f.getName());
                        }
                        // prints file and directory paths
                        System.out.println(path);
                        System.out.println(f.getPath());
                    }

                } catch(Exception e) {
                    // if any error occurs
                    e.printStackTrace();
                }
            }
        }

