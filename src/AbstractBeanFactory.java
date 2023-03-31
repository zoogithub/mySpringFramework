import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public abstract class AbstractBeanFactory implements BeanFactory{
    //抽象工厂
    //功能:手动写入文件路径（注册）、根据路径调用其他类，进行读取信息、利用reflect将信息找到对应的class,生成new instance，并赋对应参数值
    private String filePath;
    private Map<String,BeanInfo> container;//这个东西用来干啥？
    protected SourceReader reader;//为什么是protected?
    protected abstract void setReader(SourceReader reader);//这个由不同的reader来自己set
    public void registerBeans(){
        this.container=this.reader.load(filePath);
    }
    @Override
    public Object getBean(String name) {
        BeanInfo beanInfo=this.container.get(name);
        if(beanInfo==null){
            System.out.println("找不到信息");
            return null;
        }

        return this.parseBean(beanInfo);
    }
    public AbstractBeanFactory(String path){
        this.filePath=path;
    }
    protected Object parseBean(BeanInfo beanInfo){//这个负责用反射将信息变成class和entity
        Class c;
        try {
            c=Class.forName(beanInfo.getClassName());//从信息中拿出类名，用类名到class里面搜索有没有这个类，如果没有，就throw exception
            Object beaninstance=c.newInstance();
            Method[] methods=c.getMethods();//获得所有method,这里不是很理解，既然都有了new instance了，难道里面没有method吗? answer:有method,但没有里面的参数
            //
            for (String property: beanInfo.getProperties().keySet()){//我还没用过这个keyset，好像是将所有key填进去
                String setter="set"+StringUtil.firstChartoUp(property);//尝试将类中的每一个元素都加上setter
                for (Method method:methods){
                    String methodName=method.getName();//如果类中已有的setter在property中能找到，则把它对应的值赋给方法
                    if(methodName.equals(setter)){
                        Object value=beanInfo.getProperties().get(property);
                        method.invoke(beaninstance,value);
                    }
                }
            }
            return beaninstance;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
