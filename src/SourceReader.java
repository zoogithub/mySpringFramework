import java.util.Map;

public interface SourceReader {
    //将读文件的任务分成一个类,文件格式不同，读取的方式也不同,如果文件类型过多，说不定还能搞个工厂
    Map<String,BeanInfo> load(String path);//这个string代表什么？谁需要这个string
}
