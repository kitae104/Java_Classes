package lambda.methodref;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyClass {
    private int iv;

    public MyClass() {
    }

    public MyClass(int iv) {
        this.iv = iv;
    }
}
