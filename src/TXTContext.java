public class TXTContext extends AbstractBeanFactory{
    public TXTContext(String path) {
        super(path);
        this.setReader(new TXTSourceReader());
        this.registerBeans();
    }

    @Override
    protected void setReader(SourceReader reader) {
        this.reader=reader;
    }


}
