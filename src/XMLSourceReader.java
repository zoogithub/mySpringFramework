import java.util.HashMap;
import java.util.Map;
import org.xml.sax.*;
public class XMLSourceReader implements SourceReader{
    //参考课本，这里没有读取而是直接设置了，实际上需要读取file
    @Override
    public Map<String, BeanInfo> load(String path) {
        BeanInfo beanInfo=new BeanInfo();
        beanInfo.setId("person");
        beanInfo.setClassName("com.example.springframework");
        beanInfo.addProperties("name","王尼玛");
        Map<String,BeanInfo> beans=new HashMap<>();
        beans.put("person",beanInfo);
        return beans;
    }
}
