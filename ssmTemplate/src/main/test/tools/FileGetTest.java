package tools;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class FileGetTest {
    @Test
    public void dome1() {
        //文件路径
        String path;
        path = ".";

        //获取文件对象
        File file = new File(path);

        //获取当前目录下的所有文件及文件夹
        File[] files = file.listFiles();

        for (File fileI : files) {

            System.out.println(fileI);
        }

    }

    @Test
    public void dome2() {
        //文件路径
        String path;
        path = "D:\\IDEA\\workspace\\SSM2\\src\\main\\webapp\\WEB-INF\\page";

        //获取文件对象
        File file = new File(path);

        //获取当前目录下的所有文件及文件夹名
        String[] fileNames = file.list();

        for (String fileName : fileNames) {
            System.out.println(fileName);
        }

    }


    @Test
    public void dome3() {
        String path;
        path = "D:\\IDEA\\workspace\\SSM2\\src\\main\\webapp\\WEB-INF\\page";
        ArrayList<String> filenames = new ArrayList<String>();
        getAllFileName(path, filenames);

        for (int i = 0; i < filenames.size(); i++) {
            System.out.println(filenames.get(i));
        }
    }

    //获取当前目录（包括子目录）下的所有文件及文件夹名
    public static void getAllFileName(String path, ArrayList<String> fileNames) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null) {
            //把当前目录的所有文件名记录下来
            fileNames.addAll(Arrays.asList(names));
        }
        //循环遍历所有文件，判断是否为文件夹，是则继续获取文件夹里的文件
        for (File fileI : files) {
            if (fileI.isDirectory()) {
                getAllFileName(fileI.getAbsolutePath(), fileNames);
            }
        }
    }
}
