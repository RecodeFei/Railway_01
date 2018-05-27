package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.nio.cs.ext.TIS_620;

public class FileWriter {
	public void wirte(String filePath,String teststring) {
		// TODO Auto-generated method stub
		String os = System.getProperty("os.name");
		File file = null;
		if(os.equals("Linux")){
			File dir = new File("/home/feikuang/workspace/tmp");
			this.judeDirExists(dir);
			file = new File("/home/feikuang/workspace/tmp", filePath);  
		}else if(os.equals("Mac OS X")){
			File dir = new File("/Users/feikuang/eclipse-workspace/tmp");
			this.judeDirExists(dir);
			file = new File("/Users/feikuang/eclipse-workspace/tmp", filePath);  
		}else {
			File dir = new File("C:\\tmp");
			this.judeDirExists(dir);
			file = new File("C:\\tmp", filePath);  
		}
        try {  
            file.createNewFile(); // 创建文件  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        // 向文件写入内容(输出流)  
        String str = teststring;  
        byte bt[] = new byte[1024];  
        bt = str.getBytes();  
        try {  
            FileOutputStream in = new FileOutputStream(file);  
            try {  
                in.write(bt, 0, bt.length);  
                in.close();  
                // boolean success=true;  
                // System.out.println("写入文件成功");  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
	 public void judeDirExists(File file) {
       if (file.exists()) {
         if (file.isDirectory()) {
                System.out.println("dir exists");
         } else {
              System.out.println("the same name file exists, can not create dir");
           }
       } else {
            System.out.println("dir not exists, create it ...");
          file.mkdir();
       }

     }

}
