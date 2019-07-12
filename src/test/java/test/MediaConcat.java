package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class MediaConcat {

    public static void main(String[] args) throws Exception {
        combineFile("F:\\mysql", "F:\\mysql_optimization");
    }

    public static void combineFile(String path, String tar) throws Exception {
        try {
            File dirFile = new File(path);
            FileInputStream fis = null;
            FileOutputStream fos = null;
            byte buffer[] = new byte[1024 * 1024 * 2];// 一次读取2M数据，将读取到的数据保存到byte字节数组中
            int len;
            if (dirFile.isDirectory()) { // 判断file是否为目录
                Set<String> fileNameSet = new HashSet(Arrays.asList(dirFile.list()));
                Map<String, List<String>> map = new HashMap<>();
                fileNameSet.forEach(str -> {
                    String frontStr = str.split("-")[0];
                    if (map.containsKey(frontStr)) {
                        map.get(frontStr).add(str);
                    } else {
                        List list = new ArrayList<String>();
                        list.add(str);
                        map.put(frontStr, list);
                    }
                });

                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    dirFile = new File(tar + "\\" + entry.getKey());
                    if (!dirFile.exists()){
                        dirFile.mkdirs();
                    }
//                    System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
                    List<String> list = entry.getValue();
                    len = 0;
                    if (list.size() > 1) {

                        Collections.sort(list);

                        for (String filename : list) {
                            fis = new FileInputStream(path + "\\" + filename);
                            fos = new FileOutputStream(tar + "\\" + entry.getKey() + "\\" + filename);
                            while ((len = fis.read(buffer)) != -1) {
                                fos.write(buffer, 0, len);// buffer从指定字节数组写入。buffer:数据中的起始偏移量,len:写入的字数。
                            }
                        }

                    } else {
                        fis = new FileInputStream(path + "\\" + list.get(0));
                        fos = new FileOutputStream(tar + "\\" + entry.getKey() + "\\" + list.get(0));
                        while ((len = fis.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);// buffer从指定字节数组写入。buffer:数据中的起始偏移量,len:写入的字数。
                        }
                    }

                }
                fis.close();
//                map.forEach((key, value) -> {
//                    System.out.println(key + ":" + value);
//
//                });
            }
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("合并完成！");
        }
    }

    // 此类实现Comparable接口
    static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            if (returnDouble(s1) < returnDouble(s2))
                return -1;
            else if (returnDouble(s1) > returnDouble(s2))
                return 1;
            else
                return 0;
        }
    }

    public static double returnDouble(String str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)))
                sb.append(str.charAt(i));
            else if (str.charAt(i) == '.' && i < str.length() - 1 && Character.isDigit(str.charAt(i + 1)))
                sb.append(str.charAt(i));
            else
                break;
        }
        if (sb.toString().isEmpty())
            return 0;
        else
            return Double.parseDouble(sb.toString());
    }
}
