package com.xuxiaojin;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRouter<T extends Node> {
    final SortedMap<Long, VirtualNode<T>> map = new TreeMap<>();
    final HashFunction hashFunction;


    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount) {
        this(pNodes, vNodeCount, new MD5HashFunction());
    }

    public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount, HashFunction hashFunction) {
        this.hashFunction = hashFunction;
        for (T p : pNodes) {
            addNode(p, vNodeCount);
        }
    }

    private void addNode(T p, int vNodeCount) {
        int existingReplicas = getExistingReplicas(p);
        for (int i = 0; i < vNodeCount; i++) {
            VirtualNode<T> virtualNode = new VirtualNode<>(p, existingReplicas + i);
            map.put(hashFunction.hash(virtualNode.getKey()), virtualNode);
        }
    }

    public void removeNode(T p) {
        Iterator<Long> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Long it = iterator.next();
            VirtualNode<T> virtualNode = map.get(it);
            if (virtualNode.isPhysicNode(p)) {
                iterator.remove();
            }
        }
    }

    public T routeNode(String objectKey) {
        if (map.isEmpty()) {
            return null;
        }
        SortedMap<Long, VirtualNode<T>> cur = map.tailMap(hashFunction.hash(objectKey));
        Long hashVal = !cur.isEmpty() ? cur.firstKey() : map.firstKey();
        return map.get(hashVal).getPhysicNode();
    }

    private int getExistingReplicas(T p) {
        int replica = 0;
        for (VirtualNode<T> node : map.values()) {
            if (node.isPhysicNode(p)) {
                replica++;
            }
        }
        return replica;
    }

    private static class MD5HashFunction implements HashFunction {

        MessageDigest instance;

        public MD5HashFunction() {
            try {
                instance = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        @Override
        public long hash(String key) {
            instance.reset();
            instance.update(key.getBytes());
            byte[] digest = instance.digest();
            long h = 0;
            for (int i = 0; i < 4; i++) {
                h <<= 8;
                h |= ((int) digest[i]) & 0xFF;
            }
            return h;
        }
    }
}
