package super_app;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class JavaTest {
    public static void main(String[] args) {
        IFn require = Clojure.var("clojure.core", "require");
        require.invoke(Clojure.read("super-app.javaiterop"));

        IFn hello = Clojure.var("super-app.javaiterop", "my-method");
        hello.invoke("hello java!");
    }
}