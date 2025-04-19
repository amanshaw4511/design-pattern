package org.example.structural.flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flyweight {
    public static void main(String[] args) {

    }
}

interface Graphic {
    void draw();
}

class Forest implements Graphic {
    private final List<Tree> trees;

    Forest(List<Tree> trees) {
        this.trees = trees;
    }

    @Override
    public void draw() {

    }
}

class Tree implements Graphic {
    private final int x;
    private final int y;
    private final TreeType treeType;

    Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }

    @Override
    public void draw() {

    }
}


class TreeType {
    private final String name;
    private final String type;
    private final String texture;

    TreeType(String name, String type, String texture) {
        this.name = name;
        this.type = type;
        this.texture = texture;
    }
}

class TreeTypeFactory {
    private static final Map<String, TreeType> cache = new HashMap<>();

    public static TreeType getTreeType(String name, String type, String texture) {
        var key = name + type + texture;
        if (!cache.containsKey(key)) {
            cache.put(key, new TreeType(name, type, texture));
        }
        return cache.get(key);
    }
}