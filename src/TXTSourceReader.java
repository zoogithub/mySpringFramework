import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TXTSourceReader implements SourceReader{
    //步骤：根据文件名和路径读取文件

    @Override
    public Map<String, BeanInfo> load(String path) {
        Map<String,BeanInfo> beans=new HashMap<>();
        BeanInfo beanInfo=new BeanInfo();
        File filename=new File("C:\\bean.txt");//如果路径有中文，可能会识别不了
//        System.out.println(filename.getPath()+filename.getAbsolutePath());
//        InputStreamReader reader=null;
        try {
            FileInputStream fis=new FileInputStream(filename);
            InputStreamReader reader=new InputStreamReader(fis);
//            reader=new InputStreamReader(new FileInputStream(filename));
            BufferedReader bufferedReader=new BufferedReader(reader);
            String line="";
            line=bufferedReader.readLine();
            while (line!=null){
                String[] tmp=line.split("=");
                for (String c:tmp){
                    System.out.println(c);
                }
                if (tmp[0].equals("id")){
                    beanInfo.setId(tmp[1]);
                }
                else if(tmp[0].equals("class")){
                    beanInfo.setClassName(tmp[1]);
                }
                else{
                    beanInfo.addProperties(tmp[0],tmp[1]);
                }
                line=bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        beans.put(beanInfo.getId(),beanInfo);
        return beans;
    }
}
