package lambda.methodref;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyClass {
    private int iv;

    public MyClass() {
    }

    public MyClass(int iv) {
        this.iv = iv;
    }
}
