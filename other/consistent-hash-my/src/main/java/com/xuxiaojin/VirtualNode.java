package com.xuxiaojin;

public class VirtualNode<T extends Node> implements Node {
    final T physicNode;
    final int index;

    public VirtualNode(T physicNode, int index) {
        this.physicNode = physicNode;
        this.index = index;
    }


    @Override
    public String getKey() {
        return physicNode.getKey() + "-" + index;
    }

    public boolean isPhysicNode(T pNode) {
        return physicNode.getKey().equals(pNode.getKey());
    }

    public T getPhysicNode() {
        return physicNode;
    }
}
