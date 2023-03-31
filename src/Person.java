public class Person implements Speakable{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void speak(String msg) {
        System.out.println(this.name+":"+msg);
    }
}
