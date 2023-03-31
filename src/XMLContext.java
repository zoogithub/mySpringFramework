public class XMLContext extends AbstractBeanFactory{
    @Override
    protected void setReader(SourceReader reader) {
        this.reader=reader;
    }

    public XMLContext(String path) {
        super(path);//调用父类构造方法
        this.setReader(new XMLSourceReader());
        this.registerBeans();
    }
}
