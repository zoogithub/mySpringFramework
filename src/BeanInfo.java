import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

public class BeanInfo {
    private String id;//为什么要给对象分配id？全限定名难道不是唯一的吗？速度会快一点？
    private String className;//根据对象全名区分对象，并确定对象层级关系，也可以翻译为对象的类型(type)
    private Map<String,Object> properties=new HashMap<>();//key为属性名，value为属性值的集合

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
    public void addProperties(String name,Object value){
        this.properties.put(name,value);
    }
}
