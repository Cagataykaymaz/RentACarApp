package kodlamaio.northwind.core.utilities.results;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data, String message) {
        super(data, true,message);
    }
    public ErrorDataResult(T data) {
        super(data, true);
    }
}
