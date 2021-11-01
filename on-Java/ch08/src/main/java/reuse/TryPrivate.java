package reuse;


class Test {
    private void Set() {
    }
}

class TestFinal {

}

public class TryPrivate extends Test {
    final TestFinal testFinal = null;

    public void test() {
        testFinal = new TestFinal();
    }
}
