public class Command extends Main {
    private String[] args;
    private int argc;

    public Command(String[] args, int argc){
        this.args = args;
        this.argc = argc;
    }

    public String getCommand(){
        return this.args[0];
    }

    public String[] getArgs(){
        return this.args;
    }

    public int getArgc() { return this.argc; }
}
