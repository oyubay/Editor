package sample;

public class Result<T> {
    private T data;
    private boolean ok;

    public Result(boolean ok, T data){
        this.data = data;
        this.ok = ok;
    }
    public boolean isOk(){
        return ok;
    }
    public boolean hasData(){
        return data != null;
    }
    public T getData(){
        return data;
    }
}
