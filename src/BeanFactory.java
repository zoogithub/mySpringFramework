public interface BeanFactory {
    //工厂模式
    //所有bean公用的方法写在这里
    Object getBean(String name);
}
