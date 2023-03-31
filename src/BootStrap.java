public class BootStrap {
    public static void main(String[] args) {
        BeanFactory factory=new TXTContext("bean.txt");
        Speakable s=(Speakable)factory.getBean("Person");
        s.speak("我是你爸爸");
    }
}
