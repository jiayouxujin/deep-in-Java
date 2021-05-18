package com.example.java;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.List;

public class SnapshotDemo {

    private static class Data {
        private List<String> value;

        //这样相当于把这个数据变成public
        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }

    private static class SnapshotData {
        private List<String> value;

        public List<String> getValue() {
            return new ArrayList(value);
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
