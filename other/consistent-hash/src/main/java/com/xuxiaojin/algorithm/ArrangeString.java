package com.xuxiaojin.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ArrangeString {
    private static List<String> res = new ArrayList<>();

    private static void solve(List<Character> tmp, boolean[] visited, String c) {
        if (tmp.size() == c.length()) {
            String t = "";
            for (Character character : tmp) {
                t += character;
            }
            res.add(t);
            return;
        }

        for (int i = 0; i < c.length(); i++) {
            if (visited[i] == false) {
                visited[i] = true;
                tmp.add(c.charAt(i));
                solve(tmp, visited, c);
                visited[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        solve(new ArrayList<>(), new boolean[3], "abc");
        System.out.println(res);
    }
}
